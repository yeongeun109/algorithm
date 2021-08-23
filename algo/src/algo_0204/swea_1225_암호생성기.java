package algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1225_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 0; t < 10; t++) {
			in.readLine();
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for(int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int deNum = 0;
			
			while(queue.peek() != 0) {
				int num = queue.poll();
				
				deNum = (deNum % 5) + 1;
				num -= deNum;
				
				if(num <= 0) num = 0;
				
				queue.offer(num);
				if(num == 0) break;
			}
			System.out.print("#" + (t+1) + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}

}
