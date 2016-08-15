package org.gocom.euler.demo3.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.gocom.euler.demo3.entity.ProductEntity;
import org.gocom.euler.demo3.entity.SalesItemEntity;
import org.gocom.euler.demo3.entity.SalesItemSummary;
import org.gocom.euler.demo3.entity.SalesItemType;
import org.gocom.euler.demo3.service.IJsonBuidler;
import org.gocom.euler.demo3.service.JsonTemplateService;
import org.gocom.euler.demo3.service.ProductService;
import org.gocom.euler.demo3.service.SalesItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/model")
public class RestController {
	@Autowired
	private SalesItemService salesItemService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private JsonTemplateService jsonTemplateService;
	
	@Value("${application.sales.tendency.message:Sales Tendency Message}")
	private String tendencyMessage = "";
	
	@Value("${application.sales.month.message:Sales Month Message}")
	private String salesMonthMessage = "";
	
	/**
	 * 销售月报
	 * @return
	 */
	@RequestMapping("/month")
	public Object salesMonth(){//读取并获得json信息
		final Map<String, Object> model = new HashMap<String, Object>();
		String productName= "product1";
		ProductEntity byCode = productService.getByCode(productName);
		for (SalesItemType itemType : SalesItemType.values()){
			SalesItemSummary[] findByType = salesItemService.findByProduct(byCode,itemType.name());
			int[] array = new int[12];
			for (SalesItemSummary salesItemlSummary : findByType) {
				array[salesItemlSummary.getMonth()] = salesItemlSummary.getSumNumber();
			}
			for (int i = 0; i < array.length; i++) {
				if(i > 0){
					array[i] += array[i - 1];//堆叠
				}
			}
			model.put(itemType.name(), array);
		}
		Object buildJson = jsonTemplateService.buildJson("month", new IJsonBuidler() {
			public Object build(String jsonTemplate) {
				JSONObject parseObject = JSON.parseObject(jsonTemplate);
				Object object = parseObject.get("series");
				if(object instanceof JSONArray){
					JSONArray jsonArray = (JSONArray) object;
					for (int i = 0; i < jsonArray.size(); i++) {
						JSONObject object2 = (JSONObject) jsonArray.get(i);
						String string = object2.getString("id");
						Object type = model.get(string);
						object2.put("data", type);
					}
				}
				return parseObject.toJSONString();
			}
		});
		return buildJson;
	}
	
	@RequestMapping("/list")
	public String list() {
		List<SalesItemEntity> messages = this.salesItemService.findAll();
		for (SalesItemEntity salesItemEntity : messages) {
			salesItemEntity.setProduct(null);
		}
		return JSONObject.toJSONString(messages);
	}
	
	
	/**
	 * 创建请求
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public boolean createItem(@Valid SalesItemEntity message) {
		ProductEntity product = productService.getByCode("product1");
		message.setProduct(product);
		message.setCreateById(1);
		message.setCreateDate(new Date());
		message.setUpdateById(1);
		message.setUpdateDate(new Date());
		message.setCode("item" + message.getId());
		message = this.salesItemService.save(message);
		return true;
	}
	
	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") Long id) {
		this.salesItemService.deleteMessage(id);
		return true;
	}
}
