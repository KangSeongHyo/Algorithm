import java.util.stream.IntStream;

public class Solution {
	public int solution(int[] budgets, int M) {
        int sum = IntStream.of(budgets).sum();
        int max =  IntStream.of(budgets).max().getAsInt();
        /******************************
	     * �̺�Ž���� Ȱ���Ͽ� �Ҵ翹�� �̻� ������ 
	     * ���� ��� �ִ��� �������� ���Ѽ��� ����
	     * ���� ������ 1�� �ִ��� �̿��ؼ�
	     * ��� �񱳸� ���� �Ҵ� ������ ����ϴ�
	     * �ִ�ġ���� ���� �� �ִ�.
         *******************************/
        if(sum <= M) return max;
        search(1, max, budgets, M);
        return res;
    }
	static int res = Integer.MIN_VALUE;
	public void search(int start, int end,int[] budgets,int M) {
		
		if(start >= end) {
			return;
		}
		
		int mid = (start + end)/2;
		int sum = 0;
		for(int i = 0; i < budgets.length; i++) {
			sum += budgets[i] > mid ? mid:budgets[i];
		}
		
		if(sum <= M) {
			res = Math.max(mid, res);
			search(mid+1, end, budgets, M);
		}else {
			search(start, mid, budgets, M);
		}
		
	}
}
