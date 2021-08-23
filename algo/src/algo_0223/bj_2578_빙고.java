package algo_0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2578_빙고 {

	static int[][] arr = new int[5][5];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		int x = 0;
		boolean flag = false;
		
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 5; i++) {
				cnt = 0;
				int num = Integer.parseInt(st.nextToken());
				check(num);
				isBingo();
				
				if (cnt >= 3) {
					result = x * 5 + i + 1;
					flag = true;
					break;
				}
			}
			
			if (flag == true)
				break;
			x++;
		}
		
		System.out.println(result);
	}

	private static void check(int num) {
		boolean flag = false;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[i][j] == num) {
					arr[i][j] = 0;
					flag = true;
					break;
				}
			}
			
			if(flag == true)
				break;
		}
		
	}

	private static void isBingo() {
		//가로
		int tmp = 0;
		for(int i = 0; i < 5; i++) {
			tmp = 0;
			for(int j = 0; j < 5; j++) {
				if(arr[i][j] == 0) {
					tmp++;
				}
			}
			if(tmp == 5)
				cnt++;
		}
		
		
		//세로
		//tmp = 0;
		for(int i = 0; i < 5; i++) {
			tmp = 0;
			for(int j = 0; j < 5; j++) {
				if(arr[j][i] == 0) {
					tmp++;
				}
			}
			if(tmp == 5)
				cnt++;
		}
		
		
		//왼오 대각선
		tmp = 0;
		for(int i = 0; i < 5; i++) {
			if(arr[i][i] == 0) {
				tmp++;
			}
		}
		if(tmp == 5)
			cnt++;
		
		//오왼 대각선
		tmp = 0;
		for(int i = 0; i < 5; i++) {
			if(arr[i][4-i] == 0) {
				tmp++;
			}
		}
		if(tmp == 5)
			cnt++;
	}

}
