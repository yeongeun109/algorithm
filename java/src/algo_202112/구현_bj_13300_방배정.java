package algo_202112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구현_bj_13300_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int res = 0;
		int oneG = 0, oneB = 0, twoG = 0, twoB = 0, threeG = 0, threeB = 0, fourG = 0, fourB = 0, fiveG = 0, fiveB = 0,
				sixG = 0, sixB = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int S = Integer.parseInt(st.nextToken()); // 성별
			int Y = Integer.parseInt(st.nextToken()); // 학년

			if (Y == 1) {
				if (S == 0) {
					oneG++;
					if (oneG >= K) {
						oneG = 0;
						res++;
					}
				} else {
					oneB++;
					if (oneB >= K) {
						oneB = 0;
						res++;
					}
				}
			} else if (Y == 2) {
				if (S == 0) {
					twoG++;
					if (twoG >= K) {
						twoG = 0;
						res++;
					}
				} else {
					twoB++;
					if (twoB >= K) {
						twoB = 0;
						res++;
					}
				}
			} else if (Y == 3) {
				if (S == 0) {
					threeG++;
					if (threeG >= K) {
						threeG = 0;
						res++;
					}
				} else {
					threeB++;
					if (threeB >= K) {
						threeB = 0;
						res++;
					}
				}
			} else if (Y == 4) {
				if (S == 0) {
					fourG++;
					if (fourG >= K) {
						fourG = 0;
						res++;
					}
				} else {
					fourB++;
					if (fourB >= K) {
						fourB = 0;
						res++;
					}
				}
			} else if (Y == 5) {
				if (S == 0) {
					fiveG++;
					if (fiveG >= K) {
						fiveG = 0;
						res++;
					}
				} else {
					fiveB++;
					if (fiveB >= K) {
						fiveB = 0;
						res++;
					}
				}
			} else if (Y == 6) {
				if (S == 0) {
					sixG++;
					if (sixG >= K) {
						sixG = 0;
						res++;
					}
				} else {
					sixB++;
					if (sixB >= K) {
						sixB = 0;
						res++;
					}
				}
			}
		}
		
		if(oneG != 0)
			res++;
		if(oneB != 0)
			res++;
		if(twoG != 0)
			res++;
		if(twoB != 0)
			res++;
		if(threeG != 0)
			res++;
		if(threeB != 0)
			res++;
		if(fourG != 0)
			res++;
		if(fourB != 0)
			res++;
		if(fiveG != 0)
			res++;
		if(fiveB != 0)
			res++;
		if(sixG != 0)
			res++;
		if(sixB != 0)
			res++;
		System.out.println(res);
	}

}
