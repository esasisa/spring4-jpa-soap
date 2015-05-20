package com.sandy.services.repository;

import org.springframework.data.repository.CrudRepository;

import com.sandy.services.soap.Employee;

public interface EmployeeRepo  extends CrudRepository<Employee, Integer>{

}
