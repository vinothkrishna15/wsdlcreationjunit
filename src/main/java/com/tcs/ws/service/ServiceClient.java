/**
 * 
 */
package com.tcs.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ws.config.WebserviceTemplateExtended;

import hello.wsdl.GetEmployeeRequest;
import hello.wsdl.GetEmployeeResponse;


/**
 * @author TCS
 *
 */
@Service("serviceLayer")
public class ServiceClient {
	
	@Autowired
	WebserviceTemplateExtended templateExtended;
	
	public GetEmployeeResponse getEmployeeDetails(String name) {
		GetEmployeeRequest request = new GetEmployeeRequest();
		request.setName(name);
		GetEmployeeResponse response = (GetEmployeeResponse) templateExtended.getMarshalSupport(request);
		return response;
}
}
