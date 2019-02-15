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
         * Memorization�� Ȱ���Ͽ� DP��
         * ���� ���� �������� ����� ���� ��� ���Ѵ�.
         * ���� ������ ����ϰ� ���� �׼��� ����
         * ��찡 �̹� Memorization ���ֱ� ������
         * �����ؼ� ���� k������ ����� ���� ���� �� �ִ�.
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
