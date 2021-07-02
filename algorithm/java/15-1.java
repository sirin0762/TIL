import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[] arr;
	public static int n, x;
	
	public static int first(int[] arr, int target, int start, int end) {
		if(start > end) return -1;
		int mid = (start + end) / 2;
		
		if((mid == 0 || arr[mid - 1] < target) && target == arr[mid]) {
			return mid;
		}
		else if(arr[mid] >= target) {
			return first(arr, target, start, mid - 1);
		}
		else {
			return first(arr, target, mid + 1, end);
		}
	}
	
	public static int last(int[] arr, int target, int start, int end) {
		if(start > end) return -1;
		int mid = (start + end) / 2;
		
		if((mid == n - 1 || arr[mid + 1] > target) && target == arr[mid]) {
			return mid;
		}
		else if(arr[mid] > target) {
			return last(arr, target, start, mid - 1);
		}
		else {
			return last(arr, target, mid + 1, end);
		} 
	}
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        x = sc.nextInt();
        
        arr = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        }
        
        System.out.println(last(arr, x, 0, n - 1) - first(arr, x, 0, n - 1) + 1);
        
	}
}
