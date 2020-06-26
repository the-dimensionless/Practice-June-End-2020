package dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 
 * Q. Given a value V, if we want to make change for V cents, and we have 
 * infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is 
 * the minimum number of coins to make the change?
 * 
 * 
 	Input: coins[] = {25, 10, 5}, V = 30
	Output: Minimum 2 coins required
	We can use one coin of 25 cents and one of 5 cents 
	
	Input: coins[] = {9, 6, 5, 1}, V = 11
	Output: Minimum 2 coins required
	We can use one coin of 6 cents and 1 coin of 5 cents
 * 
 * @author sumitsingh
 *
 */
public class MinimumNumberOfCoins {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int nosCoins = kb.nextInt();
		int target = kb.nextInt();
		
		kb.nextLine();
		
		int coins[] = new int[nosCoins];
		
		// One line input
		coins = Stream.of(kb.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
//		Arrays.sort(coins);
		
		System.out.println(findRecursively(coins, nosCoins, target, 0));
		
		System.out.println(findByDP(coins, nosCoins, target));
		
		kb.close();
		
	}

	private static int findByDP(int[] coins, int nosCoins, int target) {
		
		int dp[] = new int[target + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nosCoins ; j++) {
				if (coins[j] < i) {
					 int sub = dp[i - coins[j]]; 
		             if (sub != Integer.MAX_VALUE && sub + 1 < dp[i]) 
	                       dp[i] = sub + 1; 
				}
			}
		}
		
		return dp[target];
	}

	private static int findRecursively(int[] coins, int nosCoins, int target, int index) {
		
		if (target <= 0 || index >= nosCoins)
			return index - 1;
		else
			return Math.min( findRecursively(coins, nosCoins, target, index + 1), 1 + findRecursively(coins, nosCoins, target - coins[index], index + 1));
	}

}
