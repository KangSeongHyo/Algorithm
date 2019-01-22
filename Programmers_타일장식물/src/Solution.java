import java.util.stream.IntStream;

public class Solution {

	long[] dp = new long[10001];
	public long solution(int N) {
        
        dp[0] = 1;
        dp[1] = 1;
        
        
        /*********
         * �Ǻ���ġ��(���� �ΰ� ���� ���� ������ ��)
         * ���簢�� �ѷ����̴� ���������簢���� �Ѻ��Ǳ��� *2 �� ������ �Ѻ��Ǳ��� *  
         * *******/
        IntStream.range(2, N+1)
        		.forEach(i -> {
        			dp[i] = dp[i-1] + dp[i-2];
        		});
        
        return dp[N]*2 + dp[N-1]*2;
    }
	
}
