package algo_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_13412_서로소쌍 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(in.readLine());
			int cnt = 0;
			
			//i*i <= n   vs   i <= n/2
			for(int i = 1; i*i <= n; i++) {
				if(n % i == 0) {
					int a = i;
					int b = n/i;
					
					while(true) {
						if(a % b == 0) {
							if(b == 1)
								cnt++;
							break;
						}else {
							int temp = a % b;
							a = b;
							b = temp;
						}
					}
					
				}else
					continue;
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
