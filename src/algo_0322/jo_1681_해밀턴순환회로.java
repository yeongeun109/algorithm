package algo_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jo_1681_해밀턴순환회로 {

	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		boolean[] visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0] = true;
		
		comb(arr, visited, 1, 0, 0);
		System.out.println(min);
	}

	private static void comb(int[][] arr, boolean[] visited, int cnt, int location, int sum) {
		if(sum > min)
			return;
		if(cnt == N) {
			if(arr[location][0] == 0)
				return;
			
			sum += arr[location][0];
			min = Math.min(min, sum);
			return;
		}

		for(int i = 1; i < N; i++) {
			if(visited[i] == false && arr[location][i] != 0) {
				visited[i] = true;
				comb(arr, visited, cnt + 1, i, sum + arr[location][i]);
				visited[i] = false;
			}
		}
	}
}