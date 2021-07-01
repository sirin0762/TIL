// 다중조건 정렬

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Score implements Comparable<Score>{
	
	private String name;
	private int k, e, m;
	
	Score(String name, int k, int e, int m){
		this.name = name;
		this.k = k;
		this.e = e;
		this.m = m;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public int compareTo(Score other) {
		if(this.k == other.k && this.e == other.e && this.m == other.m){
			return this.name.compareTo(other.name);
		}
		if(this.k == other.k && this.e == other.e){
			return Integer.compare(other.m, this.m);
		}
		if(this.k == other.k) {
			return Integer.compare(this.e, other.e);
		}
		return Integer.compare(other.k, this.k);
	}
}

public class Main {
	
	public static void main(String[] args) {
		// Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<Score> scores = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String name = sc.next();
			int k = sc.nextInt();
			int e = sc.nextInt();
			int m = sc.nextInt();
			scores.add(new Score(name, k, e, m));
		}
		
		Collections.sort(scores);
		
		for(int i = 0; i < n; i++) {
			System.out.println(scores.get(i).getName());
		}
    }
	
}
