package algo_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj_4195_친구네트워크 {

	static int[] idxList = new int[200000];
	static int[] countList = new int[200000];
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			int F = Integer.parseInt(in.readLine());
			map = new HashMap<String, Integer>();
			
			int cnt = 0;
			
			for(int i = 0; i < 2*F; i++) {
				idxList[i] = i;
				countList[i] = 1;
			}
			
			for(int f = 0; f < F; f++) {
				String str1 = in.readLine();
				StringTokenizer st1 = new StringTokenizer(str1, " ");
				String name1 = st1.nextToken();
				String name2 = st1.nextToken();
				
				if(!map.containsKey(name1)) {
					map.put(name1, cnt++);
				}
				
				if(!map.containsKey(name2)) {
					map.put(name2, cnt++);
				}

				sb.append(union(map.get(name1), map.get(name2))).append("\n");
				for(int i = 0; i < 10; i++) {
					System.out.print(countList[i] + " ");
				}
				System.out.println();
			} 
			
		}System.out.print(sb);
		
	}

	static int union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i != j) {
			idxList[i] = j;
			countList[j] += countList[i];
			countList[i] = 1;
		}
		
		return countList[j];
	}
	
	static int find(int i) {
		if(idxList[i] == i) {
			return i;
		}
		
		return find(idxList[i]);
	}
	
}
