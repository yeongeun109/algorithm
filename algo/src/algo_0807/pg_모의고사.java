package algo_0807;
import java.util.ArrayList;
public class pg_모의고사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	public ArrayList<Integer> solution(int[] answers) {
	    int[] one = {1,2,3,4,5};
	    int[] two = {2,1,2,3,2,4,2,5};
	    int[] three = {3,3,1,1,2,2,4,4,5,5};
	    int[] score = new int[3];
	    
	    for(int i = 0; i < answers.length; i++){
	        if(one[i%5] == answers[i])
	            score[0]++;
	    }
	    for(int i = 0; i < answers.length; i++){
	        if(two[i%8] == answers[i])
	            score[1]++;
	    }
	    for(int i = 0; i < answers.length; i++){
	        if(three[i%10] == answers[i])
	            score[2]++;
	    }
	
	    int max = 0;
	    int idx = 0;
	    ArrayList<Integer> answer = new ArrayList<Integer>();
	    for(int i = 0; i < 3; i++){
	        if(score[i] > max){
	            max = score[i];
	        }
	    }
	    
	    for(int i = 0; i < 3; i++){
	        if(score[i] == max)
	            answer.add(i+1);
	    }
	    
	    return answer;
	}
}
