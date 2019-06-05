
public class Solution {
		
	public int solution(int[][] board){
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        /***************************
		 * DP�� Ȱ���Ͽ� ������ ���� ��������
		 * ����,����,�밢�� �������� ������
		 * ���簢���� �ִ밪�� �����Ѵ�.
		 ***************************/
        for(int i = 1; i < n+1; i++) {
        	for(int j = 1; j < m+1; j++) {
        		if(board[i-1][j-1] == 1) {
        			dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
        			// +1�� �ش� ������ ũ�⸦ ����Ų��.
        			max = Math.max(dp[i][j], max);
        		}
        	}
        }
        return max*max;
    }
	
}
