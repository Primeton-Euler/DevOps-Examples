/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Apr 19, 2016 5:27:12 PM
 *******************************************************************************/

package org.gocom.euler.demo3.core;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.gocom.euler.demo3.utils.ScriptRunner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
@Component("defaultDataSourceInitializer")
public class DataSourceInitializer implements BeanPostProcessor {
	
	private static final String SYSTEM_VAR_KEY = "datasource.autoinit.disabled"; //$NON-NLS-1$
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		if (disabled()) {
			return bean;
		}
		if (bean instanceof DataSource) {
			try {
				new Initializer() {

					@Override
					protected Connection getConnection() throws SQLException {
						return ((DataSource)bean).getConnection();
					}
					
				}.init();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	/**
	 * 
	 * @return
	 */
	protected boolean disabled() {
		String disabled = System.getProperty(SYSTEM_VAR_KEY);
		return null == disabled || 0 == disabled.trim().length() ? Boolean.FALSE : Boolean.valueOf(disabled);
	}
	
	/**
	 * 
	 * Initializer. <br>
	 *
	 * @author ZhongWen Li (mailto:lizw@primeton.com)
	 */
	public static abstract class Initializer {
		
		/**
		 * Use default DataSource bean as connection source,
		 * You can override this method in your euler-* system. <br>
		 * 
		 * @return
		 */
		protected abstract Connection getConnection() throws SQLException; /*{
			DataSource dataSource = BeanFactory.getBean(DataSource.class);
			return null == dataSource ? null : dataSource.getConnection();
		}*/
		
		/**
		 * 
		 * @return
		 */
		private Connection getConnection(long timeout) {
			Connection connection = null;
			long begin = System.currentTimeMillis();
			long end = begin;
			timeout = timeout < 1000L ? 1000L * 60 * 10 : timeout;
			while (end - begin <= timeout) {
				try {
					connection = getConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (connection == null) {
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					break;
				}
				end = System.currentTimeMillis();
			}
			if (null == connection) {
				throw new RuntimeException("An error occured while try to get JDBC Connection."); //$NON-NLS-1$
			}
			return connection;
		}
		
		/**
		 * 
		 * @return
		 */
		protected boolean inited() {
			final String sql = "SELECT COUNT(*) FROM demo_product";
			Connection connection = getConnection(-1);
			if (null == connection) {
				throw new RuntimeException("Can not get JDBC connection."); //$NON-NLS-1$
			}
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				stmt = connection.prepareStatement(sql);
				rs = stmt.executeQuery();
				return true;
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (Throwable t) {
				t.printStackTrace();
			} finally {
				close(rs, stmt, connection);
			}
			return false;
		}
		
		/**
		 * 
		 * @param closables
		 */
		protected void close(Object ... closables) {
			if (null == closables || 0 == closables.length) {
				return;
			}
			for (Object closable : closables) {
				if (closable instanceof Closeable) {
					try {
						((Closeable)closable).close();
					} catch (IOException e) {
					}
				} else {
					try {
						Method method = closable.getClass().getMethod("close"); //$NON-NLS-1$
						if (null != method){
							method.invoke(closable);
						}
					} catch (Throwable t) {
						t.printStackTrace();
					}
				}
			}
		}
		
		/**
		 * Execute SQL file if not inited. <br>
		 */
		public void init() {
			if (inited()) {
				return;
			}
			InputStream in = null;
			Reader reader = null;
			ScriptRunner runner = new ScriptRunner(getConnection(-1));
			runner.setAutoCommit(true);
			try {
				in = DataSourceInitializer.class.getResourceAsStream("/META-INF/sql/init.sql");
				if (null == in) {
					return;
				}
				reader = new InputStreamReader(in, "utf-8"); //$NON-NLS-1$
				runner.runScript(reader);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				close(reader, in);
			}
			runner.closeConnection();
		}
		
	}

}
