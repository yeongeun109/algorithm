package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_bj_1259_팰린드롬수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine();
		while(!str.equals("0")) {
			boolean flag = true;
			for(int i = 0; i < str.length() / 2; i++) {
				if(str.charAt(i) != str.charAt(str.length() - (i + 1))) {
					sb.append("no\n");
					flag = false;
					break;
				}
			}
			if(flag)
				sb.append("yes\n");
			str = in.readLine();
		}
		System.out.println(sb);
	}

}
