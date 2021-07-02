// 떡 만들기
// 내풀이
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
		// 이 방식 대로 할경우, 높이의 최대값이 나오지 않는다. 따라서 수정해야한다.
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

// 답지
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int[] arr;
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = 0;
        int end = 0;
        int result = 0;
        
        arr = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        	if(end < arr[i]) {
        		end = arr[i];
        	}
        }
        
        while(start <= end) {
        	int total = 0;
        	int mid = (start + end) / 2;
        	
        	for(int i = 0; i < n; i++) {
        		if(arr[i] > mid) total += arr[i] - mid;
        	}
        	
        	if(total < m) {
        		end = mid - 1;
        	}
        	else {
        		result = mid;
        		start = mid + 1;
        	}
        }
        
        System.out.println(result);
        
	}
}
