package com.chetan.e_commerse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info=@Info(
		title="E_commerces rest api",
		description="ecommersce rest api for interview",
		version="v1",
		contact=@Contact(
				name = "chetan dandekar",
				email="chetandandekara@gmail.com",
				url = "tel:+919876543210" )
		))
@SpringBootApplication
public class E_CommerseApplication {

	public static void main(String[] args) {
		SpringApplication.run(E_CommerseApplication.class, args);
	}

}
