package algo_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6808_규영이와인영이의카드게임 {

	static int[] gyu;
	static int[] inyeong;
	static boolean[] visited;
	static int[] selected;
	static int gyuWin = 0;
	static int inWin = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			boolean[] card = new boolean[19];
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			for(int i = 0; i < 9; i++) {
				card[Integer.parseInt(st.nextToken())] = true;
			}
			
			gyu = new int[9];
			inyeong = new int[9];
			gyuWin = 0;
			inWin = 0;
			visited = new boolean[9];
			selected = new int[9];
			int gIdx = 0, iIdx = 0;
			
			for(int i = 1; i <= 18; i++) {
				if(card[i] == true) {
					gyu[gIdx] = i;
					gIdx++;
				}else {
					inyeong[iIdx] = i;
					iIdx++;
				}
			}

			perm(0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(gyuWin).append(" ").append(inWin);
			System.out.println(sb);
		}
	}
	
	static private void perm(int cnt) {
		if(cnt == 9) {
			game(selected);
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i] == false) {
				selected[cnt] = inyeong[i];
				visited[i] = true;
				perm(cnt+1);
				visited[i] = false;
			}else
				continue;
		}
	}
	
	static private void game(int[] iyCard) {
		int gyuScore = 0;
		int inScore = 0;
		
		for(int i = 0; i < 9; i++) {
			if(gyu[i] > iyCard[i]) {
				gyuScore += gyu[i] + iyCard[i];
			}else {
				inScore += gyu[i] + iyCard[i];
			}
		}
		
		if(gyuScore > inScore)
			gyuWin++;
		else if(inScore > gyuScore)
			inWin++;
	}
}
