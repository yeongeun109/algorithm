package algo_202112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구현_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int w1 = Integer.parseInt(st.nextToken());
			int z1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int w2 = Integer.parseInt(st.nextToken());
			int z2 = Integer.parseInt(st.nextToken());
			
			int oneGaro = Math.abs(z1 - y1);
			int oneSero = Math.abs(w1 - x1);
			int twoGaro = Math.abs(y2 - z2);
			int twoSero = Math.abs(x2 - w2);
			
			int garoSum = y1 < y2 ? z2 - y1 : z1 - y2;
			int seroSum = x1 < x2 ? w2 - x1 : w1 - x2;
			
			if((garoSum < oneGaro + twoGaro && seroSum == oneSero + twoSero)
					|| (garoSum == oneGaro + twoGaro && seroSum < oneSero + twoSero))
				System.out.println("b");
			else if(garoSum == oneGaro + twoGaro && seroSum == oneSero + twoSero)
				System.out.println("c");
			else if(garoSum > oneGaro + twoGaro || seroSum > oneSero + twoSero)
				System.out.println("d");
			else
				System.out.println("a");
		}
	}

}
