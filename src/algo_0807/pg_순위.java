package algo_0807;

public class pg_순위 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int n, int[][] results) {
        int[][] check = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i==j) check[i][j] = 0;
                else check[i][j] = 999999;
            }
        }
        
        for(int i = 0; i < results.length; i++){
            int a = results[i][0] - 1;
            int b = results[i][1] - 1;
            check[a][b] = 1;
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(check[i][j] > check[i][k] + check[k][j])
                        check[i][j] = check[i][k] + check[k][j];
                }
            }
        }
        
//        for(int k = 0; k < n; k++){
//            System.out.println(Arrays.toString(check[k]));   
//        }        
        int answer = 0;
        for(int i = 0; i < n; i++){
            boolean flag = false;
            for(int j = 0; j < n; j++){
                if(check[i][j] == 999999 && check[j][i] == 999999){
                    flag = true;
                }
            }
            
            if(!flag)
                answer++;
        }
        return answer;
    }
}
