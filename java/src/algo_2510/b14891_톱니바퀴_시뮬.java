package algo_2510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14891_톱니바퀴_시뮬 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		int[][] wheels = new int[4][8];
				
		for(int i = 0; i < 4; i++) {
			String str = in.readLine();
			for(int j = 0; j < 8; j++) {
				wheels[i][j] = str.charAt(j) - 48;
			}
		}
		
		int K = Integer.parseInt(in.readLine());
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int wheelNum = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			boolean[] rotFlag = new boolean[3];
			for(int i = 0; i < 3; i++) {
				if(wheels[i][2] != wheels[i + 1][6]) {
					rotFlag[i] = true;
				}
			}
			
			// 해당 톱니 돌리기
			int[] tmpWheel = new int[8];
			for(int i = 0; i < 8; i++)
				tmpWheel[i] = wheels[wheelNum][i];
			tmpWheel = rotate(tmpWheel, dir);
			for(int i = 0; i < 8; i++) {
				wheels[wheelNum][i] = tmpWheel[i];
			}
			
			int tmpDir = dir;
			// 오른쪽 탐색
			for(int i = wheelNum; i < 3; i++) {
				if(rotFlag[i]) {
					tmpDir *= -1;
					tmpWheel = new int[8];
					
					for(int j = 0; j < 8; j++)
						tmpWheel[j] = wheels[i + 1][j];
					
					tmpWheel = rotate(tmpWheel, tmpDir);
					
					for(int j = 0; j < 8; j++) {
						wheels[i + 1][j] = tmpWheel[j];
					}
				}else {
					break;
				}
			}
			
			tmpDir = dir;
			// 왼쪽 탐색
			for(int i = wheelNum - 1; i >= 0; i--) {
				if(rotFlag[i]) {
					tmpDir *= -1;
					tmpWheel = new int[8];
					
					for(int j = 0; j < 8; j++)
						tmpWheel[j] = wheels[i][j];
					
					tmpWheel = rotate(tmpWheel, tmpDir);
					
					for(int j = 0; j < 8; j++) {
						wheels[i][j] = tmpWheel[j];
					}
				}else {
					break;
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			if(wheels[i][0] == 1)
				res += Math.pow(2, i);
		}
		
		System.out.println(res);
	}

	static public int[] rotate(int[] wheel, int dir) {
		if(dir == 1) { // 오른쪽
			int tmp = wheel[7];
			for(int i = 7; i > 0; i--) {
				wheel[i] = wheel[i - 1];
			}
			wheel[0] = tmp;
		}else { // 왼쪽
			int tmp = wheel[0];
			for(int i = 0; i < 7; i++) {
				wheel[i] = wheel[i + 1];
			}
			wheel[7] = tmp;
		}
		
		return wheel;
	}
}