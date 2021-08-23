package algo_0502;

import java.util.Scanner;

public class bj_2846_오르막길 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 0, max = 0, prev = 0;
		
		for(int i = 0; i < N; i++) {
			if(i == 0)
				num = sc.nextInt();
			else {
				int tmp = sc.nextInt();

				if(prev >= tmp) {
					num = tmp;
				}else {
					max = Math.max(max, tmp - num);
				}
				
				prev = tmp;
			}
		}
		System.out.println(max);
	}

}
