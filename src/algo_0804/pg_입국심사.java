package algo_0804;

import java.util.Arrays;

public class pg_입국심사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n = 6;
		//times = {7,10};
		//결과 28
	}

	
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);
        long left = 0;
        long right = (long)n * (long)(times[times.length - 1]);
        
        while(left <= right){
            long mid = (left + right) / 2;
            long tmpCnt = 0;
            for(int i = 0; i < times.length; i++){
                tmpCnt += mid/times[i];
            }

            if(tmpCnt >= n){
                right = mid - 1;                
                //if(tmpCnt == n)
                    answer = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
	
}
