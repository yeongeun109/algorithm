package algo_202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 완탐_bj_16637_괄호추가하기 {

	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> ch = new ArrayList<>();
	static boolean[] calcornot;
	static int res = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();

		if (str.length() != 1) {
			calcornot = new boolean[N / 2];

			for (int i = 0; i < N; i++) {
				if (i % 2 == 0)
					num.add(str.charAt(i) - '0');
				else
					ch.add(str.charAt(i));
			}
			comb(ch.size(), 0);
			System.out.println(res);
		} else {
			System.out.println(str);
		}
	}

	private static void comb(int l, int cnt) {
		if (cnt == l) {
			ArrayList<Integer> tn = new ArrayList<>();
			ArrayList<Character> tc = new ArrayList<>();
			int j = 0, k = 0;
			for (int i = 0; i < l; i++) {
				if (calcornot[i]) {
					char c = ch.get(j);
					int a = num.get(k);
					int b = num.get(k + 1);
					if (c == '+')
						tn.add(a + b);
					else if (c == '-')
						tn.add(a - b);
					else
						tn.add(a * b);

					k += 2;
					if (j < l - 1) {
						tc.add(ch.get(j + 1));
						j += 2;
					}
				} else {
					if (i == 0) {
						tn.add(num.get(k++));
						tc.add(ch.get(j++));
					} else if (!calcornot[i - 1]) {
						tn.add(num.get(k++));
						if (j <= l - 1)
							tc.add(ch.get(j++));
					}
					if (i == l - 1)
						tn.add(num.get(k));
				}
			}

			res = Math.max(res, calc(tn, tc));
			return;
		}

		if (cnt != 0) {
			if (calcornot[cnt - 1]) {
				calcornot[cnt] = false;
				comb(l, cnt + 1);
			} else {
				calcornot[cnt] = false;
				comb(l, cnt + 1);
				calcornot[cnt] = true;
				comb(l, cnt + 1);
			}
		} else {
			calcornot[cnt] = false;
			comb(l, cnt + 1);
			calcornot[cnt] = true;
			comb(l, cnt + 1);
		}
	}

	static public int calc(ArrayList<Integer> num, ArrayList<Character> ch) {
		int n = num.get(0);
		for (int i = 1; i < num.size(); i++) {
			char c = ch.get(i - 1);
			int n2 = num.get(i);
			if (c == '+') {
				n += n2;
			} else if (c == '-') {
				n -= n2;
			} else {
				n *= n2;
			}
		}

		return n;
	}

}
