// 피보나치수열(재귀를 통한 탑 다운 방식)
public class Main {
	
	public static long[] d = new long[100];
	
	public static long fibo(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		
		if(d[n] != 0) {
			return d[n];
		}
		
		d[n] = fibo(n - 1) + fibo(n - 2);
		
		return d[n];
	}
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		System.out.println(fibo(50));    
	}
}
