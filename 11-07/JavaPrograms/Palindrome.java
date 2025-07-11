package JavaPrograms;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		String str = sc.next();
		
		System.out.println((isPalin(str)) ? "Palindrome" : "Not Palindrome");
		
		sc.close();
	}

	static boolean isPalin(String str) {
		
		int i=0, j=0, n=str.length();
		
		for(i=0,j=n-1; i<j; i++,j--) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}

}
