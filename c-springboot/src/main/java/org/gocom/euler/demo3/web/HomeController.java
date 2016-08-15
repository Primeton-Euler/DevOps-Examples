package org.gocom.euler.demo3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	/**
	 * 销售月报
	 * @return
	 */
	@RequestMapping("month")
	public ModelAndView salesMonth(){
		return new ModelAndView("messages/home");
	}
	
	@RequestMapping("list")
	public ModelAndView list() {
		return new ModelAndView("messages/list");
	}
	
	/**
	 * 测试拦截器
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping("")
	public ModelAndView home(){
		return new ModelAndView("messages/home");
	}
	
	/**
	 * 跳转到创建界面
	 * @param message
	 * @return
	 */
	@RequestMapping(params = "form")
	public ModelAndView toForm() {
		return new ModelAndView("messages/form");
	}
	
	/**
	 * 跳转详细信息界面
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "view")
	public ModelAndView view() {
		return new ModelAndView("messages/view");
	}
}
