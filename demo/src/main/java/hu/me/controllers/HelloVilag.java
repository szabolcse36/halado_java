package hu.me.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloVilag {

private SzorzasService szorzasService;
	
@Autowired
HelloVilag(SzorzasService szorzasService); 
this.SzorzasService szorzasService;

@ResponseBody	
	@GetMapping("/")
	
	//String helloVazze(@RequestParam(required=false) int a){
	String helloVazze(@Valid HelloVazzeModel helovazzemodel, BindingResult rossz);
	if (bindingResult.hasErrors(){
		return rossz;
	}
	else
	{
	return "HelloVazze";
	
	}
	return "eredmeny" + szorzasService.getEredmeny(hellovazzemodel);
			
		}
}
