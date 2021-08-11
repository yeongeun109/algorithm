package algo_0807;

import java.util.HashMap;
import java.util.Map;

public class pg_완주하지못한선수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        for(int i = 0; i < completion.length; i++){
            map.put(completion[i], map.get(completion[i]) - 1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key) != 0)
                answer = key;
        }
//         Arrays.sort(participant);
//         Arrays.sort(completion);
        
//         for(int i = 0; i < completion.length; i++){
//             if(!participant[i].equals(completion[i])){
//                 answer = participant[i];
//                 break;
//             }
//         }
//         if(answer.equals(""))
//             answer = participant[participant.length - 1];
        
        return answer;
    }
}
