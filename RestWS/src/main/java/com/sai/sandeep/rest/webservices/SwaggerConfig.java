package com.sai.sandeep.rest.webservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		final Contact DEFAULT_CONTACT = new Contact("Sai Sandeep", "saisandeep.com", "sai9@gmail.com");
		final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome Api Documentation", "Api Documentation", "1.0", "urn:tos",
				DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

		Set<String> DEFAULT_PRODUCES_AND_CONSUMES= new HashSet<>(Arrays.asList("application/json","application/xml"));
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
}
