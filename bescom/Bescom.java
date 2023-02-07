package bescom;

import java.util.*;
public class Bescom {

	static Scanner sc = new Scanner(System.in);

	public LinkedHashMap <String, Double> units;
	String name, phno;//add ur credentials


	Bescom() {
		//a string key maps with a double value 
		units = new LinkedHashMap<String, Double>();
		/*set all the keys to 0
		 * ie, keys : "JAN", "FEB", "MAR", "APR"...."DEC"
		 * (ie, first 3 letters...)
		 */
	}


	/*This Method accepts a Month(ie, "JAN", "FEB"...or "DEC")
	 * and prints all the Details as u see in ur Electricity-BESCOM bill.
	 * Refer the snapshot**
	 * */
	public void printMonthBill() {
		//Scan a String from user and print all the details systematically 
	}


	/*This Method accepts user details like Name*, PhNo*...(add ur choices)
	 * and store them in the instance variables
	 * */
	public void getCredentials() {
		//Scan the Credentials from the user 
	}


	/*This Method accepts a Month(ie, "JAN", "FEB"...or "DEC") from the user,
	 * checks if, the month is present in the hashmap-units and accepts the units
	 * from the user and updates the units
	 * else, print/throw an exception
	 * */
	public void updateUnits() {
		//Scan a String Month,
		//if month is valid then accept units to update
		//else display/throw an error
	}


	/*This Method displays all the bills in a tabulated form like,
	<Month> <Units> <Tax> <FAC Charges> <Fixed Charges> <Energy Charges> <Net Charges>
	you can add to the above fields, but the above is atleast necessary
	 * */
	public void printAllBills() {
		//iterate thru the LinkedHashMap and display
	}


}
