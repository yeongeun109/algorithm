package algo_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_2866_문자열잘라내기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			arr[i] = str.toCharArray();
		}
		
		int cnt = 0;
		boolean f = false;
		int left = 0, mid = 0;
		int right = N - 1;
		
		while(left <= right) {
			mid = (left + right) / 2;
			ArrayList<String> list = new ArrayList<String>();
			boolean flag = false;
			
			for(int i = 0; i < M; i++) {
				String str = "";
				for(int j = mid; j < N; j++) {
					str += arr[j][i];
				}
				//System.out.println(str);
				if(list.contains(str)) {
					flag = true;
					break;
				}else {
					list.add(str);
				}
			}
			
			if(flag) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
			
			f = flag;
		}
		
		if(f)
			cnt = mid - 1;
		else
			cnt = mid;
		
		System.out.println(cnt);
	}

}

/*
5 4
afkx
bgly
chmc
dind
ejoe
*/
