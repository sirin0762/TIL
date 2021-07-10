// 데이크스트라로 해결
import java.util.*;

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main {

  public static final int INF = (int)1e9;

  public static int[][] graph;
  public static int[] distance;
  public static int n;

  public static void djikstra(int start){
    PriorityQueue<Node> pq = new PriorityQueue<>();
    distance[start] = 0;
    pq.offer(new Node(start, 0));

    while(!pq.isEmpty()){
      Node node = pq.poll();
      int now = node.getIndex();
      int dist = node.getDistance();

      if(distance[now] < dist)  continue;

      for(int i = 1; i <= n; i++){     
        if(graph[now][i] == 0) continue;
        int cost = graph[now][i] + distance[now];
        if(distance[i] > cost){
          distance[i] = cost;
          pq.offer(new Node(i, cost));
        }
      }
    }
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    
    n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int x = sc.nextInt();

    graph = new int[n + 1][n + 1];
    distance = new int[n + 1];
    Arrays.fill(distance, INF);

    for(int i = 0; i < m; i++){
      int start = sc.nextInt();
      int end = sc.nextInt();
      graph[start][end] = 1;
    }

    djikstra(x);

    System.out.println(Arrays.toString(distance));
  }
}
