// 부품 찾기
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static String binarySearch(int[] arr, int target, int start, int end) {
		if(start > end) return "No";
		int mid = (start + end) / 2;
		
		if(arr[mid] == target) return "Yes";
		else if(arr[mid] < target) {
			return binarySearch(arr, target, mid + 1, end);
		}
		else {
			return binarySearch(arr, target, start, end - 1);
		}

	}
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] part = new int[n];
        for(int i = 0; i < n; i++) {
        	part[i] = sc.nextInt();
        }
        Arrays.sort(part);
        
        int m = sc.nextInt();
        int[] order = new int[m];
        for(int i = 0; i < m; i++) {
        	order[i] = sc.nextInt();
        }
        
        for(int i = 0; i < m; i++) {
        	System.out.print(binarySearch(part, order[i], 0, n - 1) + " ");
        }
        
	}
}
