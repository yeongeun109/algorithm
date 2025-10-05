

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2164_카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Queue<Integer> card = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			card.add(i);
		}
		
		while(card.size() > 1) {
			card.remove();
			card.add(card.poll());
		}
		
		System.out.print(card.poll());
	}

}
