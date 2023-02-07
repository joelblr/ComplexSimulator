package company;

//import java.util.Scanner;
//Make a super class (say Boss), which gives the % for salary calculation.
public class Employee {

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

		/*use Design.printBox(...);
		 * to get inputs
		 */
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
		this.salary = getBasic() * (1 + Constants.getConst() ) + 5000;
	}

}
