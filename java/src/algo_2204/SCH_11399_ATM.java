package algo_2204;

import java.io.*;
import java.util.*;

public class SCH_11399_ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] list = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		int res = 0, preNum = 0;
		for(int i = 0; i < N; i++) {
			res += list[i];
			preNum += res;
		}
		System.out.println(preNum);
	}

}
