package algo_0422;

import java.util.Scanner;
import java.util.Stack;

public class bj_9935_문자열폭발 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String bomb = sc.nextLine();
		Stack<Character> st = new Stack<Character>();
		Stack<Character> tmp = new Stack<Character>();
		char lastBomb = bomb.charAt(bomb.length() - 1);

		for (int i = 0; i < str.length(); i++) {
			st.push(str.charAt(i));
			char tmpLast = lastBomb;
			if (st.size() >= bomb.length()) {
				int j = bomb.length() - 1;
				boolean flag = false;

				while (st.peek() == tmpLast) {
					tmp.push(st.pop());
					if (--j >= 0)
						tmpLast = bomb.charAt(j);
					else {
						flag = true;
						break;
					}
				}
				if (!flag) {
					while (!tmp.isEmpty())
						st.push(tmp.pop());
				}
				tmp.clear();
			}
		}

		if (st.isEmpty())
			System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			while (!st.isEmpty()) {
				sb.append(st.pop());
			}
			System.out.println(sb.reverse());
		}
	}

}
