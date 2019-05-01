import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] card = new int[n+1];
		int[] dp = new int[n+1];
		/**********************************************************************
		 * DP�� �̿��� �ִ�ġ�� ���Ѵ�.
		 * 
		 * ex) ����� ������ N = 4
		 *     dp[i]�� i���� ���� �ִ밪�� ����
		 *     dp[1]�� 1��¥�� �� ù��° ���� ����
		 *     dp[2]�� 1��¥��*2 or 2��¥��*1 �� �ִ� 
		 *     dp[3]�� 1��¥��*3 or 1��¥��*1 + 2��¥��*1 or 3��¥��*1 �� �ִ�
		 *     
		 *     �ݺ������� j ���� or�� ���� ó���� ����Ѵ�.
		 *      
		 *     dp[3] => dp[2] + arr[1] 2+1 = 3��(1*2�� ���� 2*1�� �Ǵ����� ������ ó����)
		 *    			dp[1] + arr[2] 1+2 = 3��
		 *    			dp[0] + arr[3] 0+3 = 3��
		 *     
		 *     i�� �ε����� ������ �ǹ��ϴ� ���̹Ƿ� �̸� �̿��� ó���Ѵ�.
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
