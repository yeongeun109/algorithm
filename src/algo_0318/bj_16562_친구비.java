package algo_0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16562_친구비 {
	
	static int N, M, k;
	static int parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		
		int money[] = new int[N + 1];
		StringTokenizer st2 = new StringTokenizer(in.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st2.nextToken());
		}
		
		makeSet();

		for(int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(in.readLine(), " ");
			
			int a = Integer.parseInt(st3.nextToken());
			int b = Integer.parseInt(st3.nextToken());
			union(a, b);
			
		}
		
		//System.out.println(Arrays.toString(parents));
		boolean[][] checkArr = new boolean[N + 1][N + 1];
		boolean[] checkArr2 = new boolean[N + 1];
		/*ArrayList<Queue> checkList = new ArrayList<Queue>();
		for(int i = 0; i <= N; i++) {
			checkList.add(new LinkedList<Integer>());
		}*/
		
		for(int i = 1; i <= N; i++) {
			int rep = findSet(i);
			checkArr[i][rep] = true;
			checkArr2[rep] = true;
			//checkList.get(rep).offer(i);
		}
		//System.out.println(Arrays.toString(parents));
		//System.out.println(checkList.get(3));
		//System.out.println(checkList.get(5));
		//System.out.println(Arrays.toString(checkArr2));
		
		/*for(int i = 1; i < N + 1; i++) {
			System.out.println(Arrays.toString(checkArr[i]));
		}*/
		
		int needMoney = 0;
		
		for(int i = 1; i <= N; i++) {
			if(checkArr2[i]) {
				int min = 10000;
				//System.out.println(Arrays.toString(checkArr[i]));
				
				for(int j = 1; j <= N; j++) {
					if(checkArr[j][i] == true) {
						int tempMoney = money[j];
						min = Math.min(min, tempMoney);
					}
				}
				
				needMoney += min;
			}
			/*if(!checkList.get(i).isEmpty()) {
				Queue<Integer> tempQ = checkList.get(i);
				int min = 10000;
				
				for(int j = 0; j < tempQ.size(); j++) {
					int tempMoney = money[tempQ.poll()];
					min = Math.min(min, tempMoney);
				}
				
				needMoney += min;
			}*/
		}
		
		if(needMoney <= k)
			System.out.println(needMoney);
		else
			System.out.println("Oh no");
	}
	
	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA == rootB)
			return false;
		
		parents[rootB] = rootA;
		return true;
	}
	
	private static int findSet(int a) {
		if(parents[a] == a)
			return a;
		
		return parents[a] = findSet(parents[a]);
	}

	static private void makeSet() {
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

}


/*
5 5 10
10 20 30 40 50
1 2
3 1
2 4
4 3
3 5

6 5 10
10 20 30 40 50 60 
1 2
3 1
2 4
4 3
3 5

6 6 10
10 20 30 40 50 60 
1 2
3 1
2 4
4 3
3 5
6 1
*/
