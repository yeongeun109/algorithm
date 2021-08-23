package algo_0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int p1 = 0, p2 = 0;
		int sum = arr[p1], cnt = Integer.MAX_VALUE;
		while(true) {
			if(sum < S) {
				p2++;
				if(p2 == N)
					break;
				sum += arr[p2];
			}else {
				cnt = Math.min(cnt, p2-p1+1);
				sum -= arr[p1];
				p1++;
			}
		}	
		
		if(cnt == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(cnt);
	}

}
