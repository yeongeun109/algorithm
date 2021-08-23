package algo_0224;

import java.util.Scanner;

public class bj_10157_자리배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		sc.nextLine();
		int K = sc.nextInt();
		
		int x = 1;
		int y = 0;
		int num = 0;
		int p = 1;
		int rX = R;
		int rY = C - 1;
		boolean flag = false;
		
		if(K > R*C)
			System.out.println(0);
		else {
			while(num < K) {
				for(int i = 0; i < rX; i++) {
					y += p;
					num++;
					if(num == K) {
						System.out.println(x + " " + y);
						flag = true;
						break;
					}
				}
				rX--;
				
				if(flag == true)
					break;
				
				for(int i = 0; i < rY; i++) {
					x += p;
					num++;
					if(num == K) {
						System.out.println(x + " " + y);
						flag = true;
						break;
					}
				}
				rY--;
				p *= -1;
				if(flag == true)
					break;
			}
		}

	}

}
