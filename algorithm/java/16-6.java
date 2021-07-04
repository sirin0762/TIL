// 편집거리
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[][] arr;
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		int row = str1.length();
		int col = str2.length();
		
		arr = new int[row + 1][col + 1];
		
		for(int i = 1; i <= row; i++) {
			arr[i][0] = i;
		}
		
		for(int j = 1; j <= col; j++) {
			arr[0][j] = j;
		}
		
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				int minValue = Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1]));
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					arr[i][j] = minValue;
				}
				else {
					arr[i][j] = minValue + 1;
				}
			}
		}
		System.out.println(arr[row][col]);		
			
	}
}
