package company;

import design.*;
import java.util.*;


public class Boss {

	HashMap<String, Employee> team = new HashMap<String, Employee>();
//	Scanner scn = new Scanner(System.in);

	public void hireEmployee() {
		Employee e = new Employee();
		team.put(e.getID(), e);
	}

	public void fireEmployee() {
		List<String> stdin = 
				Design.printBox(
						"ENTER EMPLOYEE-ID TO BE FIRED: $",
						" ".repeat(40)
					);
//		System.out.print("ENTER EMPLOYEE-ID TO BE FIRED: ");
//		String fired = scn.next();
		team.remove(stdin.get(0));
	}

	public void showNetwork() {

		System.out.println("\n     ID │ NAME      ");
		System.out.println(  "────────┼───────────");
		for (Map.Entry<String, Employee> node : team.entrySet() ) {
			if (7 - node.getKey().length() > 0)
				System.out.print(" ".repeat(7 - node.getKey().length()));
			System.out.println(node.getKey() + " │ " + node.getValue().getName());
		}
		System.out.println();
	}

}


