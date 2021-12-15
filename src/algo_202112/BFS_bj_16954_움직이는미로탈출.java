package algo_202112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_bj_16954_움직이는미로탈출 {

	static char[][] arr = new char[8][8];
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
		        String str = in.readLine();
			arr[i] = str.toCharArray();
		}

		int[] dx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

		q.offer(new int[] { 7, 0 });
		boolean flag = false;
		boolean[][] visited;
		
		while(!q.isEmpty()) {
			if(flag)
				break;
			int size = q.size();
			
			for (int s = 0; s < size; s++) {
				visited = new boolean[8][8];
				int[] tmp = q.poll();
				int cx = tmp[0];
				int cy = tmp[1];

				if (cx == 0 && cy == 7) {
					flag = true;
					break;
				}

				if(flag)
					break;
				for (int i = 0; i < 9; i++) {
					int tx = cx + dx[i];
					int ty = cy + dy[i];

					if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || visited[tx][ty] || arr[tx][ty] == '#')
						continue;

					if(tx > 0 && arr[tx - 1][ty] == '#')
						continue;
					
					q.offer(new int[] { tx, ty });
					visited[tx][ty] = true;
				}
			}
			
			getDown();
		}
		
		if(flag)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static void getDown() {
		for(int i = 7; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		String s = "........";
		arr[0] = s.toCharArray();
	}

}
