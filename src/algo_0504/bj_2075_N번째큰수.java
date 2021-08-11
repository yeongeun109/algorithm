package algo_0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_2075_N번째큰수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		List<Integer>[] list = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < N; j++) {
				list[j].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int cnt = 0;
		int num = 0;
		while(cnt != N) {
			int max = Integer.MIN_VALUE;
			int idx = -1;
			for(int i = 0; i < N; i++) {
				if(list[i].get(list[i].size() - 1) > max) {
					max = list[i].get(list[i].size() - 1);
					idx = i;
				}
			}
			
			cnt++;
			num = list[idx].get(list[idx].size() - 1);
			list[idx].remove(list[idx].size() - 1);
		}
		System.out.println(num);
	}

}
