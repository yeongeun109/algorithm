package algo_0502;

import java.util.Scanner;

public class bj_16463_13일의금요일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int day[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int cnt = 0;
		int yoil = 1;
		
		for (int i = 2019; i <= N; i++) {
			int year = i;

			if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) 
				day[1] = 29;
			else
				day[1] = 28;
			
			for(int j = 0; j < 12; j++) {
				if(yoil == 6)
					cnt++;
				
				if(day[j] == 31)
					yoil += 3;
				else if(day[j] == 30)
					yoil += 2;
				else if(day[j] == 29)
					yoil += 1;
				
				if(yoil >= 7)
					yoil -= 7;
			}
		}
		System.out.println(cnt);
	}

}
