package algo_0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_15686_치킨배달 {

	static int N = 0;
	static int M = 0;
	static ArrayList<int[]> house = new ArrayList<int[]>();
	static ArrayList<int[]> chick = new ArrayList<int[]>();
	static int[] selected;
	static int min = 1300;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str1 = in.readLine();
		StringTokenizer st1 = new StringTokenizer(str1, " ");
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		selected = new int[M];
		
		for(int i = 0; i < N; i++) {
			String str2 = in.readLine();
			StringTokenizer st2 = new StringTokenizer(str2, " ");
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st2.nextToken());
				if(num == 1) {
					house.add(new int[] {i, j});
				}else if(num == 2) {
					chick.add(new int[] {i, j});
				}
			}
		}
		comb(0,0);
		System.out.println(min);
	}

	private static void comb(int cnt, int start) {
		if(cnt == M) {
			calc();
			return;
		}
		
		for(int i = start; i < chick.size(); i++) {
			selected[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

	private static void calc() {
		int[] distance = new int[house.size()];
			
		for(int i = 0; i < house.size(); i++) {
			int hx = house.get(i)[0];
			int hy = house.get(i)[1];
			int tempMin = 100;
			
			for(int j = 0; j < M; j++) {
				int cx = chick.get(selected[j])[0];
				int cy = chick.get(selected[j])[1];
				
				int tempDist = Math.abs(cx-hx) + Math.abs(cy-hy);
				tempMin = Math.min(tempMin, tempDist);
			}
			
			distance[i] = tempMin;
		}
		int sum = 0;
		
		for(int i = 0; i < distance.length; i++) {		
			sum += distance[i];
		}
		min = Math.min(min, sum);
	}
}
