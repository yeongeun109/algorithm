package algo_202108;
import java.util.ArrayList;
import java.util.HashSet;

public class pg_불량사용자_문자열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static boolean[] selected;
    static ArrayList<Integer>[] list;
    static int N, M;
    static HashSet<String> set = new HashSet<String>();
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        N = banned_id.length;
        M = user_id.length;
        selected = new boolean[user_id.length];
        list = new ArrayList[banned_id.length];
        for(int i = 0; i < banned_id.length; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < banned_id.length; i++){
            for(int j = 0; j < user_id.length; j++){
                if(banned_id[i].length() == user_id[j].length()){
                    boolean flag = true;
                    
                    for(int k = 0; k < banned_id[i].length(); k++){
                        if(banned_id[i].charAt(k) != '*'){
                            if(banned_id[i].charAt(k) != user_id[j].charAt(k)){
                                flag = false;
                                break;
                            }
                        }
                    }
                    
                    if(flag){
                        list[i].add(j);
                    }
                }
            }
        }
        dfs(list, 0);
        answer = set.size();
        return answer;
    }
    
    
    static public void dfs(ArrayList<Integer>[] list, int cnt){
        if(cnt == N){
            String res = "";
            for(int i = 0; i < M; i++){
                if(selected[i])
                    res += i;
            }
            set.add(res);
            return;
        }
        
        for(int i = 0; i < list[cnt].size(); i++){
            if(!selected[list[cnt].get(i)]){
                selected[list[cnt].get(i)] = true;
                dfs(list, cnt + 1);
                selected[list[cnt].get(i)] = false;
            }
        }
    }
}
