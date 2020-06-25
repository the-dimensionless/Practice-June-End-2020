package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Q. You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. 
 * A pair (c, d) can follow another pair (a, b) 
 * if b < c. Chain of pairs can be formed in this fashion. Find the longest chain which can be formed 
 * from a given set of pairs.
 * 
 * For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }, 
 * then the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, 
 * {50, 90}}
 * 
 * 
 * @author sumitsingh
 *
 */
public class MaxLengthChain {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int nosPairs = kb.nextInt();
		Pair arr[] = new Pair[nosPairs];
		
		for (int i = 0; i < nosPairs; i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			Pair p = new Pair(x, y);
			arr[i] = p;
		}
		
		System.out.println(findMaxLengthChain (arr, nosPairs));
		
		// Following is for printing too
		findMaxLengthChainAndPrint(arr, nosPairs);
		kb.close();
	}

	private static int findMaxLengthChain(Pair[] arr, int nosPairs) {
		
		Arrays.sort(arr);
		
		int i, j, max = 0;
		
		// Like Longest Increasing Subsequence
		int dp[] = new int[nosPairs];
		
		Arrays.fill(dp, 1);		// Initial values to be 1
		
		for (i = 1; i < dp.length; i++) {
			for (j = 0; j < dp.length; j++) {
				if ( arr[i].x > arr[j].y && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		for ( i = 0; i < nosPairs; i++) 
			if (max < dp[i])
				max = dp[i];
		
		return max;
	}
	
	private static void findMaxLengthChainAndPrint(Pair[] arr, int nosPairs) {
		Arrays.sort(arr);
		
		int i, j;
		
		int dp[] = new int[nosPairs];
		Arrays.fill(dp, 1);		// Initial values to be 1
		
		String res = "";
		
		for (i = 1; i < dp.length; i++) {
			for (j = 0; j < dp.length; j++) {
				if ( arr[i].x > arr[j].y && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					res += arr[i].x + "," + arr[j].y;
				}
				res += " ";
			}
		}
		System.out.println(res);
	}
}

class Pair implements Comparable<Pair> {
	
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair that) {
		if (this.x < that.x)
			return -1;
		else 
			return 1;
	}
	
}

/*
 * Test : 
 * Pair arr[] = new Pair[] {new Pair(5,24), new Pair(15, 25), 
 *                          new Pair (27, 40), new Pair(50, 60)};
 *                          
 * EXPECTED: 3
 */