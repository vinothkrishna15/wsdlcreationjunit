/**
 * 
 */
package com.tcs.ws.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * @author TCS
 *
 */
public class WebserviceTemplateExtended extends WebServiceGatewaySupport {

	
	public Object getMarshalSupport(Object request) {
		return getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://10.144.135.147:8090/ws/getEmployeeResponse"));
		
	}
	
}
