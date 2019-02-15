import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		/******************************
         * Memorization을 활용하여 DP로
         * 가장 작은 동전부터 경우의 수를 모두 구한다.
         * 지금 동전을 사용하고 남은 액수에 대한
         * 경우가 이미 Memorization 되있기 때문에
         * 누적해서 최종 k까지의 경우의 수를 구할 수 있다.
         *******************************/
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 1;
		AtomicInteger atom = new AtomicInteger(0);
		IntStream.of(coin)
				.flatMap(i->IntStream.rangeClosed(0, k)
									 .filter(j->{atom.set(i); return (j-i)>=0;}))
				.forEach(res->dp[res]+=dp[res-atom.get()]);
		System.out.println(dp[k]);
	}
}
