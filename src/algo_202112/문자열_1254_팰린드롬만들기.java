package algo_202112;

import java.util.Scanner;

public class 문자열_1254_팰린드롬만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		if (check(str))
			System.out.println(str.length());
		else {
			int maxPal = 0;
			int maxPalIdx = 0;
			for(int i = str.length() - 1; i >= 0; i--) {
				String tmp = str.substring(i);
				if(check(tmp)) {
					if(maxPal < tmp.length()) {
						maxPal = tmp.length();
						maxPalIdx = i;
					}
				}
			}
			
			String newStr = str.substring(0, maxPalIdx);
			System.out.println(str.length() + newStr.length());
		}
	}

	public static boolean check(String s) {
		for (int j = 0; j < s.length() / 2; j++) {
			if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
				return false;
			}
		}
		return true;
	}
}
