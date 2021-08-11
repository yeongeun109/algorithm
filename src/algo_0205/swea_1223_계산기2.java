package algo_0205;

import java.util.Scanner;
import java.util.Stack;

public class swea_1223_계산기2 {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		for(int t = 0; t < 10; t++) {
			Stack<Integer> st1 = new Stack<Integer>();
			
			int T = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			
			for(int n = 0; n < T; n++) {
				if(str.charAt(n) == '*') {
					int num = st1.pop() * (str.charAt(++n)-'0');
					st1.push(num);
					//n++;
				}else if(str.charAt(n) != '+'){
					st1.push(str.charAt(n) - '0');
				}
			}
			
			int result = 0;
			
			while(!st1.isEmpty()) {
				result += st1.pop();
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t+1).append(" ").append(result);
			System.out.println(sb);
		}
	}	
}