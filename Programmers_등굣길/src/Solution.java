import java.util.stream.IntStream;

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+2][n+2];
        int[][] temp = new int[m+2][n+2];
        
        
        /******************************
         *    
         * 맨왼쪽 꼭지점에서 맨아래 꼭지점까지
         * 최단경로를 구하는 방법중에 
         * 옆에서 오는 경로와 아래로 오는 경로를 
         * 더하는 방법이 있다.
         *  ex)  
         *      1 ▷  1
         *      ▽       ▽
         *      1 ▷  2
         *
         * 이를 활용해서 접근할때
         * 주의할 점은 1,1을 바로 1로 설정하는 것이 아닌
         * 1,0 이나 0,1이 1을 1로 설정해야 한다.
         * 
         *******************************/
        
        
        IntStream
        .range(0, puddles.length)
        .forEach(i->temp[puddles[i][0]][puddles[i][1]]=-1);
        
        dp[0][1] = 1; // 시작점
        
        for(int i = 1; i <= m ; i++) {
         	for(int j = 1; j <= n; j++) {
        		if(temp[i][j] == -1) { 
        			dp[i][j] = 0;
        		}else {
        			dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
        		}
        	}
        }
        
        answer = dp[m][n];
        
        return answer;
    }
}
