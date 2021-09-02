package algo_202109;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 구현_pg_기둥과보설치 {

	public static void main(String[] args) {
		solution(5, new int[][] {{1,0,0,1},{1,1,1,1,},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
//		solution(5, new int[][] {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0}, {2,2,0,1}});
	}
	
	static public class Installed implements Comparable<Installed>{
        int x;
        int y;
        int a;
        
        public Installed(int x, int y, int a){
            this.x = x;
            this.y = y;
            this.a = a;
        }
        
        
        public int getX() {
			return x;
		}


		public int getY() {
			return y;
		}


		public int getA() {
			return a;
		}


		@Override
        public String toString() {
        	// TODO Auto-generated method stub
        	return "[" + this.x + ", " + this.y + ", " + this.a + "]";
        }
        
        @Override
        public int compareTo(Installed o){
            int diff = this.x - o.x;
            if(diff == 0){
                if(this.y - o.y == 0)
                    return this.a - o.a;
                
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    
    static public void solution(int n, int[][] build_frame) {
        
        int[][] arr = new int[n + 1][n + 1];
        ArrayList<Installed> list = new ArrayList<Installed>();
        
        for(int i = 0; i < build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2]; // 0 = 기둥, 1 = 보 ==> 1 = 보, 2 = 기둥
            int b = build_frame[i][3]; // 0 = 삭제, 1 = 설치
            
            if(b == 1){
                if(arr[x][y] != 0) // 이미 뭔가 설치돼있다면 pass
                    continue;
                
                if(a == 0){ // 기둥 설치
                    if(y == 0 || (x > 0 && arr[y][x - 1] == 1) || (y > 0 && arr[y - 1][x] == 2)){
                        arr[y][x] = 2;
                        // list 추가
                        list.add(new Installed(x, y, 0));
                    }
                }else{ // 보 설치
                    if((y > 0 && arr[y - 1][x] == 2) || (x < n && y > 0 && arr[y - 1][x+1] == 2) || (x > 0 && arr[y][x-1] == 1 && (x < n && arr[y][x+1] == 1))){
                        arr[y][x] = 1;
                        list.add(new Installed(x, y, 1));
                    }
                }
            }else{
                if(a == 0){ // 기둥 삭제
                    arr[y][x] = 0;
                    if(x == 0 || (x > 0 && arr[y][x - 1] == 1) || (y > 0 && arr[y - 1][x] == 2)){
                        list.remove(list.indexOf(new Installed(x, y, 0)));
                    }else{
                        arr[y][x] = 2; // 다시 기둥 놓기
                    }
                }else{ // 보 삭제
                    arr[y][x] = 0;
                    if((y > 0 && arr[y - 1][x] == 2) || (x < n && y > 0 && arr[y - 1][x+1] == 2) || (x > 0 && arr[y][x-1] == 1 && (x < n && arr[y][x+1] == 1))){
                        list.remove(list.indexOf(new Installed(x, y, 1)));
                    }else{
                        arr[y][x] = 1; // 다시 보 놓기
                    }
                }
            }
        } 
        Collections.sort(list);
        //for(int i = 0; i < list.size(); i++){
            System.out.println(list.toString());
        //}
        int[][] answer = new int[list.size()][3];
        
        for(int i = 0; i < list.size(); i++) {
        	Installed tmp = list.get(i);
        	answer[i] = new int[] {tmp.getX(), tmp.getY(), tmp.getA()};
        }
//        return answer;
    }
    
    static public boolean check(int[][] arr){
        boolean flag = true;
        
        return flag;
    }
}
