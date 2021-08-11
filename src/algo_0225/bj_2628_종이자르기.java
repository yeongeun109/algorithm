package algo_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_2628_종이자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> garo = new ArrayList<Integer>();
		ArrayList<Integer> sero = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			if(a == 0) {
				garo.add(b);
			}else {
				sero.add(b);
			}
		}
		
		Collections.sort(garo);
		Collections.sort(sero);
		
		ArrayList<int[]> garoCutList = new ArrayList<int[]>();
		ArrayList<int[]> seroCutList = new ArrayList<int[]>();
		
		int p = 0;
		
		for(int i = 0; i < garo.size(); i++) {
			garoCutList.add(new int[] {p, 0, garo.get(i) - 1, x - 1});
			p = garo.get(i);
		}
		garoCutList.add(new int[] {p, 0, y - 1, x - 1});
		
		p = 0;
		for(int i = 0; i < sero.size(); i++) {
			for(int j = 0; j < garoCutList.size(); j++) {
				seroCutList.add(new int[] {garoCutList.get(j)[0], p,
						garoCutList.get(j)[2], sero.get(i) - 1});
				
			}
			p = sero.get(i);
		}
		
		for(int i = 0; i < garoCutList.size(); i++) {
			seroCutList.add(new int[] {garoCutList.get(i)[0], p, garoCutList.get(i)[2], x - 1});
		}
		
		int max = 0;
		for(int i = 0; i < seroCutList.size(); i++) {
			int temp = 0;
			int x1 = seroCutList.get(i)[0];
			int y1 = seroCutList.get(i)[1];
			int x2 = seroCutList.get(i)[2];
			int y2 = seroCutList.get(i)[3];
			
			temp = (x2 - x1 + 1) * (y2 - y1 + 1);
			max = Math.max(temp, max);
		}
		
		System.out.println(max);
	}

}
