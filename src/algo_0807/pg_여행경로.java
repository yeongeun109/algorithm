package algo_0807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class pg_여행경로 {
	static String[] answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//String[][] tickets = {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}};
		System.out.println(Arrays.toString(solution(tickets)));
		
	}
	static ArrayList<String> list = new ArrayList<String>();
    static boolean[] visited;
    
    static public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, 0, "ICN", "ICN");
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        return answer;
    }
    
    static public void dfs(String[][] tickets, int cnt, String prev, String tmpAns){
        if(cnt == tickets.length){
            list.add(tmpAns);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals(prev) && !visited[i]){
                visited[i] = true;
                dfs(tickets, cnt + 1, tickets[i][1], tmpAns + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
        
        return;
    }
}
