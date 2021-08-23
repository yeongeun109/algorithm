package algo_0206;

import java.util.Scanner;

public class bj_16922_로마숫자만들기 {

	static int[] romeNum = new int[] {1, 5, 10, 50};
	static int N = 0;
	static int[] arr;
	static boolean[] flag;
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		flag = new boolean[50*N];
		makeNum(0, 0, 0);
		System.out.println(result);
	}

	private static void makeNum(int nowIdx, int sum, int start) {
		int tempSum = sum;
		
		if(nowIdx == N) {
			if(flag[tempSum-1] == false) {
				result++;
				flag[tempSum-1] = true;
			}
			return;
		}
		
		for(int i = start; i < 4; i++) {
			tempSum += romeNum[i];
			makeNum(nowIdx + 1, tempSum, i);
			tempSum -= romeNum[i];
		}
	}

}
