package dp;

import java.util.Scanner;

public class MinimumOperations {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int test = kb.nextInt();
		for (int i = 0; i < test; i++) {
			int n = kb.nextInt();
			findWays(n);
		}
		kb.close();
	}

	private static void findWays(int n) {
		if (n == 0)
			return;
		
		int dp[][] = new int[n+1][2];
		
		dp[0][0] = 0;
		dp[0][1] = 1;
		
		
	}

}
