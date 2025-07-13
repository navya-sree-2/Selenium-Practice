package Jul12;

public class AgeException extends Exception {
	private int age;
	public AgeException(int age1) {
		age = age1;
		
	}
	public String toString() {
		return age + " invalid age";
	}
	
}
