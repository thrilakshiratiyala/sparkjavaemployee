package exception;

public class EmployeeException extends Exception {
	
	String message;
	
	@Override
	public String getMessage() {
		message = "Custom failure";
		return message;
	}

}
