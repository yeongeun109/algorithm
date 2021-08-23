package algo_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16935 {

	static int N;
	static int M;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str1 = in.readLine();
		StringTokenizer st1 = new StringTokenizer(str1, " ");
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		int R = Integer.parseInt(st1.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str2 = in.readLine();
			StringTokenizer st2 = new StringTokenizer(str2, " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		String str3 = in.readLine();
		StringTokenizer st3 = new StringTokenizer(str3, " ");

		for(int r = 0; r < R; r++) {
			int oper = Integer.parseInt(st3.nextToken());
			
			switch(oper) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				arr = three();
				int temp = N;
				N = M;
				M = temp;
				break;
			case 4:
				arr = four();
				int temp2 = N;
				N = M;
				M = temp2;
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void one() {
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N-i-1][j];
				arr[N-i-1][j] = temp;
			}
		}
	}
	
	private static void two() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M-j-1];
				arr[i][M-j-1] = temp;
			}
		}
	}

	private static int[][] three() {
		int[][] newArr = new int[M][N];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				newArr[i][j] = arr[N-j-1][i];
			}
		}

		return newArr;
	}
	
	private static int[][] four() {
		int[][] newArr = new int[M][N];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				newArr[i][j] = arr[j][M-i-1];
			}
		}

		return newArr;
	}

	private static void five() {
		Queue<Integer> temp1 = new LinkedList<Integer>();
		Queue<Integer> temp2 = new LinkedList<Integer>();
		Queue<Integer> temp3 = new LinkedList<Integer>();
		Queue<Integer> temp4 = new LinkedList<Integer>();

		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i < N/2 && j < M/2) {
					temp1.offer(arr[i][j]);
				}else if(i < N/2 && j >= M/2) {
					temp2.offer(arr[i][j]);
				}else if(i >= N/2 && j < M/2) {
					temp4.offer(arr[i][j]);
				}else if(i >= N/2 && j >= M/2) {
					temp3.offer(arr[i][j]);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i < N/2 && j < M/2) {
					arr[i][j] = temp4.poll();
				}else if(i < N/2 && j >= M/2) {
					arr[i][j] = temp1.poll();
				}else if(i >= N/2 && j < M/2) {
					arr[i][j] = temp3.poll();
				}else if(i >= N/2 && j >= M/2) {
					arr[i][j] = temp2.poll();
				}
			}
		}
	}

	private static void six() {
		Queue<Integer> temp1 = new LinkedList<Integer>();
		Queue<Integer> temp2 = new LinkedList<Integer>();
		Queue<Integer> temp3 = new LinkedList<Integer>();
		Queue<Integer> temp4 = new LinkedList<Integer>();

		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i < N/2 && j < M/2) {
					temp1.offer(arr[i][j]);
				}else if(i < N/2 && j >= M/2) {
					temp2.offer(arr[i][j]);
				}else if(i >= N/2 && j < M/2) {
					temp4.offer(arr[i][j]);
				}else if(i >= N/2 && j >= M/2) {
					temp3.offer(arr[i][j]);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i < N/2 && j < M/2) {
					arr[i][j] = temp2.poll();
				}else if(i < N/2 && j >= M/2) {
					arr[i][j] = temp3.poll();
				}else if(i >= N/2 && j < M/2) {
					arr[i][j] = temp1.poll();
				}else if(i >= N/2 && j >= M/2) {
					arr[i][j] = temp4.poll();
				}
			}
		}
	}
}
