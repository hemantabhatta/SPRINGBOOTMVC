package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {

    @RequestMapping("/")
    public String ShowHomePage() {
	return "Home";
    }
}
