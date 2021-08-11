package algo_0330;

import java.util.Scanner;
import java.util.Stack;

public class bj_9252_LCS2 {

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
		
		if(dp[size1][size2] != 0) {
			Stack<Character> st = new Stack<Character>();
			int x = size1;
			int y = size2;
			while(st.size() != dp[size1][size2]) {
				if(dp[x-1][y] == dp[x][y]) { //위
					x--;
				}else if(dp[x][y] == dp[x][y-1]) { //왼
					y--;
				}else { //대각선
					st.push(arr1.charAt(x-1));
					x--;
					y--;
				}
			}
			
			while(!st.isEmpty()) {
				System.out.print(st.pop());
			}
		}
	}

}
