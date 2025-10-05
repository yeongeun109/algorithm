

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b27866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String word = in.readLine();
		int i = Integer.parseInt(in.readLine());
		
		System.out.print(word.charAt(i - 1));
	}

}
