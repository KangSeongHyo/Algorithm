import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		/***************************
		 * 이중반복을 통해 처음부터 반복하고
		 * 다른 반복은 앞의 반복의 인수를
		 * 기준으로 삼아서 반대로 반복한다.
		 * 이떄 DP를 이용하여 값을 누적하고
		 * 최댓값인지 판단하여 값을 변경한다.
		 ***************************/
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int j = i; j > 0; j--) {
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				dp[i] = Math.max(dp[i], dp[j-1]+(max-min));
			}
		}
		
		System.out.println(dp[n]);
	}
}
