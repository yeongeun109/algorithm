package algo_202111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 문자열_bj_5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			String func = in.readLine();
			int len = Integer.parseInt(in.readLine());
			Deque<String> deq = new ArrayDeque<>();
			
			String arr = in.readLine();
			if(len > 0) {
				arr = arr.substring(1, arr.length() - 1);
				String[] a = arr.split(",");
//				System.out.println("a :" + a.length);
				for(int i = 0; i < a.length; i++) {
					deq.offerLast(a[i]);
				}
//				System.out.println(deq);
//				System.out.println(deq.size());
			}
			int start = 1;
			boolean flag = true;
//			if(len == 0) {
//				flag = false;
//				sb.append("error\n");
//			}else {
//			
			for(int i = 0; i < func.length(); i++) {
//				if(i <= func.length() - 1 && func.charAt(i) == 'R' && func.charAt(i + 1) == 'R') {
//					i++;
//					continue;
//				}
				
				if(func.charAt(i) == 'R') {
					start *= -1;
				}else {
					if(start == 1) {
						if(deq.size() == 0 || deq.pollFirst() == null) {
							sb.append("error\n");
							flag = false;
							break;
						}
					}else {
						if(deq.size() == 0 || deq.pollLast() == null) {
							sb.append("error\n");
							flag = false;
							break;
						}
					}
				}
			}
//			}
			
//			System.out.println(deq.toString());
			if(flag) {
				sb.append("[");
				if(start == 1) {
					while(!deq.isEmpty()) {
						sb.append(deq.pollFirst());
						if(deq.size() != 0)
							sb.append(",");
					}
				}else {
					while(!deq.isEmpty()) {
						sb.append(deq.pollLast());
						if(deq.size() != 0)
							sb.append(",");
					}
				}
				sb.append("]\n");
			}
			
		}
		System.out.println(sb);
	}

}
