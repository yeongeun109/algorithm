package algo_0209;

import java.util.Scanner;

public class bj_2475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int res = 0;
		for(int i = 0; i < 5; i++) {
			int a = sc.nextInt();
			res += Math.pow(a, 2);
		}
		
		res %= 10;
		System.out.println(res);
	}

}
