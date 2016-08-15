/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年4月21日 上午10:20:57
 *******************************************************************************/


package org.gocom.euler.demo3.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gocom.euler.demo3.entity.ProductEntity;
import org.gocom.euler.demo3.entity.SalesItemEntity;
import org.gocom.euler.demo3.entity.SalesItemSummary;
import org.gocom.euler.demo3.repository.SalesItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 *
 * @author YU J LIN (mailto:yujl@primeton.com)
 */
@Service
public class SalesItemServiceImpl implements SalesItemService {
	
	@Autowired
	private SalesItemRepository salesItemRepository;
	
	public List<SalesItemEntity> findAll() {
		return salesItemRepository.findAll();
	}

	public SalesItemEntity save(SalesItemEntity salesItem) {
		if(salesItem == null){
			// TODO 异常处理及记录日志
			return null;
		}
		return salesItemRepository.save(salesItem);
	}

	@SuppressWarnings("rawtypes")
	public Map<String,SalesItemSummary> findByProduct(ProductEntity product) {
		if(product == null){
			// TODO 异常处理及记录日志
			return new HashMap<String,SalesItemSummary>();
		}
		List findByType = salesItemRepository.findByProduct(product);
		Map<String,SalesItemSummary> result = new HashMap<String,SalesItemSummary>();
		int sum = 0;
		for (Object object : findByType) {
			if(object instanceof SalesItemSummary){
				result.put(((SalesItemSummary) object).getType(),(SalesItemSummary) object);
			}else if(object instanceof Object[]){
				SalesItemSummary itemlSummary = new SalesItemSummary();
				Object[] array = (Object[]) object;
				for (Object object2 : array) {
					if(object2 instanceof ProductEntity){
						itemlSummary.setProduct((ProductEntity) object2);
					}else if(object2 instanceof String){
						itemlSummary.setType(object2.toString());
					}else if(object2 instanceof Long){
						itemlSummary.setSumNumber(Integer.valueOf(object2.toString()));
						sum += Integer.valueOf(object2.toString());
					}
				}
				result.put(itemlSummary.getType(),itemlSummary);
			}
		}
		if(sum > 0){
			for (String key : result.keySet()) {
				SalesItemSummary salesItemSummary = result.get(key);
				salesItemSummary.setPercent(Math.ceil(salesItemSummary.getSumNumber()*100/sum));
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.gocom.euler.demo2.service.SalesItemService#findByProduct(org.gocom.euler.demo2.entity.ProductEntity, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	public SalesItemSummary[] findByProduct(ProductEntity product, String itemType) {
		if(product == null){
			// TODO 异常处理及记录日志
			return new SalesItemSummary[0];
		}
		List findByType = salesItemRepository.findByProduct(product,itemType);
		List<SalesItemSummary> result = new ArrayList<SalesItemSummary>();
		for (Object object : findByType) {
			if(object instanceof SalesItemSummary){
				result.add((SalesItemSummary) object);
			}else if(object instanceof Object[]){
				SalesItemSummary itemlSummary = new SalesItemSummary();
				Object[] array = (Object[]) object;
				for (Object object2 : array) {
					if(object2 instanceof ProductEntity){
						itemlSummary.setProduct((ProductEntity) object2);
					}else if(object2 instanceof String){
						itemlSummary.setType(object2.toString());
					}else if(object2 instanceof Long){
						itemlSummary.setSumNumber(Integer.valueOf(object2.toString()));
					}else if(object2 instanceof Date){
						Calendar cal = Calendar.getInstance();
						cal.setTime((Date) object2);
						int month = cal.get(Calendar.MONTH);
						itemlSummary.setMonth(month);
					}else if(object2 instanceof Integer){
						itemlSummary.setMonth((Integer) object2);
					}
				}
				result.add(itemlSummary);
			}
		}
		
		return result.toArray(new SalesItemSummary[0]);
	}

	public void deleteMessage(Long id) {
		salesItemRepository.delete(id);
	}

}
