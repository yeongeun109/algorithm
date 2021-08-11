package algo_0201;

import java.util.Scanner;

public class bj_17478_재귀함수가뭔가요 {

	static int n;
	
	public static void underBar(int a, StringBuilder sb) {
		for(int i = 0; i < (n - a) * 4; i++) {
			sb.append("_");
		}
	}
	
	public static void chatBot(int a) {
		StringBuilder sb = new StringBuilder();
		
		if(a == 0) {
			StringBuilder sb3 = new StringBuilder();
			underBar(a, sb3);
			sb3.append("\"����Լ��� ������?\"\n");
			underBar(a, sb3);
			sb3.append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
			underBar(a, sb3);
			sb3.append("��� �亯�Ͽ���.\n");
			System.out.print(sb3);
			return;
		}
		
		underBar(a, sb);
		sb.append("\"����Լ��� ������?\"\n");
		underBar(a, sb);
		sb.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
		underBar(a, sb);
		sb.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
		underBar(a, sb);
		sb.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
		System.out.print(sb);
		chatBot(a-1);
		
		StringBuilder sb2 = new StringBuilder();
		underBar(a, sb2);
		sb2.append("��� �亯�Ͽ���.");
		System.out.println(sb2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		
		chatBot(n);
	}

}
