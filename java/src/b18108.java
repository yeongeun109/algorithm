

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b18108 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] str = new int[n];
		int cnt = 0;
		//String str = new String();
		//str = in.readLine();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < n; i++) {
			str[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = Integer.parseInt(in.readLine());
		for(int i = 0; i < n; i++) {
			if(str[i] == num)
				cnt++;
		}
		
		System.out.println(cnt);
	}

}
