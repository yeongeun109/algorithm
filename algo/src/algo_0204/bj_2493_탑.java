package algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_2493_탑 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int result[] = new int[N];
		
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		Stack<Integer> stNum = new Stack<Integer>();
		Stack<Integer> stIdx = new Stack<Integer>();
		
		stNum.push(Integer.parseInt(st.nextToken()));
		stIdx.push(0);
		
		for(int i = 1; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(!stNum.isEmpty()) {
				if(num > stNum.peek()) {
					while(!stNum.isEmpty() && num > stNum.peek()) {
						stNum.pop();
						stIdx.pop();
					}
					
					if(!stNum.isEmpty())
						result[i] = stIdx.peek() + 1;
					else
						result[i] = 0;
					stNum.push(num);
					stIdx.push(i);
				}else {
					result[i] = stIdx.peek() + 1;
					stNum.push(num);
					stIdx.push(i);
				}
			}
		}
		
		for(int i = 0; i < N; i++)
			System.out.print(result[i] + " ");
	}
}
