/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月21日 上午12:35:06
 *******************************************************************************/


package org.gocom.euler.demo3.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 产品
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */
@Entity
@Table(name="DEMO_PRODUCT")
public class ProductEntity extends BaseEntity {
	//产品编码
	private String code;
	//产品显示名称
	private String displayName;
	//产品描述
	private String description;
	
	//销售清单
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	private List<SalesItemEntity> salesItemEntities = new LinkedList<SalesItemEntity>();

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code The code to set.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return Returns the displayName.
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName The displayName to set.
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Returns the salesItemEntities.
	 */
	public List<SalesItemEntity> getSalesItemEntities() {
		return salesItemEntities;
	}

	/**
	 * @param salesItemEntities The salesItemEntities to set.
	 */
	public void setSalesItemEntities(List<SalesItemEntity> salesItemEntities) {
		this.salesItemEntities = salesItemEntities;
	}
	
	
}
