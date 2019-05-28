import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[n+1][m+1];
		/***************************
		 * DP�� Ȱ���Ͽ� i,j�� ���� �� �ִ�
		 * �ִ��� ��츦 ���Ѵ�. ��
		 * �밢������ �����ϴ� ���, ���ʿ���
		 * ���� ���, ������ ���� ��� ��
		 * ū ���� �����Ѵ�. 
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
