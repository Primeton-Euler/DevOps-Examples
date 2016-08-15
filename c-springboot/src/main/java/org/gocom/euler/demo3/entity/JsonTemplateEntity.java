/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月22日 下午5:07:49
 *******************************************************************************/


package org.gocom.euler.demo3.entity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="DEMO_JSON_TEMPLATE")
public class JsonTemplateEntity extends BaseEntity {

	private String templateKey;
	
	@Lob
	private String templateValue;

	public String getTemplateKey() {
		return templateKey;
	}

	public void setTemplateKey(String templateKey) {
		this.templateKey = templateKey;
	}

	public String getTemplateValue() {
		return templateValue;
	}

	public void setTemplateValue(String templateValue) {
		this.templateValue = templateValue;
	}

	
	
}
