package algo_0202;

import java.util.Arrays;
import java.util.Scanner;

public class swea_Flatten {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			int dump = sc.nextInt();
			int arr[] = new int[100];
			
			for(int j = 0; j < 100; j++) {
				int h = sc.nextInt();
				arr[j] = h;
			}
			
			for(int j = 0; j < dump; j++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			
			Arrays.sort(arr);
			
			System.out.println("#" + (i+1) + " " + (arr[99] - arr[0]));
		}

	}

}
