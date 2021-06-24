// 내풀이
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int cnt = 0;

    for(int i = 0; i <= n; i++){
      for(int j = 0; j < 60; j++){
        for(int k = 0; k < 60; k++){
          if(String.valueOf(i).contains("3") || String.valueOf(j).contains("3") || String.valueOf(k).contains("3")) cnt++;
        }
      }
    }
    System.out.println(cnt);
  }
}

// 답 풀이
import java.util.Scanner;

public class Main {

  public static boolean check(int h, int m, int s){
    if(h % 10 == 3 || m % 10 == 3|| s % 10 == 3 || m / 10 == 3 || s / 10 == 3){
      return true;
    }
    return false;
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int cnt = 0;

    for(int i = 0; i <= n; i++){
      for(int j = 0; j < 60; j++){
        for(int k = 0; k < 60; k++){
          if(check(i, j, k)) cnt++;
        }
      }
    }
    System.out.println(cnt);
  }
}
