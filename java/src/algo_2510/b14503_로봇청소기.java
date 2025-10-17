package algo_2510;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b14503_로봇청소기 {
	//						 북  동  남  서
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, 1, 0, -1};
	static String[][] room;
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int res = 0;
		
		st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken()); // 청소기 위치 x
		int y = Integer.parseInt(st.nextToken()); // 청소기 위치 y
		int dir = Integer.parseInt(st.nextToken()); // 방향
		
		// 방 채우기
		room = new String[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					room[i][j] = "#";
				else
					room[i][j] = "0";
			}
		}
		
		int cnt = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y, dir, cnt});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int tx = now[0]; // 위치 x
			int ty = now[1]; // 위치 y
			int td = now[2]; // 방향
			int tc = now[3]; // cnt
			boolean isClean = false;
			int tmpDir = td;
			
			if(room[tx][ty] == "0")
				room[tx][ty] = Integer.toString(tc);
			
			for(int i = 0; i < 4; i++) {
				tmpDir += 3;
				int cd = tmpDir % 4;
				int cx = tx + dx[cd];
				int cy = ty + dy[cd];
				
				if(cx < 0 || cx >= N || cy < 0 || cy >= M)
					continue;
				
				if(room[cx][cy] == "0") {
					// 청소해야하는 칸
					q.add(new int[] {cx, cy, cd, tc + 1});
					isClean = true;
					break;
				}else if(room[cx][cy] == "#") {
					// 벽
				}else {
					// 이미 청소한 칸
				}
			}
			
			if(!isClean) {
				// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
				int cd = (td + 2) % 4; // 반대 방향
				int cx = tx + dx[cd];
				int cy = ty + dy[cd];
				
				if(cx < 0 || cx >= N || cy < 0 || cy >= M)
					break;
				
				if(room[cx][cy] != "#") { // 후진
					q.add(new int[] {cx, cy, td, tc});
				}else {
					break;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(room[i][j] != "#")
					res = Math.max(res, Integer.parseInt(room[i][j]));
			}
		}
		
		System.out.println(res);
	}
}