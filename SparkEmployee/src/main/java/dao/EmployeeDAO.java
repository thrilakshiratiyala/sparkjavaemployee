package dao;

import java.util.Collection;

import exception.EmployeeException;
import model.EmployeeEntity;

public interface EmployeeDAO {
	
	public Collection<EmployeeEntity> getEmployees() throws EmployeeException;

	public void addEmployees(EmployeeEntity em);

}
