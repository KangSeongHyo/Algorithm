import java.util.stream.IntStream;

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+2][n+2];
        int[][] temp = new int[m+2][n+2];
        
        
        /******************************
         *    
         * �ǿ��� ���������� �ǾƷ� ����������
         * �ִܰ�θ� ���ϴ� ����߿� 
         * ������ ���� ��ο� �Ʒ��� ���� ��θ� 
         * ���ϴ� ����� �ִ�.
         *  ex)  
         *      1 ��  1
         *      ��       ��
         *      1 ��  2
         *
         * �̸� Ȱ���ؼ� �����Ҷ�
         * ������ ���� 1,1�� �ٷ� 1�� �����ϴ� ���� �ƴ�
         * 1,0 �̳� 0,1�� 1�� 1�� �����ؾ� �Ѵ�.
         * 
         *******************************/
        
        
        IntStream
        .range(0, puddles.length)
        .forEach(i->temp[puddles[i][0]][puddles[i][1]]=-1);
        
        dp[0][1] = 1; // ������
        
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
