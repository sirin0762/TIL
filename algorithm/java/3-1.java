import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int count = 0;
		
		int[] coins = {500, 100, 50, 10};
		
		for(int coin : coins) {
			count += (money / coin);
			money %= coin;
		}
		
		System.out.println(count);
	}

}
