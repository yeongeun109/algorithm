package algo_2510;
import java.util.*;

public class p_아이템줍기_BFS {

	public static void main(String[] args) {
	}

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 10000;
        int[][] area = new int[101][101];
        int N = rectangle.length;
        int M = rectangle[0].length;
        int[] start = new int[2];
        int[] end = new int[2];
        boolean[][] visited = new boolean[101][101];

        // 도형 그리기
        for(int i = 0; i < N; i++){
            int[] rec = rectangle[i];
            int x1 = rec[0] * 2;
            int x2 = rec[2] * 2;
            int y1 = rec[1] * 2;
            int y2 = rec[3] * 2;

            for(int j = x1; j <= x2; j++){
                for(int k = y1; k <= y2; k++){
                    if(j == x1 || j == x2 || k == y1 || k == y2)
                        area[j][k] = 1; // 테두리
                    else
                        area[j][k] = 0; // 내부
                }
            }
        }

        for(int i = 0; i < N; i++){
            int[] rec = rectangle[i];
            int x1 = rec[0] * 2;
            int x2 = rec[2] * 2;
            int y1 = rec[1] * 2;
            int y2 = rec[3] * 2;

            for(int j = x1 + 1; j < x2; j++){
                for(int k = y1 + 1; k < y2; k++){
                    area[j][k] = 0;
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        start[0] = characterX * 2;
        start[1] = characterY * 2;
        end[0] = itemX * 2;
        end[1] = itemY * 2;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == end[0] && tmp[1] == end[1]){
                answer = Math.min(answer, tmp[2]);
                break;
            }

            for(int i = 0; i < 4; i++){
                int cx = tmp[0] + dx[i];
                int cy = tmp[1] + dy[i];

                if(cx < 0 || cx >= 101 || cy < 0 || cy >= 101 || visited[cx][cy])
                    continue;

                if(area[cx][cy] == 1){
                    q.add(new int[]{cx, cy, tmp[2] + 1});
                    visited[cx][cy] = true;
                }
            }
        }

        return answer / 2;
    }
}
