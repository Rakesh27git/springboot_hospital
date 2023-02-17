package com.ty.springboot_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	public Docket getDocket() {
		Contact contact = new Contact("TYSS", "www.tyss.com", "tysupport@mail.com");

		List<VendorExtension> list = new ArrayList<>();

		ApiInfo info = new ApiInfo("Hospital_App", "hospital api v1.0", "version 1.0", "www.testyantra.global.com",
				contact, "testyantra", "www.tyss.com", list);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.springboot_project")).build().apiInfo(info)
				.useDefaultResponseMessages(false);
	}
}
