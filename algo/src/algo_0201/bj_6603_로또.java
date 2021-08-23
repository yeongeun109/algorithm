package algo_0201;

import java.util.Scanner;

public class bj_6603_로또 {
	static int arr[];
	static int numbers[] = new int[6];
	static int k;
	
	static void lotto(int cnt, int start) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < k; i++) {
			numbers[cnt] = arr[i];
			lotto(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			k = sc.nextInt();
			if(k == 0)
				break;
			
			arr = new int[k];
			
			for(int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			
			lotto(0,0);
			System.out.println();
		}
		
	}

}
