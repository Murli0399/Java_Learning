
public class EmployeeException extends Exception {
	EmployeeException(Exception e){
		super(e.getMessage());
	}
}
