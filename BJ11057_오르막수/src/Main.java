import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mod = 10_007;
		/************************
		 * DP를 이용해 해당 길이에 합한
		 * 결과값을 저장하여 그 다음
		 * 값을 도출한다.
		 ************************/
		long[][] dp = new long[n+1][10];
		Arrays.fill(dp[1], 1);
		int start = 2;
		while (start <= n) {
			for(int i = 0; i < 10; i++) {
				for(int j = i; j < 10; j++) {
					dp[start][i] += dp[start-1][j]%mod;
				}
			}
			start++;
		}
		long ans = Arrays.stream(dp[n]).sum();
		System.out.println(ans%mod);
	}
}
