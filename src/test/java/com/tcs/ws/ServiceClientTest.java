/**
 * 
 */
package com.tcs.ws;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tcs.ws.config.WebserviceTemplateExtended;
import com.tcs.ws.service.ServiceClient;
import com.tcs.ws.wsdl.Employee;
import com.tcs.ws.wsdl.GetEmployeeRequest;
import com.tcs.ws.wsdl.GetEmployeeResponse;


/**
 * @author TCS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceClientTest {

	@Mock
	WebserviceTemplateExtended templateExtended;
	
	@InjectMocks
	ServiceClient serviceClient;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Process mock annotations
				MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testEmployeeServiceClient() {
		GetEmployeeRequest request = new GetEmployeeRequest();
		request.setName("madan");
		// Mocking the response
		Employee emp = new Employee();
		emp.setDesignation("as");
		emp.setId(12);
		emp.setName("madan");
		// emp.setRole();
		GetEmployeeResponse res = new GetEmployeeResponse();
		res.setEmployee(emp);
		Mockito.when((templateExtended.getMarshalSupport(Mockito.anyObject()))).thenReturn(res);
		GetEmployeeResponse actual = serviceClient.getEmployeeDetails("madan");
		assertEquals(res, actual);
	}

}
