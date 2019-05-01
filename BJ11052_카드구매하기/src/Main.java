import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] card = new int[n+1];
		int[] dp = new int[n+1];
		/**********************************************************************
		 * DP를 이용해 최대치를 구한다.
		 * 
		 * ex) 사야할 개수가 N = 4
		 *     dp[i]는 i개에 대한 최대값을 뜻함
		 *     dp[1]는 1개짜리 즉 첫번째 값만 가능
		 *     dp[2]는 1개짜리*2 or 2개짜리*1 중 최댓값 
		 *     dp[3]는 1개짜리*3 or 1개짜리*1 + 2개짜리*1 or 3개짜리*1 중 최댓값
		 *     
		 *     반복문에서 j 위의 or에 대한 처리를 담당한다.
		 *      
		 *     dp[3] => dp[2] + arr[1] 2+1 = 3개(1*2가 될지 2*1이 되는지는 이전에 처리됨)
		 *    			dp[1] + arr[2] 1+2 = 3개
		 *    			dp[0] + arr[3] 0+3 = 3개
		 *     
		 *     i의 인덱스는 개수를 의미하는 것이므로 이를 이용해 처리한다.
		 **********************************************************************/
		for(int i = 0; i < n; i++) {
			card[i+1] = sc.nextInt();
		}
		dp[0] = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+card[j]);
			}
		}
		System.out.println(dp[n]);
	}
}
