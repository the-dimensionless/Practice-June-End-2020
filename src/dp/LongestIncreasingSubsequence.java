package dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Given a sequence A of size N, find the length of the longest increasing subsequence from a given sequence .
	The longest increasing subsequence means to find a subsequence of a given sequence in which the 
	subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as 
	long as possible. This subsequence is not necessarily contiguous, or unique.
	Note: Duplicate numbers are not counted as increasing subsequence.
	
	Example:
	Input:
	2
	16
	0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
	6
	5 8 3 7 9 1
	Output:
	6
	3
 * 
 * 
 * @author sumitsingh
 *
 */

public class LongestIncreasingSubsequence {
	
	static int global_max;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int testCases = kb.nextInt();
		
		for (int i = 0; i < testCases; i++) {
			int n = kb.nextInt();
			
			kb.nextLine();
			
			int arr[] = Stream.of(kb.nextLine().split(" ")).mapToInt(
					Integer::parseInt).toArray();
			
			global_max = 1;
			
			System.out.println("Recursive answer  ->  " + findLISRecursively(arr, n));
			System.out.println("Dynamic answer -> " + findLISByDP(arr, n));
		}
		kb.close();
	}

	private static int findLISByDP(int[] arr, int n) {
		
		int dp[] = new int[n];
		
		int max = 0;
		
		Arrays.fill(dp, 1);
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + 1)
					dp[i] = dp[j] + 1;
			}
		}
		
		for (int i = 0; i < n ; i++) {
			if (max < dp[i])
				max = dp[i];
		}
		
		return max;
	}

	/**
	 * T O(2^n)
	 * S O(1)
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int findLISRecursively(int[] arr, int n) {
		
		if (n == 1)
			return 1;
		
		int res, maxEnd = 1;
		
		for (int i=1; i<n; i++) {
			res = findLISRecursively(arr, i);
			if (arr[i-1] < arr[n-1] && res + 1 > maxEnd) {
				maxEnd = res + 1;
			}
		}
		
		if (maxEnd > global_max) {
			global_max = maxEnd;
		}
		return maxEnd;
	}

}
