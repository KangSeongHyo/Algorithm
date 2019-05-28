import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[n+1][m+1];
		/***************************
		 * DP를 활용하여 i,j로 들어올 수 있는
		 * 최대의 경우를 구한다. 즉
		 * 대각선으로 진입하는 경우, 왼쪽에서
		 * 오는 경우, 위에서 오는 경우 중
		 * 큰 값을 누적한다. 
		 ***************************/
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dp[i+1][j+1] = sc.nextInt();
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				dp[i][j] += Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
			}
		}
		System.out.println(dp[n][m]);
	}
}
