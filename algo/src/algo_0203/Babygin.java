package algo_0203;

import java.util.Scanner;

public class Babygin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int[] arr = new int[6];
			int[] arr2 = new int[11];
			
			int babyCnt = 0;
			
			for(int j = 0; j < 6; j++) {
				arr[j] = sc.nextInt();
				arr2[arr[j]]++;
				
			}
			
			for(int j = 0; j < 10; j++) {
				if(arr2[j] >= 3) {
					babyCnt++;
					arr2[j] -= 3;
					
					j--;
					continue;
				}
				
				if(j >= 2) {
					if(arr2[j] != 0) {
						if(arr2[j-1] != 0 && arr2[j-2] != 0) {
							arr2[j]--;
							arr2[j+1]--;
							arr2[j+2]--;
							babyCnt++;
							j--;
						}
					}
				}
				
			}
			
			if(babyCnt == 2)
				System.out.println("#" + (i+1) + " yes");
			else
				System.out.println("#" + (i+1) + " no");
		}
	}

}
