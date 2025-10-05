

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		boolean[][] dowhaji = new boolean[100][100];
		int res = 0;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			for(int x = a; x < a + 10; x++) {
				for(int y = b; y < b + 10; y++) {
					if(!dowhaji[x][y]) {
						dowhaji[x][y] = true;
						res++;
					}					
				}
			}
		}
		
		System.out.println(res);
	}

}
