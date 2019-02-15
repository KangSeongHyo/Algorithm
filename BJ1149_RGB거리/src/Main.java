import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/******************************
         * DP를 이용해서 다음선택을 통해 이전선택을
         * 결정하는 방법을 활용하여 다음선택을 결정하고 
         * 이전선택은 다음선택을 뺸 두개의 최솟값이
         * 된다.
         *******************************/
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		IntStream
			.range(1, n)
			.forEach(i->{
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			});
		
		
		int min = Stream
					.of(dp[n-1][0],dp[n-1][1],dp[n-1][2])
					.mapToInt(i->i)
					.min()
					.getAsInt();
		
		System.out.println(min);
	}
}
