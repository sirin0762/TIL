import java.util.Scanner;
import java.util.Arrays;

public class Main {

  public static int direction;

  public static void turn_left(){
    direction = (direction + 3) % 4;
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] dx = {-1, 0, 1, -1};
    int[] dy = {0, 1, 0, -1};

    int x = sc.nextInt();
    int y = sc.nextInt();
    direction = sc.nextInt();

    int[][] map = new int[n][m];
    int[][] d = new int[n][m];
    // 현재 좌표 방문 처리
    d[x][y] = 1;

    // 맵 입력
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        map[i][j] = sc.nextInt();
        System.out.println("hi");
      }
    }
    
    int count = 1;
    int turn_time = 0;
    while(true){
      turn_left();
      int nx = x + dx[direction];
      int ny = y + dy[direction];

      if(nx >= 0 && nx < n && ny >= 0 && ny < n){
        if(d[nx][ny] == 0 && map[nx][ny] == 0){
          d[nx][ny] = 1;
          turn_time = 0;
          x = nx; 
          y = ny;
          count += 1;
          continue;
        }
        else{
          turn_time += 1;
        }

        if(turn_time == 4){
          nx = x - dx[direction];
          ny = y - dy[direction];

          if(map[nx][ny] == 0){
            x = nx; 
            y = ny;
          }
          else break;
        }
      }
    }

    System.out.println(count);
  }
}
