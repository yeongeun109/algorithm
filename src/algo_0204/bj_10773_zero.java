package algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_10773_zero {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num != 0) {
				st.push(num);
			}else {
				st.pop();
			}
		}
		
		int result = 0;
		int size = st.size();
		for(int i = 0; i < size; i++) {
			result += st.pop();
		}
		System.out.println(result);
	}

}
