package algo_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1233 {

	static int testCase;
	static String[] arr;
	static int result = 0;
	static boolean flag = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			testCase = Integer.parseInt(in.readLine());
			arr = new String[testCase + 1];
			flag = false;
			for(int tc = 1; tc <= testCase; tc++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				arr[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			
			dfs(1, 1);
			
			if(flag == true)
				result = 0;
			else
				result = 1;
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(result);
			System.out.println(sb);
		}
	}
	
	static public void dfs(int current, int parent) {
		if(current > testCase ) {
			if(arr[parent].equals("+") || arr[parent].equals("-") || arr[parent].equals("*") || arr[parent].equals("/")) {
				result++;
				flag = true;
			}
			return;
		}
		
		dfs(current*2, current);
		dfs(current*2 + 1, current);
		if(flag == true)
			return;
	}
}
