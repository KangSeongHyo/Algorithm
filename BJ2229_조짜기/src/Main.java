import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		/***************************
		 * ���߹ݺ��� ���� ó������ �ݺ��ϰ�
		 * �ٸ� �ݺ��� ���� �ݺ��� �μ���
		 * �������� ��Ƽ� �ݴ�� �ݺ��Ѵ�.
		 * �̋� DP�� �̿��Ͽ� ���� �����ϰ�
		 * �ִ����� �Ǵ��Ͽ� ���� �����Ѵ�.
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
