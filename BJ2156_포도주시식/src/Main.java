import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wine = new int[n+1];
		int[] dp = new int[n+1];
		// 해당위치의 마실수 있는 최댓값
		/************************
		 * DP를 이용해 3가지 경우에 대한
		 * 점화식을 세워서 최대치를 구한다.
		 ************************/
		for(int i = 1; i < n+1; i++) {
			wine[i] = sc.nextInt();
		}
		if(n==1) {
			System.out.println(wine[1]);
			return;
		}
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];
		// 2번째위치에  있을때 마시는 최댓값은 두개다 마시는 것뿐
		for(int i = 3; i < n+1; i++) {
			// 최댓값이 될수있는 3개의 후보군 
			
			// 1. 현재 위치의 wine을 안마시는 경우(바로전타임이 최댓값)
			int first = dp[i-1];
			// 2. 현재 위치의 wine을 마시는 경우 
			int second = dp[i-2]+wine[i];
			// 3. 현재 위치와 wine과 이전 위치의 wine을 마실경우
			int third = dp[i-3]+wine[i-1]+wine[i];
			
			// 3가지경우중 최댓값
			dp[i] = Math.max(third, Math.max(first, second));
		}
		System.out.println(dp[n]);
	}
}
