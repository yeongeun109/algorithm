package algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 10; i++) {
			int T = Integer.parseInt(in.readLine());
			String str = in.readLine();
			Stack<Character> stack = new Stack<Character>();

			for(int t = 0; t < T; t++) {
				if(!stack.isEmpty()) {
					if(stack.peek() == '<' && str.charAt(t) == '>') {
						stack.pop();
					}else if(stack.peek() == '[' && str.charAt(t) == ']') {
						stack.pop();
					}else if(stack.peek() == '(' && str.charAt(t) == ')') {
						stack.pop();
					}else if(stack.peek() == '{' && str.charAt(t) == '}') {
						stack.pop();
					}else {
						stack.push(str.charAt(t));
					}
				}else {
					stack.push(str.charAt(t));
				}
			}
			if(stack.isEmpty())
				System.out.println("#" + (i+1) + " 1");
			else
				System.out.println("#" + (i+1) + " 0");
		}
		
	}

}
