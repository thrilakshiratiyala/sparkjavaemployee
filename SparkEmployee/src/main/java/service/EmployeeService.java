package service;

import java.util.Collection;

import exception.EmployeeException;
import model.EmployeeEntity;

public interface EmployeeService {

	public Collection<EmployeeEntity> getEmployees() throws EmployeeException;

	public void addUser(EmployeeEntity employeeEntity);
	
	
}
