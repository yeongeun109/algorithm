package algo_202108;

public class 완탐_pg_자물쇠와열쇠 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int startI = 0, endI = 0;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        int size = 2 * key.length + lock.length - 2;
        int[][] board = new int[size][size];
        int locki = 0, lockj = 0;
        startI = key.length - 1;
        endI = startI + lock.length;
        
        for(int i = startI; i < endI; i++){
            lockj = 0;
            for(int j = startI; j < endI; j++){
                board[i][j] = lock[locki][lockj];
                lockj++;
            }
            locki++;
        }
        
        int[][] tmpBoard = new int[board.length][board.length];
        size = lock.length;
        boolean flag = false;
        
        for(int i = 0; i < 4; i++){ // 회전
            key = turn(key);
            
            for(int j = 0; j <= board.length - key.length; j++){
                for(int k = 0; k <= board.length - key.length; k++){
                    if(calc(board, key, j, k)){
                        flag = true;
                        answer = true;
                        break;
                    }
                   
                }
                
                if(flag)
                    break;
            }
            
            if(flag)
                break;
        }
        
        return answer;
    }

    static public boolean calc(int[][] board, int[][] key, int x, int y){
        int[][] arr = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                arr[i][j] = board[i][j];
            }
        }
        
        int keyI = 0, keyJ = 0;
        for(int i = x; i < x + key.length; i++){
            keyJ = 0;
            for(int j = y; j < y + key.length; j++){
                arr[i][j] += key[keyI][keyJ++];
                if(arr[i][j] == 2)
                    return false;
            }
            keyI++;
        }
        
        for(int i = startI; i < endI; i++){
            for(int j = startI; j < endI; j++){
                if(arr[i][j] != 1)
                    return false;
            }
        }

        return true;
    }
    
    static public int[][] turn(int[][] key){
        int[][] turned = new int[key.length][key[0].length];
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key[i].length; j++){
                turned[j][key.length - 1 - i] = key[i][j];
            }
        }
        return turned;
    }
}
