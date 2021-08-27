package algo_202108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14425_문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] arr = new String[N];
		int res = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = in.readLine();
		}
		
		for(int i = 0; i < M; i++) {
			String str = in.readLine();
			for(int j = 0; j < N; j++) {
				if(arr[j].equals(str)) {
					res++;
					break;
				}
			}
		}
		System.out.println(res);
	}

}
