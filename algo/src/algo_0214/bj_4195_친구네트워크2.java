package algo_0214;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj_4195_친구네트워크2 {

	static ArrayList<Integer> idxList;
	static ArrayList<Integer> countList;
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			int F = Integer.parseInt(in.readLine());
			idxList = new ArrayList<Integer>();
			countList = new ArrayList<Integer>();
			map = new HashMap<String, Integer>();
			
			int cnt = 0;
			
			for(int f = 0; f < F; f++) {
				String str1 = in.readLine();
				StringTokenizer st1 = new StringTokenizer(str1, " ");
				String name1 = st1.nextToken();
				String name2 = st1.nextToken();
				
				if(!map.containsKey(name1)) {
					idxList.add(cnt);
					map.put(name1, cnt++);
					countList.add(1);
				}
				
				if(!map.containsKey(name2)) {
					idxList.add(cnt);
					map.put(name2, cnt++);
					countList.add(1);
				}
				
				sb.append(union(map.get(name1), map.get(name2))).append("\n");
			}
			
		}System.out.print(sb);
	}

	static int union(int i, int j) {
		i = find(i);
		j = find(j);

		if(i != j) {
			idxList.set(i, j);
			countList.set(j, countList.get(i) + countList.get(j));
		}
		
		return countList.get(j);
	}
	
	static int find(int i) {
		if(idxList.get(i) == i) {
			return i;
		}
		
		return find(idxList.get(i));
	}
	
}
