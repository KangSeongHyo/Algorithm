import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {
	
	
	 public int solution(int[] scoville, int K) {
	        
	        Arrays.sort(scoville);
	        /******************************
	         * 우선순위 큐를 활용하여 섞어서 나온 음식을 추가해도
	         * 오름차순을 유지할 수 있게 만든다.
	         * 가장 덜매운 것과 두번째 덜매운 것은 
	         * 맨앞에 2개임으로 제거를 해주고 
	         * 섞어서 다시 큐에 넣어준다.
	         * 이때 모든 음식이 K보다 작은 경우는
	         * Queue 음식이 없을때를 판단하면 된다.
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
