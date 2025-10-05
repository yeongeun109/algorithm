package algo_2510;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b10810 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = start; j <= end; j++) {
				arr[j] = num;
			}
		}
		
		for(int i = 0; i < N; i++)
			System.out.print(arr[i] + " ");
	}

}
