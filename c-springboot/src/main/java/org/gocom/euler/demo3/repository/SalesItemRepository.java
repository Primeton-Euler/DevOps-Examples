/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月21日 上午5:37:15
 *******************************************************************************/


package org.gocom.euler.demo3.repository;

import java.util.List;

import org.gocom.euler.demo3.entity.ProductEntity;
import org.gocom.euler.demo3.entity.SalesItemEntity;
import org.gocom.euler.demo3.entity.SalesItemSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */

public interface SalesItemRepository extends JpaRepository<SalesItemEntity, Long>{

	@Query("select s.product as product, s.type as type, sum(s.number) as sumNumber "
			+ "from SalesItemEntity s left outer join s.product p where s.product = ?1 group by s.type")
	List<SalesItemSummary> findByProduct(ProductEntity product);
	
	@Query("select s.product as product, s.type as type, sum(s.number) as sumNumber, month(s.updateDate) as month "
			+ "from SalesItemEntity s left outer join s.product p where s.product = ?1 and s.type = ?2 group by month(s.updateDate)")
	List<SalesItemSummary> findByProduct(ProductEntity product,String itemType);
	
}

