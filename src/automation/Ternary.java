package automation;

import java.util.Scanner;

public class Ternary {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		
		
	int time = 17;
	String result = (time < 18) ? "Good day." : "Good evening.";
	System.out.println(result);
	
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter an integer: ");
	int day = input.nextInt();
	switch (day) {
	  case 1:
	    System.out.println("Monday");
	    break;
	  case 2:
	    System.out.println("Tuesday");
	    break;
	  case 3:
	    System.out.println("Wednesday");
	    break;
	  case 4:
	    System.out.println("Thursday");
	    break;
	  case 5:
	    System.out.println("Friday");
	    break;
	  case 6:
	    System.out.println("Saturday");
	    break;
	  case 7:
	    System.out.println("Sunday");
	    break;
	  default:
		    System.out.println("Holidy");
		    break;
	}
}
}