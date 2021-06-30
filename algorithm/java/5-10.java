// 음료수 빨리먹기
// bfs
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static int n, m;
	public static int cnt = 0;
	public static int[][] graph = new int[1000][1000];
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] start = {x, y};
		q.offer(start);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			x = now[0];
			y = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				
				if(graph[nx][ny] == 0) {
					graph[nx][ny] = 1;
					int[] node = {nx, ny};				
					q.offer(node);
				}
			}		
		}		
		
	}
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// 입력
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine(); // 버퍼 지우기
		
		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for(int j = 0; j < m; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0 ; j < m; j++) {
				if(graph[i][j] == 0) {
					cnt += 1;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
	}
}

// dfs
import java.util.Scanner;

public class Main {
	
	public static int n, m;
	public static int cnt = 0;
	public static int[][] graph = new int[1000][1000];
	
	public static boolean dfs(int x, int y) {
		if(x <= -1 || x >= n || y <= -1 || y >= m) {
			return false;
		}
		
		if(graph[x][y] == 0) {
			
			graph[x][y] = 1;
			
			dfs(x + 1, y);
			dfs(x, y + 1);
			dfs(x - 1, y);
			dfs(x, y - 1);
			return true;
		}
		
		return false;
		
	}
	
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// 입력
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine(); // 버퍼 지우기
		
		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for(int j = 0; j < m; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0 ; j < m; j++) {
				if(dfs(i, j)) {
					cnt += 1;
				}
			}
		}
		
		System.out.println(cnt);
	}
}

