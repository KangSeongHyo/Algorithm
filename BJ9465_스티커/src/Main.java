import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			int n = sc.nextInt();
			/************************
			 * DP를 이용해 경로에 대한 최대치를
			 * 구한다.
			 ************************/
			int[][] map = new int[2][n];
			int[][] dp = new int[2][n];
			for(int i = 0; i < 2; i++) {
				for(int j =0; j< n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			dp[0][0] = map[0][0];
			dp[1][0] = map[1][0];
			if(n==1) {
				System.out.println(Math.max(dp[0][0], dp[1][0]));
				return;
			}
			dp[0][1] = map[0][1] + map[1][0];
			dp[1][1] = map[0][0] + map[1][1];
			
			for(int i = 2; i < n; i++) {
				dp[0][i] = Math.max(dp[1][i-2],Math.max(dp[1][i-1], dp[0][i-2]))+map[0][i]; 
				dp[1][i] = Math.max(dp[0][i-2], Math.max(dp[0][i-1], dp[1][i-2]))+map[1][i];
				// 두경우 모두 길이 1 대각선에서 오는 경우, 길이 2 대각선에서  오는경우, 길이 2 직선으로 오는경우
				// 대한 최댓값을 구하고 누적하면 된다.
			}
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}
	}
}
