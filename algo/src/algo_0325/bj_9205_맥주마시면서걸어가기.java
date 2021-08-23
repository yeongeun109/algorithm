package algo_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			int store = Integer.parseInt(in.readLine());
			int[][] arr = new int[store + 2][store + 2];
			int[][] loc = new int[store + 2][2];

			for (int i = 0; i < store + 2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < store + 2; i++) {
				for(int j = i + 1; j < store + 2; j++) {
					int dis = Math.abs(loc[i][0] - loc[j][0]) + Math.abs(loc[i][1] - loc[j][1]);
					if(dis <= 1000) {
						arr[i][j] = 1;
						arr[j][i] = 1;
					}else if(i != j) {
						arr[i][j] = 9999999;
						arr[j][i] = 9999999;
					}
				}
			}
			
			for(int k = 0; k < store+2; k++) {
				for(int i = 0; i < store + 2; i++) {
					if(k == i)
						continue;
					
					for(int j = 0; j < store + 2; j++) {
						if(k == j || i == j)
							continue;
						if(arr[i][j] > arr[i][k] + arr[k][j])
							arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
			
			if(arr[0][store+1] != 9999999)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}
