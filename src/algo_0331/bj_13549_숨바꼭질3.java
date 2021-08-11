package algo_0331;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_13549_숨바꼭질3 {

	static int[] d = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i = 0; i <= 100000; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		pq.offer(new int[] {0, N}); //시간, 정점
		d[N] = 0;
		
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int time = temp[0];
			int num = temp[1];
			
			for(int i = 0; i < 3; i++) {
				int tempTime = time;
				int tempNum = num;
				
				if(i == 2) { 		// *2
					tempNum *= 2;
				}else if(i == 0) {  // -1
					tempTime++;
					tempNum--;
				}else { 			// +1
					tempTime++;
					tempNum++;
				}
				
				if(tempNum > 100000 || tempNum < 0)
					continue;
				
				if(d[tempNum] > tempTime) {
					d[tempNum] = tempTime;
					pq.offer(new int[] {tempTime, tempNum});
				}
			}
		}
		
		//System.out.println(d[K]);
		for(int i = 0; i < 11; i++)
			System.out.println(d[i]);
	}

}
