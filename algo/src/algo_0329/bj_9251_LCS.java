package algo_0329;

import java.util.Scanner;

public class bj_9251_LCS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int size1 = str.length();
		String arr1 = str;
		
		str = sc.nextLine();
		int size2 = str.length();
		String arr2 = str;
		
		int[][] dp = new int[size1 + 1][size2 + 1];
		
		for(int i = 1; i <= size1; i++) {
			for(int j = 1; j <= size2; j++) {
				if(arr1.charAt(i-1) == arr2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[size1][size2]);
	}

}
