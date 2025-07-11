package JavaPrograms;

import java.util.Scanner;

public class Prime {
	static boolean isPrime[] = new boolean[100010];
	static void sieve() {
		int n = 100000;
		for(int i=0;i<n;i++) {
			isPrime[i]=true;
		}
		int sq = (int)Math.sqrt(n);
		isPrime[0] = isPrime[1] = false;
		for(int i=2;i<=sq;i++) {
			if(isPrime[i]) {
				for(int j=i*i;j<=n;j+=i) {
					isPrime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sieve();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(isPrime[n]) {
			System.out.println("Prime number");
		}
		else {
			System.out.println("Not prime number");
		}

		sc.close();
	}

}
