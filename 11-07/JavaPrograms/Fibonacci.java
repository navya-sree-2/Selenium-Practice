package JavaPrograms;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		fib(n);
		
		sc.close();
	}
	
	static void fib(int n) {
		if(n == 0) {
			return;
		}
		else if(n == 1) {
			System.out.println(0);
			return;
		}
		int a = 0, b = 1;
		System.out.println(a + "\n" + b);
		for(int i=2; i<n; i++) {
			int c = a+b;
			System.out.println(c);
			a = b;
			b = c;
		}
	}

}
