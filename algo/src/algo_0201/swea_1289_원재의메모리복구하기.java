package algo_0201;

import java.util.Scanner;

public class swea_1289_원재의메모리복구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < T; i++) {
			String str = sc.nextLine();
			int len = str.length();
			int cnt = 0;
			if(str.charAt(0) == '1')
				cnt++;
			
			for(int j = 1; j < len; j++) {
				if(str.charAt(j) != str.charAt(j-1)) {
					cnt++;
				}
			}
			System.out.println("#" + (i+1) + " " + cnt);
		}
		
	}
}
