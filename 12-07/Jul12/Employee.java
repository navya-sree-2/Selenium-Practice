package Jul12;

import java.util.Scanner;
import Jul12.AgeException;

public class Employee {
	String name;
	int age;
	
	void getempdetails() throws AgeException {
		System.out.println("Enter your name:");
		Scanner sc=new Scanner(System.in);
		name=sc.next();
		
		System.out.println("Enter your age:");
		
		age=sc.nextInt();
		
		if(age<16)
		{
			throw new AgeException(age);
		}
		else {
			System.out.println("Valid age");
		}
	}
}
