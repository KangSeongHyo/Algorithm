import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		/***************************
		 * i*j�� i�� ����� �Ǵ� ��Ģ��
		 * �̿��Ͽ� ��� ��쿡 ����
		 * ���� ���� ������ ���� �Ǵ��Ѵ�.
		 * �� ������ ���忡 ����� �����ȴ�. 
		 ***************************/
		for(int t = 0; t < test; t++) {
			int n = sc.nextInt();
			int[] dp = new int[n+1];
			Arrays.fill(dp, 1);
			for(int i = 2; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(i*j <=n)
						dp[i*j]*=-1;
				}
			}
			long count = Arrays.stream(dp).filter(i->i==1).count();
			System.out.println(count-1);
		}
	}
}
