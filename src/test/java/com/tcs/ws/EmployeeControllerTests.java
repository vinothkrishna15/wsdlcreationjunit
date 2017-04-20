/**
 * 
 */
package com.tcs.ws;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tcs.ws.controller.EmployeeController;
import com.tcs.ws.service.ServiceClient;
import com.tcs.ws.wsdl.Employee;
import com.tcs.ws.wsdl.GetEmployeeRequest;
import com.tcs.ws.wsdl.GetEmployeeResponse;



/**
 * @author TCS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { ServiceConfig.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTests {

//	private MockWebServiceServer mockServer;

	@Mock
	private ServiceClient client;

//	@Mock
//	private WebserviceTemplateExtended wsExtend;
//
//	@Mock
//	private WebServiceGatewaySupport wsGateway;
//
//	@Mock
//	private WebServiceTemplate wsT;

	@InjectMocks
	private EmployeeController empCont;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(empCont).build();
		//mockServer = MockWebServiceServer.createServer(client);
	}

	@Test
	public void testEmployeeServicee() throws Exception {
		// Mocking the request
		GetEmployeeRequest request = new GetEmployeeRequest();
		request.setName("arun");
		// Mocking the response
		Employee emp = new Employee();
		emp.setDesignation("as");
		emp.setId(12);
		emp.setName("arun");
		// emp.setRole();
		GetEmployeeResponse res = new GetEmployeeResponse();
		res.setEmployee(emp);

		// Mocking the marshal support
		Mockito.when(client.getEmployeeDetails(Mockito.anyString())).thenReturn(res);
		MvcResult result = this.mockMvc.perform(post("/getEmployee")
				.param("name", "arun"))
				.andReturn();
		
		assertEquals(200, result.getResponse().getStatus());
		
		// mockServer.verify();
	}

}
