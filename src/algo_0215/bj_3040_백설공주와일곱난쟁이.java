package algo_0215;

import java.util.Arrays;
import java.util.Scanner;

public class bj_3040_백설공주와일곱난쟁이 {

	static int arr[] = new int[9];
	static int selected[] = new int[9];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		comb(0, 0);
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 9; i++) {
				sum += selected[i];
			}
			
			if(sum == 100) {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < 7; i++)
					sb.append(selected[i]).append("\n");
				System.out.println(sb);
			}
				
			return;
		}
		
		for(int i = start; i < 9; i++) {
			selected[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
}
