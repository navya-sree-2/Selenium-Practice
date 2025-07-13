package Jul12;

import java.util.Scanner;
import Jul12.AgeException;

public class ExceptionTest {

	public static void main(String[] args) throws AgeException {
		// TODO Auto-generated method stub
		try {
			Employee e = new Employee();
			e.getempdetails();
		}
		catch(AgeException e) {
			System.out.println(e);
		}
	}
}
