package algo_0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_10815_숫자카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(in.readLine());
		StringTokenizer st2 = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st2.nextToken());
			boolean flag = false;
			int left = 0, right = N-1;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				if(arr[mid] == num) {
					sb.append(1).append(" ");
					flag = true;
					break;
				}
				
				if(arr[mid] > num) {
					right = mid - 1;
				}else if(arr[mid] < num) {
					left = mid + 1;
				}
			}
			
			if(flag == false)
				sb.append(0).append(" ");
		}
		
		System.out.println(sb);
	}
	
}
