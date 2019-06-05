import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp= new int[n+1][4];
        /***************************
		 * DP�� Ȱ���Ͽ� �Ųٷ� ������ ����
		 * �ִ밪�� �� �� �ִ� ��츦 �����Ѵ�.
		 ***************************/ 
        for(int i = n-1; i >= 0; i--) {
        	 for(int j = 0; j < 4; j++) {
        		 int max = 0;
        		 for(int u = 0; u < 4; u++) {
        			 if(j!=u) max = Math.max(dp[i+1][u], max);
        		 }
        		 dp[i][j] = max+land[i][j]; 
        		 // (i,j)�� ���������� �ִ�ġ
        	}
        }
        int max = Arrays.stream(dp[0]).max().getAsInt();
        return max;
    }
}