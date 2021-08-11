package algo_0206;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1759_암호만들기 {

	static char selected[];
	static int L = 0;
	static int C = 0;
	static char str[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		selected = new char[L];
		
		sc.nextLine();
		char[] tempStr = new char[C];
		for(int i = 0; i < C; i++) {
			tempStr[i] = sc.next().charAt(0);
		}
		
		str = new char[C];
		
		for(int i = 0; i < C; i++) {
			str[i] = tempStr[i];
		}
		Arrays.sort(str);
		makePW(0,0);
	}

	private static void makePW(int nowIdx, int start) {
		if(nowIdx == L) {
			int moCnt = 0;
			int jaCnt = 0;
			for(int i = 0; i < L; i++) {
				if(selected[i] == 97 || selected[i] == 101 || selected[i] == 105 || selected[i] == 111 || selected[i] == 117)
					moCnt++;
				
				if(selected[i] >= 98 && selected[i] <= 122) {
					if(selected[i] != 101 && selected[i] != 105 && selected[i] != 111 && selected[i] != 117) {
						jaCnt++;
					}
				}
			}
			
			if(moCnt >= 1 && jaCnt >= 2) {
				for(int i = 0; i < L; i++) {
					System.out.print(selected[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			selected[nowIdx] = str[i];
			makePW(nowIdx + 1, i + 1);
		}
	}

}
