package web;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;

import exception.EmployeeException;
import model.EmployeeEntity;
import model.StandardResponse;
import model.StatusResponse;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

public class EmployeeController {

	public static void main(String[] args) {

		//port(8080);
		EmployeeService employeeService = new EmployeeServiceImpl();		
		initialize();
		post("/employee",(req,res)->{
			res.type("application/json");
			employeeService.addUser(new Gson().fromJson(req.body(), EmployeeEntity.class));
			return new Gson().toJson(new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS)));
		});
		
		get("/employees",(req,res)->{			
			res.type("application/json");			
			return new Gson().toJson(employeeService.getEmployees());
		});
		
		exception(EmployeeException.class, (ex, req, res) -> {
			res.type("application/json");
		    res.body(new Gson().toJson(ex.getMessage()));
		});

	}
	
	private static void initialize() {
		EmployeeService employeeService = new EmployeeServiceImpl();	
		
		EmployeeEntity em1 = new EmployeeEntity(1,"James","Allen","jamesallen@gmail.com");
		employeeService.addUser(em1);
		EmployeeEntity em2 = new EmployeeEntity(2,"Snowy","Max","snowymax@gmail.com");
		employeeService.addUser(em2);
		
	}

}
