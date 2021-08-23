package algo_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2467_용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int diffMin = Integer.MAX_VALUE;
		int[] res = new int[2];
		int p1 = 0;
		int p2 = N - 1;
		while(true) {
			if(p1 == p2)
				break;
			if(arr[p1] + arr[p2] == 0) {
				res[0] = arr[p1];
				res[1] = arr[p2];
				break;
			}
			
			if(Math.abs(arr[p1] + arr[p2]) < diffMin) {
				diffMin = Math.abs(arr[p1] + arr[p2]);
				res[0] = arr[p1];
				res[1] = arr[p2];
			}
			
			if(Math.abs(arr[p1]) < Math.abs(arr[p2]))
				p2--;
			else
				p1++;
		}

		System.out.println(res[0] + " " + res[1]);
	}

}
