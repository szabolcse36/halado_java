package hu.me.service;

import org.springframework.stereotype.Service;

@Service
public class SzorzasService {

	public double getEredmeny(HelloVazzeModel hellovazemodel){
		return hellovazemodel.getA() *
				hellovazemodel.getB() *
				hellovazemodel.getC();
	
}
}
