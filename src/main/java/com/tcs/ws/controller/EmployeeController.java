/**
 * 
 */
package com.tcs.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ws.service.ServiceClient;
import com.tcs.ws.wsdl.Employee;
import com.tcs.ws.wsdl.GetEmployeeResponse;

/**
 * @author TCS
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	ServiceClient serviceClient;
	
	
	@RequestMapping("/getEmployee")
    public Employee empDetails(@RequestParam(value="name", defaultValue="") String name) {
		GetEmployeeResponse response = serviceClient.getEmployeeDetails(name);
		Employee emp = new Employee();
		if (response.getEmployee() != null) {
		emp.setName(response.getEmployee().getName());
		emp.setId(response.getEmployee().getId());
		emp.setDesignation(response.getEmployee().getDesignation());
		emp.setRole(response.getEmployee().getRole());
		}
        return emp;
	}
}
