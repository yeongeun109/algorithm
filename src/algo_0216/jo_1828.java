package algo_0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class jo_1828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] chem = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int tempLow = Integer.parseInt(st.nextToken());
			int tempHigh = Integer.parseInt(st.nextToken());
			chem[n] = new int[] {tempLow, tempHigh};
		}

		Arrays.sort(chem, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) { 
				return o1[0] <= o2[0] ? -1 : 1;
			}
			
		});
		
		int cnt = 1;
		int max = chem[0][1];
		
		for(int i = 1; i < N; i++){
			if(chem[i][0] <= max) {
				if(chem[i][1] < max) {
					max = chem[i][1];
				}
				continue;
			}else {
				max = chem[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
