package algo_0216;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1074_Z {

	static long[][] arr;
	static int result = 0;
	static int r, c;
	private static int[] dx = {0, 1, 0, 1};
	private static int[] dy = {0, 0, 1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int pow = (int) Math.pow(2, N);
		
		divide(0, 0, pow, 0);
	}

	private static void divide(int x, int y, int size, int cnt) {
		if(x > r || x+size <= r || y > c || y+size <= c)
			return;
		
		if(size == 2) {
			for(int i = 0; i < 4; i++) {
				int r2 = x + dy[i];
                int c2 = y + dx[i];
                if (r2 == r && c2 == c) {
                    System.out.println(cnt);
                    break;
                }
                cnt++;
			}
			
			return;
		}
		
		int newSize = size/2;
		divide(x, y, newSize, cnt);
		divide(x, y+size/2, newSize, cnt+(newSize*newSize));
		divide(x+size/2, y, newSize, cnt+(newSize*newSize*2));
		divide(x+size/2, y+size/2, newSize, cnt+(newSize*newSize*3));
	}
}
