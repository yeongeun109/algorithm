package algo_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jo_2577_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //벨트의 접시수
		int d = Integer.parseInt(st.nextToken()); //초밥 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속 접시수
		int c = Integer.parseInt(st.nextToken()); //쿠폰번호
		int max = 0;

		int[] chobab = new int[N];
		
		for(int i = 0; i < N; i++) {
			chobab[i] = Integer.parseInt(in.readLine());
		}
		
		int[] selected = new int[d + 1];
		int cnt = 0;
		for(int i = 0; i < k; i++) {
			selected[chobab[i]]++;
			if(selected[chobab[i]] == 1)
				cnt++;
		}
		
		if(selected[c] == 0)
			max = Math.max(max, cnt + 1);
		else
			max = Math.max(max, cnt);
		
		for(int i = 0; i < N; i++) {
			int idx = i + k;
			if(idx >= N)
				idx -= N;
			
			selected[chobab[idx]]++;
			
			if(selected[chobab[idx]] == 1)
				cnt++;
			
			selected[chobab[i]]--;
			if(selected[chobab[i]] == 0)
				cnt--;
			
			if(selected[c] == 0)
				max = Math.max(max, cnt + 1);
			else
				max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}

}
