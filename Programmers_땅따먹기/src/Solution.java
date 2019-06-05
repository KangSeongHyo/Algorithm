import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp= new int[n+1][4];
        /***************************
		 * DP를 활용하여 거꾸로 임의의 점이
		 * 최대값이 될 수 있는 경우를 생각한다.
		 ***************************/ 
        for(int i = n-1; i >= 0; i--) {
        	 for(int j = 0; j < 4; j++) {
        		 int max = 0;
        		 for(int u = 0; u < 4; u++) {
        			 if(j!=u) max = Math.max(dp[i+1][u], max);
        		 }
        		 dp[i][j] = max+land[i][j]; 
        		 // (i,j)를 선택했을때 최대치
        	}
        }
        int max = Arrays.stream(dp[0]).max().getAsInt();
        return max;
    }
}