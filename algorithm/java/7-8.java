// 떡 만들기
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[] arr;
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		int mid = (start + end) / 2;
		int cut = 0;
		
		if(start > end) return -1;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > mid) {
				cut += arr[i] - mid;	
			}
		}
		
		if(cut == target) {
			return mid;
		}
		else if(cut < target) {
			return binarySearch(arr, target, start, mid - 1);
		}
		else {
			return binarySearch(arr, target, mid + 1, end);
		}
	}
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int end = 0;
        
        arr = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        	if(end < arr[i]) {
        		end = arr[i];
        	}
        }
        
        int result = binarySearch(arr, m, 0, end);
        
        System.out.println(result);
        
	}
}
