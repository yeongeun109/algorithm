package algo_202108;
import java.util.ArrayList;

public class 구현_pg_정수삼각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;

        ArrayList<Integer>[] list = new ArrayList[n];

        for(int i = 0; i < n; i++)
            list[i] = new ArrayList<Integer>();
        list[0].add(triangle[0][0]);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0)
                    list[i].add(triangle[i][j] + list[i-1].get(0));
                else if(i == j)
                    list[i].add(triangle[i][j] + list[i-1].get(j-1));
                else{
                    int max = Integer.max(list[i-1].get(j-1), list[i-1].get(j));
                    list[i].add(triangle[i][j] + max);
                }
            }
        }

        for(int i = 0; i < list[n-1].size(); i++){
            answer = Integer.max(answer, list[n-1].get(i));
        }
        
        return answer;
    }
}
