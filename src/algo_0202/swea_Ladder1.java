package algo_0202;

import java.util.Scanner;

public class swea_Ladder1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[102][102];
		
		for(int i = 0; i < 10; i++) {
			int T = sc.nextInt();
			int result = 0;
			int ansX = 0;
			int ansY = 0;
			
			for(int j = 1; j < 101; j++) {
				for(int k = 1; k < 101; k++) {
					arr[j][k] = sc.nextInt();
					if(arr[j][k] == 2) {
						ansX = j;
						ansY = k;
					}
				}
			}
			
			int dx[] = {-1,0,0}; // 0:À§, 1:¿À, 2:¿Þ
			int dy[] = {0,1,-1};
			int x = ansX, y = ansY;
			
			while(true) {
				if(x == 1) {
					result = y - 1;
					break;
				}
				
				if(arr[x+dx[1]][y+dy[1]] == 1) {
					while(true) {	
						y++;
						if(arr[x-1][y] == 1) {
							x--;
							break;
						}
						
					}
				}else if(arr[x+dx[2]][y+dy[2]] == 1) {
					while(true) {
						y--;
						if(arr[x-1][y] == 1) {
							x--;
							break;
						}
						
					}
				}else {
					x--;
				}
			}
			
			System.out.println("#" + T + " " + result);
		}

	}

}
