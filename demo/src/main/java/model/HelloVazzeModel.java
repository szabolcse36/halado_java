package model;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Required;

import lombok.Data;

@Data
public class HelloVazzeModel {
	
	@Min(18)
	private int a;
	private int b;
	private int c;
	
}
