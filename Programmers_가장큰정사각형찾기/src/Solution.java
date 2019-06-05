
public class Solution {
		
	public int solution(int[][] board){
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        /***************************
		 * DP를 활용하여 임의의 점을 기준으로
		 * 왼쪽,위쪽,대각선 방향으로 가능한
		 * 정사각형의 최대값을 저장한다.
		 ***************************/
        for(int i = 1; i < n+1; i++) {
        	for(int j = 1; j < m+1; j++) {
        		if(board[i-1][j-1] == 1) {
        			dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
        			// +1은 해당 지점의 크기를 가리킨다.
        			max = Math.max(dp[i][j], max);
        		}
        	}
        }
        return max*max;
    }
	
}
