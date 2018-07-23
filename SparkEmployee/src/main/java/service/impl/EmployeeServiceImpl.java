package service.impl;

import java.util.Collection;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import exception.EmployeeException;
import model.EmployeeEntity;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	

	EmployeeDAO EmployeeDao = new EmployeeDAOImpl();  
	@Override
	public Collection<EmployeeEntity> getEmployees() throws EmployeeException {
		return EmployeeDao.getEmployees();
	}
	@Override
	public void addUser(EmployeeEntity em) {
		EmployeeDao.addEmployees(em);
		
	}

}
