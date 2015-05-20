package com.sandy.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sandy.services.repository.EmployeeRepo;
import com.sandy.services.soap.DeleteEmployeeRequest;
import com.sandy.services.soap.DeleteEmployeeResponse;
import com.sandy.services.soap.Employee;
import com.sandy.services.soap.GetEmployeeRequest;
import com.sandy.services.soap.GetEmployeeResponse;
import com.sandy.services.soap.ListAllEmployeeRequest;
import com.sandy.services.soap.ListAllEmployeeResponse;
import com.sandy.services.soap.SaveEmployeeRequest;
import com.sandy.services.soap.SaveEmployeeResponse;
import com.sandy.services.soap.UpdateEmployeeRequest;
import com.sandy.services.soap.UpdateEmployeeResponse;

@Endpoint
public class EmployeeEndpoint {
	private static final String NAMESPACE_URI = "http://sandy.com/services/soap";
		
	@Resource
	private EmployeeRepo empRepo;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		response.setEmployee(empRepo.findOne(request.getEmpId()));
		return response;
	}
		
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveEmployeeRequest")
	@ResponsePayload
	public SaveEmployeeResponse saveEmployee(@RequestPayload SaveEmployeeRequest request) {
		SaveEmployeeResponse response = new SaveEmployeeResponse();
		response.setEmployee(empRepo.save(request.getEmployee()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		response.setEmployee(empRepo.save(request.getEmployee()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		empRepo.delete(request.getEmpId());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listAllEmployeeRequest")
	@ResponsePayload
	public ListAllEmployeeResponse listAllEmployee(@RequestPayload ListAllEmployeeRequest request) {		
		ListAllEmployeeResponse response = new ListAllEmployeeResponse();
		List<Employee> employeeList = new ArrayList<Employee>();
		Iterable<Employee> employeeIt = empRepo.findAll();
		for(Employee employee : employeeIt){
			employeeList.add(employee);
		}		
		response.getAllemployees().addAll(employeeList);
		return response;
	}
}
