package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.service.IWishMsgService;

@Controller
public class WishMessageGenratorController {
	@Autowired
	private IWishMsgService service;

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	@RequestMapping("/wish")
	public ModelAndView genearteWishMsg() {
		String result=service.generateWishMsg();
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("wmsg", result);
//		mav.setViewName("display");
//		return mav;
		return new ModelAndView("display", "wmsg", result);
	}
	@RequestMapping("/wish")
	public String genearteWishMsg(ModelMap map) {
		System.out.println("Shared Meomory"+map.getClass());
		String result=service.generateWishMsg();
		map.addAttribute("wmsg", result);
		return "display";
	}
}
