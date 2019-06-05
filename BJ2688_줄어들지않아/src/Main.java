import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[][] dp = new long[66][10];
		for(int i = 1; i < 10; i++) {
			dp[1][i] = i;
		}
		/***************************
		 * DP�� �̿��� �������� ������ 
		 * �پ��鼭 �����Ǵ� ��Ģ��
		 * �����Ͽ� ���� ����Ѵ�.
		 ***************************/
		for(int u = 2; u <= 65; u++) {
			for(int i = 1; i < 10; i++) {
				for(int j = 1; j <= i; j++) {
					dp[u][i] +=dp[u-1][j];
				}
			}
		}
		int n = sc.nextInt();
		while(n-->0) {
			int k = sc.nextInt();
			long res = 10;
			if(k == 1) {
				System.out.println(res);
				continue;
			}
			for(int i = 2; i <= k; i++) {
				res += Arrays.stream(dp[i-1]).sum();
			}
			System.out.println(res);
		}
		
	}
}
