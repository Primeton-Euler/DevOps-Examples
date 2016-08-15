package org.gocom.euler.demo3.repository;

import org.gocom.euler.demo3.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * 
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	ProductEntity findByCode(String code);
}
