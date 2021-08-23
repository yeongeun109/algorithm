package algo_0420;

import java.util.Scanner;

public class bj_1110_더하기사이클 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = N;
		int cnt = 0;
		while(true) {			
			cnt++;
			int tmp = n;
			int sib = tmp / 10;
			int il = tmp % 10;
			if(n >= 10) {
				tmp = sib + il;
			}
			
			n = il * 10 + tmp % 10;
			if(n == N)
				break;
		}
		System.out.println(cnt);
	}

}
