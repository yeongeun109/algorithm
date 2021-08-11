package algo_0203;

import java.util.Scanner;

public class swea_2805_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			int start = N/2;
			int yNum = 1;
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				int j = start;
				int cnt = 0;
				while(cnt < yNum) {
					sum += arr[i][j];
					cnt++;
					j++;
				}
				if(i < N/2) {
					start--;
					yNum += 2;
				}else {
					start++;
					yNum -= 2;
				}
				
			}
			
			System.out.println("#" + (t+1) + " " + sum);
		}
	}

}
