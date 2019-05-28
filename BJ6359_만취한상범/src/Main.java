import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		/***************************
		 * i*j는 i의 배수가 되는 규칙을
		 * 이용하여 모든 경우에 대해
		 * 방이 열고 닫히는 것을 판단한다.
		 * 즉 마지막 라운드에 결과가 누적된다. 
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
