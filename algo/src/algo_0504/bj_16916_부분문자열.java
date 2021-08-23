package algo_0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_16916_부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		String P = in.readLine();
		
		boolean res = kmp(S, P);
		if(res)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static boolean kmp(String s, String p) {
		boolean flag = false;
		int[] fail = getFail(p);
		int n = s.length();
		int m = p.length();
		int j = 0;
		for(int i = 0; i < n; i++) {
			while(j > 0 && s.charAt(i) != p.charAt(j))
				j = fail[j - 1];
			if(s.charAt(i) == p.charAt(j)) {
				if(j == m - 1) {
					flag = true;
					break;
				}else
					j++;
			}
		}
		return flag;
	}

	private static int[] getFail(String p) {
		int m = p.length();
		int j = 0;
		int[] fail = new int[m];
		for(int i = 1; i < m; i++) {
			while(j > 0 && p.charAt(i) != p.charAt(j))
				j = fail[j - 1];
			if(p.charAt(i) == p.charAt(j))
				fail[i] = ++j;
		}
		return fail;
	}

}
