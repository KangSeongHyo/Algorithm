import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
	static int not = 0;
	public int solution(int n, int[] lost, int[] reserve) {
	     int[] clothes = new int[n];
	    /******************************
	     * ���� �ʵ� ���� ������� �÷��ְ�
	     * ���� ���� ���� ��츦 ã�Ƽ�
	     * 	1. �� �Ǵ� �� 2��
	     * 	2. �� �� ��� 2��
	     * �� ��찡 �߻��ϸ� ��� ���� �÷��ְ�
	     * ���� ����� ���� �ٿ��ش�.
	     * �̶� ���� ����� 2�� �����ϰ� ���ִ� ������
	     * ���� ���� ����� 2�� �̻��̱� ������
	     * �ִ� ����̶� �����ϰ� ���־ �����ϴ�.
	     * ����� ��ü - ���� ����� �ϸ� �ȴ�.
         *******************************/
	     
	     Arrays.fill(clothes, 1);
	     IntStream.of(reserve).forEach(i->clothes[i-1]++);
	     IntStream.of(lost).forEach(i->{clothes[i-1]--; if(clothes[i-1]==0)not++;});
	     
	     IntStream.range(1, n-1).filter(i->clothes[i]==0).forEach(i->{
	    	 if(clothes[i-1] == 2) {
	    		 clothes[i]++;
	    		 clothes[i-1]--; 
	    		 not--;
	    	 }else if(clothes[i+1] == 2) {
	    		 clothes[i]++;
	    		 clothes[i+1]--;
	    		 not--;
	    	 }
	    	 
	     });
	     
	     return n - not;
	 }
}

