/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月21日 上午10:42:39
 *******************************************************************************/


package org.gocom.euler.demo3.service;

import org.gocom.euler.demo3.entity.ProductEntity;
import org.gocom.euler.demo3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */
@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	/* (non-Javadoc)
	 * @see org.gocom.euler.demo2.service.ProductService#getByCode(java.lang.String)
	 */
	public ProductEntity getByCode(String productCode) {
		return productRepository.findByCode(productCode);
	}

}
