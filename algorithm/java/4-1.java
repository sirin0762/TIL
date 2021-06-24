import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
    sc.nextLine();
    String[] plans = sc.nextLine().split(" ");
    int x = 1, y = 1;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    char[] moveTypes = {'L', 'R', 'U', 'D'};

    for(String plan : plans){
      char move = plan.charAt(0);

      int nx = 0, ny = 0;

      // 좌표 구하기
      for(int j = 0; j < 4; j++){
        if(move == moveTypes[j]){
          nx = x + dx[j];
          ny = y + dy[j];
        }
      }

      // 검증
      if(nx < 1 || nx > n || ny < 1 || ny > n) continue;

      x = nx;
      y = ny;
    }
    System.out.println(x + " " + y);
  }
}
