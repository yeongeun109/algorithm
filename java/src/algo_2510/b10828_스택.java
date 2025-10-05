package algo_2510;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		ArrayList<Integer> stack = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String word = st.nextToken();
			
			if(word.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.add(num);
			}else if(word.equals("top")) {
				int len = stack.size();
				if(len != 0)
					System.out.println(stack.get(len - 1));
				else
					System.out.println("-1");
			}else if(word.equals("pop")) {
				int len = stack.size();
				if(len != 0)
					System.out.println(stack.remove(len - 1));
				else
					System.out.println("-1");
			}else if(word.equals("size")) {
				System.out.println(stack.size());
			}else if(word.equals("empty")) {
				if(stack.size() == 0)
					System.out.println("1");
				else
					System.out.println("0");
			}
		}
	}

}
