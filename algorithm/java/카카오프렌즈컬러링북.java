// bfs를 이용

import java.util.*;

class Node {
    int x;
    int y;
    
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    int getX(){
        return this.x;
    }
    
    int getY(){
        return this.y;
    }
}

class Solution {
    
    public static int numberOfArea;;
    public static int maxSizeOfOneArea;;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static int bfs(int x, int y, long[][] picture, int m, int n){
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Node(x, y));
        int sizeOfOneArea = 1;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            x = now.getX();
            y = now.getY();
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= m || ny < 0 || ny >= n){
                    continue;
                }
                
                if(!visited[nx][ny] && picture[x][y] == picture[nx][ny]){
                    sizeOfOneArea += 1;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return sizeOfOneArea;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        long[][] clonePicture = new long[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                clonePicture[i][j] = (long)picture[i][j];
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && clonePicture[i][j] != 0){
                    numberOfArea += 1;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, clonePicture, m, n));
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}
