package algo_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_20299_3대측정 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine(); // 첫번째 줄 입력(N,S,M)
		StringTokenizer st = new StringTokenizer(str, " "); //str을 공백을 기준으로 토큰화
		int N = Integer.parseInt(st.nextToken()); // 신청한 동아리의 수
		int S = Integer.parseInt(st.nextToken()); // 팀원 3명의 능력합에 대한 스마트클럽 가입조건
		int M = Integer.parseInt(st.nextToken()); // 개인 능력치에 대한 스마트클럽 가입조건
		
		int resultNum = 0; //스마트클럽 가입이 가능한 동아리의 수
		Queue<Integer> queue = new LinkedList<Integer>(); // 스마트클럽 가입이 가능한 학생들의 능력치를 저장할 큐
		
		for(int n = 0; n < N; n++) {
			String str2 = in.readLine(); // 다음줄 입력(동아리원들의 능력치 x1, x2, x3)
			StringTokenizer st2 = new StringTokenizer(str2, " "); //str을 공백을 기준으로 토큰화
			int x1 = Integer.parseInt(st2.nextToken()); //학생1의 능력치
			int x2 = Integer.parseInt(st2.nextToken()); //학생2의 능력치
			int x3 = Integer.parseInt(st2.nextToken()); //학생3의 능력치
			
			if(x1 >= M && x2 >= M && x3 >= M) { //만약 세 학생의 능력치가 모두 M이상이고
				if(x1 + x2 + x3 >= S) { // 세 학생의 능력치의 합이 S보다 크거나 같을 때
					resultNum++; // 가입이 가능한 동아리수 증가
					queue.offer(x1); //queue에 각 능력치를 저장
					queue.offer(x2);
					queue.offer(x3);
				}else {
					continue;
				}
			}else {
				continue; //만약 세 학생 중 한명이라도 M이하라면 연산하지 않고 넘어감
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(resultNum).append("\n");

		while(!queue.isEmpty()) {
			sb.append(queue.poll() + " "); //queue의 앞에서부터 학생의 능력치를 출력
		}
		System.out.println(sb);
	}
}
