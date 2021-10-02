package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 문자열_bj_15666_N과M12 {

	static int N, M;
	static int[] arr;
	static int[] selected;
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		selected = new int[M];
		
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		comb(0, 0);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < list.size(); i++){
			sb.append(list.get(i));
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		if(cnt == M) {
			String tmp = "";
			for(int i = 0; i < M; i++)
				tmp += selected[i] + " ";
			
			if(!list.contains(tmp)) {
				list.add(tmp);
			}
			
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[cnt] = arr[i];
			comb(cnt + 1, i);
		}
	}

}
