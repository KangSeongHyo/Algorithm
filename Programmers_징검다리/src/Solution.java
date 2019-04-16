import java.util.Arrays;

public class Solution {
	 public int solution(int distance, int[] rocks, int n) {
	    Arrays.sort(rocks);
	    int start = 0;
	    int end = distance;
	    /******************************
         * �̺�Ž���� Ȱ���Ͽ� ������ �ִ��� 
         * distance�� �������� �����Ѵ�. 
         * �̶� ���δ� �߰����� ��ǥ�� ũ��񱳸�
         * ���ؼ� �� �߰����� �ش��ϴ� �� ����
         * �ּڰ��� ���� �� �ִ����� �Ǵ��Ͽ�
         * 
         *******************************/
	    while (start < end) {
			int rm = 0;
	    	int mid = (start+end+1)/2;
	    	int current = 0;
	    	for(int i = 0; i < rocks.length;i++) {
	    		if(rocks[i] - current < mid) 
	    			rm++; // ���̰��� ���ذ����� ������
	    				  // ������ �����ؾ���
	    		else 
	    			current = rocks[i];
	    	}
	    	if(rm > n) end = mid -1;
	    	// ���� ������ ���ٴ� ���� �� �����ϰ� ���������Ƿ�
	    	// ���� ������ ���� ���� Ž���ؾ� �Ѵ�.
	    	else start = mid;
		}
	    
	    return start;
	 }
}
