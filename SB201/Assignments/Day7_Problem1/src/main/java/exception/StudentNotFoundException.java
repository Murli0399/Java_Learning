package exception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String e) {
		super(e);
	}
}
