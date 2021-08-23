package algo_0804;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pg_가장먼노드 {
	static int[] cost;
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		int answer = 0;
		cost = new int[n+1];
        
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i ++){
            cost[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        bfs(list, n);
        //System.out.println(Arrays.toString(cost));
        int max = 0;
        for(int i = 2; i < n + 1; i++){
            max = Math.max(max, cost[i]);
        }
        
        for(int i = 2; i < n + 1; i++){
            if(cost[i] == max)
                answer++;
        }
        //System.out.println(answer);
    }
    
	static public void bfs(List<Integer>[] list, int n) {
		boolean[] visited = new boolean[n + 1];
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i = 0; i < list[1].size(); i++) {
			q.offer(new int[] {list[1].get(i), 1});
			visited[list[1].get(i)] = true;
			cost[list[1].get(i)] = 1;
		}
		
		while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int node = tmp[0];
			int cnt = tmp[1];
			
			for(int i = 0; i < list[node].size(); i++) {
				int tmpNode = list[node].get(i);
				if(!visited[tmpNode]) {
					q.offer(new int[] {tmpNode, cnt + 1});
					visited[tmpNode] = true;
					cost[tmpNode] = Math.min(cost[tmpNode], cnt + 1);
				}
			}
		}
	}
	
	
	static public void dfs(List<Integer>[] list, boolean[] visited, int node, int cnt){        
        for(int i = 0; i < list[node].size(); i++){
            int tmpNode = list[node].get(i);
            if(tmpNode == 1) continue;
            if(!visited[tmpNode]){
                cost[tmpNode] = Math.min(cnt, cost[tmpNode]);
                System.out.println(Arrays.toString(cost));
                visited[tmpNode] = true;
                dfs(list, visited, tmpNode, cnt + 1);
                visited[tmpNode] = false;
            }
        }       
    }

}
