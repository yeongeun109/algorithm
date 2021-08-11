package algo_0412;

import java.util.Scanner;

public class bj_16472_고냥이 {

	static int N;
	static int[] alph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String str = sc.next();
		alph = new int[26];
		alph[str.charAt(0) - 97]++;
		
		String tmp = "";
		tmp += str.charAt(0);
		int p1 = 0, p2 = 0, max = 0;
		
		for(int i = 1; i < str.length(); i++) {
			p2++;
			tmp = str.substring(p1, p2+1);
			alph[str.charAt(p2) - 97]++;

			if(check(tmp) <= N) {
			}else {
				while(check(tmp) > N) {
					alph[str.charAt(p1) - 97]--;
					p1++;
					tmp = str.substring(p1, p2+1);
				}
			}
			max = Math.max(max, tmp.length());
		}
		System.out.println(max);
	}

	private static int check(String tmp) {
		int cnt = 0;
		for(int i = 0; i < 26; i++) {
			if(alph[i] > 0)
				cnt++;
		}
		
		return cnt;
	}

}
