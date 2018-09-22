package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
@RequestMapping("/viral")
	public String index() {
		return "viral";
	}

@RequestMapping("/challenge")
public String challenge(@RequestParam(value="name", required = false, defaultValue = "kiki") String name, Model model){
	model.addAttribute("name",name);
	return "challenge";
	}

@RequestMapping("/challenge/{name}")
public String challengePath(@PathVariable String name, Model model) {
	model.addAttribute("name", name);
	return "challenge";
	
}
/*@RequestMapping("/generator")
public String viralGenerator() {
		return "viral_generator";
	}*/

@RequestMapping("/generator")
public String viralGenerator (
		@RequestParam(value="a", defaultValue="1" ) int inputA, 
		@RequestParam(value="b", defaultValue="1" ) int inputB, 
		Model model) {

	String hasil = "h";
		for (int j = 0; j < inputA; j++) {
			hasil = hasil + "m";
		}
		if(inputA == 0) {
			hasil = hasil + "m";			
		}
		//hmmmmm
		String finalakhir = "";
		for(int i = 0; i < inputB; i++) {
			finalakhir = finalakhir + hasil + " "; 
		};
		if(inputB == 0) {
			finalakhir = hasil;			
		}
	
	//int result1 =  number1 * number2;
	//model.addAttribute("a", number1);
	//model.addAttribute("b", number2);
	model.addAttribute("result", finalakhir);
	model.addAttribute("nilaiA", inputA);
	model.addAttribute("nilaiB", inputB);
	
	
	return "viral_generator";
}


}
