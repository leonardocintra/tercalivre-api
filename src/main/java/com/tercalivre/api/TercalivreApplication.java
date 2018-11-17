package com.tercalivre.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class TercalivreApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "API OK!";
	}

	public static void main(String[] args) {
		SpringApplication.run(TercalivreApplication.class, args);
	}
}
