package algo_202111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BFS_bj_1963_소수경로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		// 에라토스테네스의 체
		int[] arr = new int[10001];
		for (int i = 2; i <= 10000; i++) {
			arr[i] = i;
		}
		
		for(int i = 2; i <= 10000; i++) {
			if(arr[i] != 0) {
				for(int j = i * 2; j <= 10000; j += i) {
					arr[j] = 0;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
			
			boolean[] visited = new boolean[10001];
			pq.offer(new int[] {a, 0});
			visited[a] = true;
			int res = -1;
			
			while(!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int num = tmp[0];
				int cnt = tmp[1];
				if(num == b) {
					res = cnt;
					break;
				}
				
				int ten = 1000;
				int tNum = num;
				int[] numArr = new int[4];
				for(int i = 0; i < 4; i++) {
					int n = tNum / ten;
					numArr[i] = n;
					if(n != 0)
						tNum %= ten;
					ten /= 10;
				}
				
				tNum = num;
				ten = 1000;
				for(int i = 0; i < 4; i++) {
					if(i == 0) {
						for(int j = 1; j <= 9; j++) {
							if(numArr[i] != j) {
								int tmpNum = (tNum - numArr[i] * 1000) + j * 1000;
								if(!visited[tmpNum] && arr[tmpNum] != 0) {
									pq.offer(new int[] {tmpNum, cnt + 1});
									visited[tmpNum] = true;
								}
							}
						}
						ten /= 10;
					}else {
						for(int j = 0; j <= 9; j++) {
							if(numArr[i] != j) {
								int tmpNum = (tNum - numArr[i] * ten) + j * ten;
								if(!visited[tmpNum] && arr[tmpNum] != 0) {
									pq.offer(new int[] {tmpNum, cnt + 1});
									visited[tmpNum] = true;
								}
							}
						}
						ten /= 10;
					}
				}
			}
			if(res != -1)
				sb.append(res).append("\n");
			else
				sb.append("Impossible\n");
		}
		System.out.println(sb);
	}

}
