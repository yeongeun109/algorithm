

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2738_행렬덧셈 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int i = 0, j = 0;
		int[][] arr1 = new int[N][M];
		int[][] arr2 = new int[N][M];
		int[][] res = new int[N][M];
		
		for(i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(j = 0; j < M; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(j = 0; j < M; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(i = 0; i < N; i++) {
			for(j = 0; j < M; j++) {
				res[i][j] = arr1[i][j] + arr2[i][j];
				System.out.print(res[i][j] + " ");
			}
			
			System.out.println();
		}
	}

}
