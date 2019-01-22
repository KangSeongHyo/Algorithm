import java.util.stream.IntStream;

public class Solution {

	long[] dp = new long[10001];
	public long solution(int N) {
        
        dp[0] = 1;
        dp[1] = 1;
        
        
        /*********
         * 피보나치형(이전 두개 더한 것이 다음번 값)
         * 직사각형 둘레길이는 마지막정사각형의 한변의길이 *2 그 이전의 한변의길이 *  
         * *******/
        IntStream.range(2, N+1)
        		.forEach(i -> {
        			dp[i] = dp[i-1] + dp[i-2];
        		});
        
        return dp[N]*2 + dp[N-1]*2;
    }
	
}
