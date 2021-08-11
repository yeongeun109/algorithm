package algo_0806;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pg_네트워크 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(3, new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
	}
static int[] parents;
    
    static public int solution(int n, int[][] computers) {
        int answer = 0;
        parents = new int[n];
        List<Integer>[] list = new ArrayList[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<Integer>();
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1)
                    list[i].add(j);
            }
        }
        make(n);
        //answer = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < list[i].size(); j++){
                //if(union(i, j))
                    //answer--;
                union(i, list[i].get(j));
            }
        }
        System.out.println(Arrays.toString(parents));
        boolean[] p = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!p[parents[i]]){
                p[parents[i]] = true;
                answer++;
            }
        }
        
        return answer;
    }
    
    static public void make(int n){
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }
    
    static public boolean union(int a, int b){       
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB)
            return false;
        
        parents[rootB] = rootA;
        return true;
    }
    
    static public int find(int a){
        if(parents[a] == a)
            return a;
        
        return parents[a] = find(parents[a]);
    }
}
