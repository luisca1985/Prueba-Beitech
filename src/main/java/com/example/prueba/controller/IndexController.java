package com.example.prueba.controller;


import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String getIndexPage() {
		return "application";
		}
	}
