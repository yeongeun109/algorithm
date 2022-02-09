package algo_202111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 문자열_bj_3107_IPv6 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String[] arr = str.split(":");
		if(arr.length != 8) {
			arr = str.split("::");
		}
		Queue<String> q = new LinkedList<String>();
		
		int idx = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == "")
				idx = i;
			else
				q.offer(arr[i]);
		}
		
		if(idx == -1 && str.charAt(str.length()-1) == ':' && str.charAt(str.length()-2) == ':')
			idx = q.size();
		
		String[] res = new String[8];
		StringBuilder sb = new StringBuilder();
		if(arr.length == 8) {
			for(int i = 0; i < 7; i++)
				sb.append(arr[i]).append(":");
			sb.append(arr[7]);
		}else if(arr.length == 0){
			for(int i = 0; i < 7; i++)
				sb.append("0000:");
			sb.append("0000");
		}else if(idx == -1) {
			if(q.size() == 1) {
				sb.append(q.poll());
			}else {
				String l = q.poll();
				String r = q.poll();
				int lnum = checkCol(l) + 1;
				int rnum = checkCol(r) + 1;
				sb.append(l).append(":");
				
				for(int i = 0; i < 8 - (lnum + rnum); i++)
					sb.append("0000:");
				sb.append(r);
			}
			
		}else {
			if(idx == 0) {
				for(int i = 0; i < 8 - q.size(); i++)
					sb.append("0000:");
				for(int i = 8 - q.size(); i < 8; i++) {
					String s = q.poll();
					if(s.length() != 4) {
						String tmp = "";
						for(int j = 0; j < 4 - s.length(); j++)
							tmp += "0";
						s = tmp + s;
					}
					sb.append(s);
					if(i < 7)
						sb.append(":");
				}
			}else {
				String l = q.poll();
				int lnum = checkCol(l) + 1;
				sb.append(l).append(":");
				
				for(int i = 0; i < 7 - lnum; i++) {
					sb.append("0000:");
				}
				sb.append("0000");
			}
		}
		
		arr = sb.toString().split(":");
		sb = new StringBuilder();
		for(int i = 0; i < 8; i++) {
			if(arr[i].length() < 4) {
				String tmp = "";
				for(int j = 0; j < 4 - arr[i].length(); j++)
					tmp += "0";
				arr[i] = tmp + arr[i];
			}
			sb.append(arr[i]);
			if(i != 7)
				sb.append(":");
		}
		
		System.out.println(sb);
	}

	private static int checkCol(String l) {
		int cnt = 0;
		for(int i = 0; i < l.length(); i++) {
			if(l.charAt(i) == ':')
				cnt++;
		}
		return cnt;
	}

}
