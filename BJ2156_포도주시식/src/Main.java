import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wine = new int[n+1];
		int[] dp = new int[n+1];
		// �ش���ġ�� ���Ǽ� �ִ� �ִ�
		/************************
		 * DP�� �̿��� 3���� ��쿡 ����
		 * ��ȭ���� ������ �ִ�ġ�� ���Ѵ�.
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
		// 2��°��ġ��  ������ ���ô� �ִ��� �ΰ��� ���ô� �ͻ�
		for(int i = 3; i < n+1; i++) {
			// �ִ��� �ɼ��ִ� 3���� �ĺ��� 
			
			// 1. ���� ��ġ�� wine�� �ȸ��ô� ���(�ٷ���Ÿ���� �ִ�)
			int first = dp[i-1];
			// 2. ���� ��ġ�� wine�� ���ô� ��� 
			int second = dp[i-2]+wine[i];
			// 3. ���� ��ġ�� wine�� ���� ��ġ�� wine�� ���ǰ��
			int third = dp[i-3]+wine[i-1]+wine[i];
			
			// 3��������� �ִ�
			dp[i] = Math.max(third, Math.max(first, second));
		}
		System.out.println(dp[n]);
	}
}
