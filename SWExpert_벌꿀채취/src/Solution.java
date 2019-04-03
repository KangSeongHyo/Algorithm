import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int n,m,c;
	static int[][] honey;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			/******************************
	         * 재귀를 이용해 각라인의 최대치를 구하고
	         * 정렬을 통해 가장 이득이 높은 두라인의
	         * 합을 구한다.
	         *******************************/
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			honey = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					honey[i][j] = sc.nextInt();
				}
			}
			res = new int[n];
			selectLine();
			Arrays.sort(res);
			System.out.println("#"+t+" "+(res[n-1]+res[n-2]));
			
		}
	}
	
	static boolean[] visited;
	static int max;
	public static void scv(int start, int benefit,int size,int deep,int[] line) {
		if(size > c) return;
		max = Math.max(benefit, max);
		if(deep == m) return;
		
		
		for(int i = start; i < start+m; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int h = line[i];
				scv(start, benefit+(h*h), size+h, deep+1, line);
				visited[i] = false;
			}
		}
		
	}
	static int[] res;
	private static void selectLine() {
			for(int i = 0; i < n; i++) {
				for(int u = 0; u <= n-m;u++) {
					max = 0; 
					visited = new boolean[n];
					scv(u, 0, 0, 0, honey[i].clone());
					res[i] = Math.max(res[i],max);
				}
			}
	}
	
}
