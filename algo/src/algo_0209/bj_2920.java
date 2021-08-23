package algo_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int[] arr = new int[8];
		String result;

		int firstNum = Integer.parseInt(st.nextToken());
		int a = 0;
		if(firstNum == 1) 
			a = 1;
		else
			a = -1;
		
		arr[0] = firstNum;
		for(int i = 1; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean flag = false;
		for(int i = 0; i < 7; i++) {
			if(arr[i] + a != arr[i+1]) {
				flag = true;
				break;
			}
		}
		
		if(flag == true) {
			result = "mixed";
		}else {
			if(a == -1)
				result = "descending";
			else
				result = "ascending";
		}
		
		System.out.println(result);
	}

}
