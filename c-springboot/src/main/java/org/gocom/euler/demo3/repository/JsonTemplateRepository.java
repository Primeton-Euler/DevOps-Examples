/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月22日 下午5:11:32
 *******************************************************************************/


package org.gocom.euler.demo3.repository;

import org.gocom.euler.demo3.entity.JsonTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO 此处填写 class 信息
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */

public interface JsonTemplateRepository  extends JpaRepository<JsonTemplateEntity, Long>{
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	JsonTemplateEntity findJsonByTemplateKey(String templateKey);
}
