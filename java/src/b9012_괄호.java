

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class b9012_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int i = 0; i < T; i++) {
			String str = in.readLine();
			Stack<Character> st = new Stack<Character>();
			
			for(int j = 0; j < str.length(); j++) {
				if(st.size() >= 1) {
					if(st.lastElement() == '(') {
						if(str.charAt(j) == ')') {
							st.pop();
						}else {
							st.add(str.charAt(j));
						}
					}else {
						st.add(str.charAt(j));
					}
				}else {
					st.add(str.charAt(j));
				}
			}

			if(st.size() != 0)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		
	}

}
