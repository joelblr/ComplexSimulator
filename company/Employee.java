package company;

//import java.util.Scanner;
//Make a super class (say Boss), which gives the % for salary calculation.
public class Employee extends Boss {

//	static Scanner sc = new Scanner(System.in);

	String name;
	int age;
	String id;
	char gender, type;
	double basic, salary;

	Employee() {
		inputDetails();
		calculateSalary();
	}

	void inputDetails() {

		System.out.print("ENTER EMPLOYEE NAME*: ");
		this.name = Bsc.nextLine();

		System.out.print("ENTER EMPLOYEE GRADE: ");
		this.type = Bsc.next().charAt(0);

		System.out.print("ENTER EMPLOYEE ID*: ");
		this.id = Bsc.next();
		Bsc.nextLine();//remove for next

//		System.out.print("ENTER EMPLOYEE AGE: ");
//		this.age = sc.nextInt();
//		System.out.print("ENTER EMPLOYEE GENDER(M/F): ");
//		this.gender = sc.next().charAt(0);
//		System.out.print("ENTER EMPLOYEE BASIC SALARY: ");
//		this.basic = sce.nextDouble();
	}

	String getID() {
		return this.id;
	}

	String getName() {
		return this.name;
	}

	double getBasic() {
		return this.basic;
	}

	double getSalary() {
		return this.salary;
	}

	void calculateSalary() {
		this.salary = getBasic() * (1 + Boss.getConst() ) + 5000;
	}

}
