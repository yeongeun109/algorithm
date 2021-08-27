package algo_202108.a0810;
import java.util.*;

public class pg_단어변환_문자열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static String target;
    static boolean[] visited;
    static int res = 0;
    
    public int solution(String begin, String target, String[] words) {
        target = target;
        visited = new boolean[words.length];
        bfs(begin, target, words);

        int answer = res;
        return answer;
    }
    
    static public void bfs(String begin, String target, String[] words){
        Queue<AvailWord> q = new LinkedList<AvailWord>();
        q.offer(new AvailWord(begin, 0, visited));
        
        while(!q.isEmpty()){
            AvailWord tmp = q.poll();
            //System.out.println(tmp.word + " " + tmp.cnt + Arrays.toString(tmp.t_visited));
            if(tmp.word.equals(target)){
                res = tmp.cnt;
                break;
            }
            for(int i = 0; i < words.length; i++){
                if(!tmp.t_visited[i]){
                    boolean flag = true;
                    int sameCnt = 0;
                    
                    for(int j = 0; j < target.length(); j++){
                        if(tmp.word.charAt(j) != words[i].charAt(j)){
                            if(++sameCnt > 1){
                                flag = false;
                                break;
                            }
                        }
                        
                    }
                    
                    if(!flag)
                        continue;
                    
                    tmp.t_visited[i] = true;
                    q.offer(new AvailWord(words[i], tmp.cnt + 1, tmp.t_visited));
                }
            }
        }
    }
    
    static class AvailWord{
        String word;
        int cnt;
        boolean[] t_visited;
        
        public AvailWord(String word, int cnt, boolean[] t_visited){
            this.word = word;
            this.cnt = cnt;
            this.t_visited = t_visited;
        }
    }
}
