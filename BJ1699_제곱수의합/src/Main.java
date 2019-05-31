import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		/***************************
		 * DP를 이용하여 이전 항 개수와
		 * 현재 가능한 개수 중 최소값으로
		 * 선택하여 누적한다. 
		 ***************************/
		dp[0] = 1;
		for(int i = 1; i <= n; i++)
			dp[i] = i;
		
		for(int i = 2; i*i <= n; i++) {
			for(int j = i*i; j <= n; j++) {
				if(j-i*i == 0) {
					dp[j] = dp[0];
				}else {
					dp[j] = Math.min(dp[j-i*i]+1, dp[j]);
				}
			}
		}
		System.out.println(dp[n]);
	}
}
