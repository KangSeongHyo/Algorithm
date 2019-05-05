import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		/************************
		 * DP를 이용해 이전 두개의
		 * 값이 현재값이 되는 피보나치를
		 * 이용하여 풀이한다.
		 ************************/
		long ans = Stream.iterate(new long[]{0,1},arr->new long[]{arr[1],arr[0]+arr[1]})
			  .limit(n+1)
			  .mapToLong(arr->arr[0])
			  .max().getAsLong();
		System.out.println(ans);
		
		long[][] dp = new long[n+1][2];
		dp[1][0] = 0; dp[1][1] = 1;
		if(n == 1) {
			System.out.println(1);
			return;
		}
		dp[2][0] = 1; dp[2][1] = 0;
		
		for(int i = 3; i <= n; i++) {
			dp[i][0] = dp[i-2][0]+dp[i-1][0];
			dp[i][1] = dp[i-2][1]+dp[i-1][1];
		}
		System.out.println(Arrays.stream(dp[n]).sum());	
	}
}
