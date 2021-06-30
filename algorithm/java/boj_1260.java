// bfs와 dfs

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static int n, m, v;
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); 
	
	public static void dfs(int x) {
		visited[x] = true;
		System.out.print(x + " ");
		
		for(int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		visited[x] = true;
		q.offer(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");
			
			for(int i = 0; i < graph.get(now).size(); i++) {
				int y = graph.get(x).get(i);
				if(!visited[y]) {
					q.offer(y);
					visited[y] = true;
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
		v = sc.nextInt();
		
		for(int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		for(int i = 0; i < n; i++) {
			Collections.sort((graph.get(i)));
		}
		
		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();
		
		visited = new boolean[n + 1];
		bfs(v);
	}
}
