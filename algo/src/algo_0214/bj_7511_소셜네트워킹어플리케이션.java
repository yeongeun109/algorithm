package algo_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_7511_소셜네트워킹어플리케이션 {

	static int[] root;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			int userNum = Integer.parseInt(in.readLine());
			int rtNum = Integer.parseInt(in.readLine());
			
			root = new int[userNum];
			for(int i = 0; i < userNum; i++) {
				root[i] = i;
			}
			
			for(int i = 0; i < rtNum; i++) {
				String str1 = in.readLine();
				StringTokenizer st1 = new StringTokenizer(str1, " ");
				int a = Integer.parseInt(st1.nextToken());
				int b = Integer.parseInt(st1.nextToken());
				union(a, b);
			}
			
			int pair = Integer.parseInt(in.readLine());
			
			StringBuilder sb = new StringBuilder();
			sb.append("Scenario ").append(t).append(":\n");
			for(int i = 0; i < pair; i++) {
				
				String str2 = in.readLine();
				StringTokenizer st2 = new StringTokenizer(str2, " ");
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				int x = find(a);
				int y = find(b);
				if(x == y) {
					//union(x, y);
					sb.append("1\n");
				}else
					sb.append("0\n");
			}
			
			System.out.println(sb);
		}
	}

	static public void union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i < j)
			root[j] = i;
		else
			root[i] = j;
	}
	
	static public int find(int i) {
		if(root[i] == i)
			return i;
		
		return find(root[i]);
	}
}
