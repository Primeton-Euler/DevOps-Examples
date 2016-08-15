/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月22日 下午5:18:02
 *******************************************************************************/


package org.gocom.euler.demo3.service;

public interface IJsonBuidler {

	/**
	 * 根据模板构造JSON对象
	 * @param jsonTemplate
	 * @param value
	 * @return
	 */
	Object build(String jsonTemplate);
}
