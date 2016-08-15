/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月21日 上午1:02:31
 *******************************************************************************/


package org.gocom.euler.demo3.service;

import org.gocom.euler.demo3.entity.ProductEntity;

/**
 * 
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */

public interface ProductService {
	
	/**
	 * 
	 * @param productCode
	 * @return
	 */
	ProductEntity getByCode(String productCode);
	
}
