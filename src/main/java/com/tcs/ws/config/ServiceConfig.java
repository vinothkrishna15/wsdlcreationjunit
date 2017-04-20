package com.tcs.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ServiceConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.tcs.ws.wsdl");
		return marshaller;
	}
	@Bean
	public WebserviceTemplateExtended serviceClient(Jaxb2Marshaller marshaller) {
		WebserviceTemplateExtended client = new WebserviceTemplateExtended();
		client.setDefaultUri("http://10.144.135.147:8090/ws/employees.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
