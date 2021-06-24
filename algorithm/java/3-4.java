// 내 풀이
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		while(n > 1) {
			if(n % k == 0) {
				n /= k;
			}
			else {
				n -= 1;
			}
			result += 1;
		}
		System.out.println(result);
		
		sc.close();
	}

}
// -----------------------------------
// 답안
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		while(true) {
      int target = (n / k) * k;
      result += n - target;

      // 나누기
      n = target;

      if(n < k){
        break;
      }
      n /= k;
      result += 1;
    }

    result += (n - 1);

    System.out.println(result);
	}

}

