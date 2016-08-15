/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月21日 上午10:07:46
 *******************************************************************************/


package org.gocom.euler.demo3.entity;

/**
 * 
 * 订单汇总
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */
public class SalesItemSummary {
	private ProductEntity product;
	
	private String type;
	
	private Integer sumNumber = 0;
	
	private int month;
	
	private double percent;


	/**
	 * @return Returns the percent.
	 */
	public double getPercent() {
		return percent;
	}

	/**
	 * @param percent The percent to set.
	 */
	public void setPercent(double percent) {
		this.percent = percent;
	}

	/**
	 * @return Returns the product.
	 */
	public ProductEntity getProduct() {
		return product;
	}

	/**
	 * @param product The product to set.
	 */
	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Returns the sumNumber.
	 */
	public Integer getSumNumber() {
		return sumNumber;
	}

	/**
	 * @param sumNumber The sumNumber to set.
	 */
	public void setSumNumber(Integer sumNumber) {
		this.sumNumber = sumNumber;
	}

	/**
	 * @return Returns the month.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month The month to set.
	 */
	public void setMonth(int month) {
		this.month = month;
	}
}
