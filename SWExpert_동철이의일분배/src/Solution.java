import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
	
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			double[][] arr = new double[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt()*0.01;
				}
			}
			visited = new boolean[N];
			max = -1;
			req(0, N, arr, 1);
			max = max*100;
			System.out.println("#"+t+" "+String.format("%.6f", max));
			
		}
		
	}
	static double max;
	public static void req(int deep,int N, double[][] arr , double total) {
		
		if( total <= max ) return;
		
		if(deep == N) {
			max = Math.max(max, total);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				req(deep+1, N, arr, total*arr[deep][i]);
				visited[i] = false;
			}
		}
		
	}
}
