// bfs 전형적인 문제

import java.util.*;

class Node {
    int x;
    int y;
    
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1 , 0};
    public static int[] dy = {0, 1, 0 , -1};
    public static int answer;
    public static int n, m;
    
    public static void bfs(int x, int y, int[][] graph){
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Node(x, y));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            x = now.x;
            y = now.y;
            
            for(int i = 0; i < 4; i++){ 
                int nx = x + dx[i];
                int ny = y + dy[i];
            
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
            
                if(!visited[nx][ny] && graph[nx][ny] == 1){
                    graph[nx][ny] = graph[x][y] + 1;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        bfs(0, 0, maps);
        return maps[n - 1][m - 1] != 1 ? maps[n - 1][m - 1] : -1;
    }
}
