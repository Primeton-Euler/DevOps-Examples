/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月22日 下午5:13:08
 *******************************************************************************/


package org.gocom.euler.demo3.service;

/**
 * TODO 此处填写 class 信息
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */

public interface JsonTemplateService {

	/**
	 * 
	 * @param code
	 * @return
	 */
	Object buildJson(String key,IJsonBuidler buidler);
}
