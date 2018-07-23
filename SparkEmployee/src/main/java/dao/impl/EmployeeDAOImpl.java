package dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;

import dao.EmployeeDAO;
import exception.EmployeeException;
import model.EmployeeEntity;

public class EmployeeDAOImpl implements EmployeeDAO {

	StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	SessionFactory  sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();

	
	@Override
	public Collection<EmployeeEntity> getEmployees() throws EmployeeException {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		List<EmployeeEntity> employeeList = session.createQuery("from EmployeeEntity").list();

		// List<Employee> newEmployeeList = new ArrayList<>();
//		employeeList.forEach(employee -> {
//			newEmployeeList.add( new Employee(employee.getId(), employee.getFname(), employee.getLname(), employee.getEmail()));
//			
//		});
		session.getTransaction().commit();
		session.close();
		return employeeList;
	}

	@Override
	public void addEmployees(EmployeeEntity em) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(em);
		session.getTransaction().commit();
		session.close();
	}

}
