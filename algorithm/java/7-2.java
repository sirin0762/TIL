import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	// 이진 탐색 : 1 중간을 찾는다. 2 중간값과 타겟을 비교한다. 3. 맞으면 return 아니면 재귀
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		if(start > end) return -1;
		int mid = (start + end) / 2;
		
		if(arr[mid] == target) {
			return mid;
		}
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
        
        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기 
        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        System.out.println(binarySearch(arr, target, 0, n - 1) + 1);
    }
	
}
