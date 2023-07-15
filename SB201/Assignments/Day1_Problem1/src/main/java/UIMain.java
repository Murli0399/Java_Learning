
import java.util.List;
import java.util.Scanner;

public class UIMain {

	static void deleteEmployeeById(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			System.out.println(dao.deleteEmployeeById(id));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void giveBonusToEmployee(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		System.out.print("Enter Salary : ");
		int salary = sc.nextInt();
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			System.out.println(dao.giveBonusToEmployee(id, salary));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void getAllEmployee() {
		EmployeeDAO dao = new EmployeeDAOImpl();

		List<Employee> emp = dao.getAllEmployee();
		emp.forEach(System.out::println);

	}

	static void getEmployeeById(Scanner sc) {

		System.out.print("Enter Id : ");
		int id = sc.nextInt();

		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			Employee emp = dao.getEmployeeById(id);
			System.out.println("Employee Id : " + emp.getEmpId() + ", Name : " + emp.getName() + ", Address : "
					+ emp.getAddress() + ", Salary : " + emp.getSalary());
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void registerEmployee(Scanner sc) {
		System.out.print("Enter Name : ");
		String name = sc.next();
		System.out.print("Enter Address : ");
		String address = sc.next();
		System.out.print("Enter Salary : ");
		int salary = sc.nextInt();

		Employee obj = new Employee(name, address, salary);
		EmployeeDAO dao = new EmployeeDAOImpl();
		System.out.println(dao.registerEmployee(obj));

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {

			System.out.println("1. Register Employee");
			System.out.println("2. Get Employee By Id");
			System.out.println("3. Get All Employee");
			System.out.println("4. Delete Employee By Id");
			System.out.println("5. Update Salary By Id");
			System.out.print("Enter Selection : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				registerEmployee(sc);
				break;
			case 2:
				getEmployeeById(sc);
				break;
			case 3:
				getAllEmployee();
				break;
			case 4:
				deleteEmployeeById(sc);
				break;
			case 5:
				giveBonusToEmployee(sc);
				break;

			case 0:
				System.out.println("Thank you");
				break;
			}

		} while (choice != 0);
	}

}
