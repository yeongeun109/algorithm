package algo_0804;

import java.util.Arrays;

public class pg_타겟넘버 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,1,1, 1, 1}, 3));
	}
	
	static int answer = 0;
	static int[] selected = new int[5];
    static public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int cnt, int start){
        if(start == numbers.length){
            if(cnt == target) {
                answer++;
            }
            return;
        }
        
        cnt += numbers[start];
        dfs(numbers, target, cnt, start + 1);
        
        cnt -= numbers[start] *2;
        dfs(numbers, target, cnt, start + 1);
    }
}
