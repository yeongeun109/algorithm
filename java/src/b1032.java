

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1032 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int i = 0, j = 0;
		boolean[] chkArr;
		
		String str = in.readLine();
		int len = str.length();
		char[] strArr = new char[len];
		for(i = 0; i < len; i++) {
			strArr[i] = str.charAt(i);
		}
		
		chkArr = new boolean[len];
		
		for(i = 0; i < N - 1; i++) {
			String tmp = in.readLine();

			for(j = 0; j < len; j++) {
				if(str.charAt(j) != tmp.charAt(j)) {
					chkArr[j] = true;
					strArr[j] = tmp.charAt(j);
				}
			}
		}
		
		for(i = 0; i < len; i++) {
			if(!chkArr[i])
				System.out.print(strArr[i]);
			else
				System.out.print("?");
		}
	}

}
