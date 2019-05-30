import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		/***************************
		 * partSum과 DP를 이용하여 
		 * 구간의 최솟값을 구한다.
		 ***************************/
		for(int t = 0; t < test; t++) {
			int n = sc.nextInt();
			int[] CDpartSum = new int[n];
			int[][] dp = new int[n][n];
			int accu = 0;
			for(int i = 0; i < n; i++) {
				accu += sc.nextInt();
				CDpartSum[i] = accu;
			}
			for(int i = 1; i < n ; i++) {
				for(int j = i-1; j >= 0; j--) {
					dp[j][i] = Integer.MAX_VALUE;
					for(int k = j; k < i; k++) {
						dp[j][i] = Math.min(dp[j][i],dp[j][k]+dp[k+1][i]); 
					}
					if(j-1>=0)
						dp[j][i] += (CDpartSum[i] - CDpartSum[j-1]);
					else
						dp[j][i] += CDpartSum[i];
				}
			}
			System.out.println(dp[0][n-1]);
		}
	}
}
