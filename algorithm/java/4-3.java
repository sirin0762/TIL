import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    String pos = sc.nextLine();
    int y = pos.charAt(0) - 'a';
    int x = pos.charAt(1) - '1';
    int result = 0;

    int[][] steps = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
    for(int i = 0; i < 8; i++){
      int nx = x + steps[i][0];
      int ny = y + steps[i][1];

      if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue;
      result += 1;
    }

    System.out.println(result);
  }
}
