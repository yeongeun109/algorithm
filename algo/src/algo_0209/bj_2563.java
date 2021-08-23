package algo_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		boolean[][] dowhaji = new boolean[100][100];
		int result = 0;
		
		for(int n = 0; n < num; n++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			for(int i = y; i < y+10; i++) {
				for(int j = x; j < x+10; j++) {
					if(dowhaji[i][j] != true) {
						dowhaji[i][j] = true;
						result++;
					}else
						continue;
				}
			}

		}
		System.out.println(result);
	}

}
