package algo_0423;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class kakao_경주로건설 {

	public static class Line{
		int x;
		int y;
		int direction;
        int sum;

		public Line(int x, int y, int direction, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
            this.sum = sum;
		}
	}
	
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] board =  {
				{0, 0, 0}, {0, 0, 0}, {0, 0, 0}
		};
		/*int[][] board =  {
				{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0},
				{0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, {0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}
		};*/
		
		/*int[][] board = {
				{0,0,1,0} ,{0,0,0,0}, {0,1,0,1}, {1,0,0,0}
		};*/
		
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
        int N = board.length;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		Queue<Line> q = new LinkedList<Line>();
		int[][] visited = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
        
		visited[0][0] = 0;
		Line line = new Line(0, 0, -1, 0);
		q.offer(line);
		
		while(!q.isEmpty()) {
			Line tmp = q.poll();
			int currX = tmp.x;
			int currY = tmp.y;
			int currDir = tmp.direction;
            int currSum = tmp.sum;
			
			for(int i = 0; i < 4; i++) {
				int tempX = currX + dx[i];
				int tempY = currY + dy[i];
				int tempSum = currSum;
				if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= N || board[tempX][tempY] == 1)
					continue;
				
				if(currDir != -1) {
                    if(currDir != i)
                        tempSum += 600;
                    else
                        tempSum += 100;
				}else {
					tempSum += 100;
				}
				
				if(tempSum <= visited[tempX][tempY]) {
					q.offer(new Line (tempX, tempY, i, tempSum));
					visited[tempX][tempY] = tempSum;
				}
			}
		}		
		
		return visited[N-1][N-1];
    }
}
