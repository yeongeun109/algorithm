package algo_2510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b5430_AC {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			String method = in.readLine();
			int n = Integer.parseInt(in.readLine());
			String str = in.readLine();
			Boolean errorFlag = false;
			
			
//			if(n == 0) {
//				sb.append("error\n");
//				continue;
//			}else {
//				str = str.substring(1, str.length() - 1);
//				if(str.equals("")) {
//					sb.append("error\n");
//					continue;
//				}
			str = str.substring(1, str.length() - 1);
				String[] arr = new String[str.length()];
				arr = str.split(",");
								
				ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
				int left = 0;
				int right = list.size() - 1;
				String startPoint = "Left";
				
				for(int j = 0; j < method.length(); j++) {				
					if(method.charAt(j) == 'R') { // 뒤집기
						if(startPoint.equals("Left"))
							startPoint = "Right";
						else
							startPoint = "Left";
					}else { // D(제거)
						if(left > right || n == 0) {
							errorFlag = true;
							sb.append("error\n");
							break;
						}
						
						if(startPoint.equals("Left"))
							left++;
						else
							right--;
					}
				}
				
				if(!errorFlag) {
					sb.append("[");
					if(startPoint == "Left") {
						for(int j = left; j <= right; j++) {
							if(j == right)
								sb.append(list.get(j));
							else
								sb.append(list.get(j) + ",");
						}
					}else {
						for(int j = right; j >= left; j--) {
							if(j == left)
								sb.append(list.get(j));
							else
								sb.append(list.get(j) + ",");
						}
					}
					
					sb.append("]\n");
				}
			//}
		}
		
		System.out.print(sb);
	}

}
