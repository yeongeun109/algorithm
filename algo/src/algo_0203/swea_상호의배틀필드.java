package algo_0203;

import java.util.Scanner;

public class swea_상호의배틀필드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			sc.nextLine();
			char[][] arr = new char[H+2][W+2];
			int x = 0, y = 0;
			int direction = 0;

			for(int i = 1; i < H+1; i++) {
				String str = sc.nextLine();
				for(int j = 1; j < W+1; j++) {			
					arr[i][j] = str.charAt(j-1);
					switch(arr[i][j]) {
					case '^':
						direction = 1;
						x = i;
						y = j;
						break;
					case 'v':
						direction = 2;
						x = i;
						y = j;
						break;
					case '<':
						direction = 3;
						x = i;
						y = j;
						break;
					case '>':
						direction = 4;
						x = i;
						y = j;
						break;
					}
				}
			}
			
			int N = sc.nextInt();
			String str = sc.next();
			for(int i = 0; i < N; i++) {
				if(str.charAt(i) == 'U') {
					arr[x][y] = '^';
					if(arr[x-1][y] == '.') {
						arr[x][y] = '.';
						x--;
						arr[x][y] = '^';
					}
					direction = 1;
				}else if(str.charAt(i) == 'D') {
					arr[x][y] = 'v';
					if(arr[x+1][y] == '.') {
						arr[x][y] = '.';
						x++;
						arr[x][y] = 'v';
					}
					direction = 2;
				}else if(str.charAt(i) == 'L') {
					arr[x][y] = '<';
					if(arr[x][y-1] == '.') {
						arr[x][y] = '.';
						y--;
						arr[x][y] = '<';
					}
					direction = 3;
				}else if(str.charAt(i) == 'R') {
					arr[x][y] = '>';
					if(arr[x][y+1] == '.') {
						arr[x][y] = '.';
						y++;
						arr[x][y] = '>';
					}
					direction = 4;
				}else {
					if(direction == 1) {
						int tempX = x;
						while (true) {
							if (tempX == 0 || arr[tempX-1][y] == '#')
								break;
							else {
								if (arr[tempX-1][y] == '*') {
									arr[tempX-1][y] = '.';
									break;
								} else {
									tempX--;
								}
							}
						}
					}else if(direction == 2) {
						int tempX = x;
						while (true) {
							if (tempX == H || arr[tempX+1][y] == '#')
								break;
							else {
								if (arr[tempX+1][y] == '*') {
									arr[tempX+1][y] = '.';
									break;
								} else {
									tempX++;
								}
							}
						}
					}else if(direction == 3) {
						int tempY = y;
						while (true) {
							if (tempY == 0 || arr[x][tempY - 1] == '#')
								break;
							else {
								if (arr[x][tempY - 1] == '*') {
									arr[x][tempY - 1] = '.';
									break;
								} else {
									tempY--;
								}
							}
						}
					}else {
						int tempY = y;
						while (true) {
							if (tempY == W || arr[x][tempY + 1] == '#')
								break;
							else {
								if (arr[x][tempY + 1] == '*') {
									arr[x][tempY + 1] = '.';
									break;
								} else {
									tempY++;
								}
							}
						}
					}
					
				}
			}
			
			System.out.print("#" + (t+1) + " ");
			for(int i = 1; i < H + 1; i++) {
				for(int j = 1; j < W + 1; j++) {				
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}

}
