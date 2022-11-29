package com.enigmacamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 29/11/22
 */

@RestController
@RequestMapping("/hello")
public class HelloController {
	@GetMapping()
	public String sayHello1() {
		return "hello!";
	}

	@GetMapping("/{name}")
	public String sayHello2(@PathVariable("name") String name) {
		return "hello! " + name;
	}
}
