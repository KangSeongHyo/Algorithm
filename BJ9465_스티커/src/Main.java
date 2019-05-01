import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			int n = sc.nextInt();
			/************************
			 * DP�� �̿��� ��ο� ���� �ִ�ġ��
			 * ���Ѵ�.
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
				// �ΰ�� ��� ���� 1 �밢������ ���� ���, ���� 2 �밢������  ���°��, ���� 2 �������� ���°��
				// ���� �ִ��� ���ϰ� �����ϸ� �ȴ�.
			}
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}
	}
}
