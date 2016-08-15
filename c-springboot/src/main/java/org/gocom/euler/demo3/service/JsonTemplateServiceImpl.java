/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月22日 下午5:25:51
 *******************************************************************************/


package org.gocom.euler.demo3.service;

import org.gocom.euler.demo3.entity.JsonTemplateEntity;
import org.gocom.euler.demo3.repository.JsonTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */
@Service
public class JsonTemplateServiceImpl implements JsonTemplateService{

	
	@Autowired
	private JsonTemplateRepository jsonTemplateRepository;
	
	public Object buildJson(String key, IJsonBuidler buidler) {
		JsonTemplateEntity findJsonTemplateByKey = jsonTemplateRepository.findJsonByTemplateKey(key);
		return buidler.build(findJsonTemplateByKey.getTemplateValue());
	}

}
