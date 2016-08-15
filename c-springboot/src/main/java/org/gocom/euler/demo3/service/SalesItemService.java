/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月21日 上午10:19:30
 *******************************************************************************/


package org.gocom.euler.demo3.service;

import java.util.List;
import java.util.Map;

import org.gocom.euler.demo3.entity.ProductEntity;
import org.gocom.euler.demo3.entity.SalesItemEntity;
import org.gocom.euler.demo3.entity.SalesItemSummary;

/**
 * TODO 此处填写 class 信息
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */

public interface SalesItemService {

	/**
	 * 查询所有的salesItem对象
	 * @return
	 */
	List<SalesItemEntity> findAll();
	
	/**
	 * 
	 * @param salesItem
	 * @return 
	 */
	SalesItemEntity save(SalesItemEntity salesItem);
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	Map<String,SalesItemSummary> findByProduct(ProductEntity product);
	
	/**
	 * 
	 * @param product
	 * @param itemType
	 * @return
	 */
	SalesItemSummary[] findByProduct(ProductEntity product,String itemType);

	/**
	 * 
	 * @param id
	 */
	void deleteMessage(Long id);
}
