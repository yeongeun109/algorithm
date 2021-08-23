package algo_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_8382_방향전환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int result = 0;
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());			
			
			int x = Math.abs(x2 - x1);
			int y = Math.abs(y2 - y1);
			
			int max = Math.max(x, y);
			int min = Math.min(x, y);
			
			if(max % 2 == 1) {
				if(min % 2 == 0)
					result = max * 2 - 1;
				else
					result = max * 2;
			}else {
				if(min % 2 == 0)
					result = max * 2;
				else
					result = max * 2 - 1;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
