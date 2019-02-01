import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {
	
	
	 public int solution(int[] scoville, int K) {
	        
	        Arrays.sort(scoville);
	        /******************************
	         * �켱���� ť�� Ȱ���Ͽ� ��� ���� ������ �߰��ص�
	         * ���������� ������ �� �ְ� �����.
	         * ���� ���ſ� �Ͱ� �ι�° ���ſ� ���� 
	         * �Ǿտ� 2�������� ���Ÿ� ���ְ� 
	         * ��� �ٽ� ť�� �־��ش�.
	         * �̶� ��� ������ K���� ���� ����
	         * Queue ������ �������� �Ǵ��ϸ� �ȴ�.
	         *******************************/
	        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.naturalOrder());
	        IntStream.of(scoville).forEach(i->priorityQueue.add(i));
	        
	        int count = 0;
	        
	        while(!priorityQueue.isEmpty()) {
	        	try {
	        		int nonspicyfst = priorityQueue.poll();
	        		if(nonspicyfst >= K ) break;
	        		
	        		count ++;
	        		
	        		int nonspicyscd = priorityQueue.poll();
	        		int newscoville = nonspicyfst + nonspicyscd*2;
	        		priorityQueue.add(newscoville);
	        	}catch (Exception e) {
	        		return -1;
				}
	        }
	        
	        return count;
	    }
}
