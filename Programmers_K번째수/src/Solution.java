import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Solution {
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        /******************************
         * �ܼ� �����ذ�, �迭�� �ڸ��� 
         * map���� ��ȯ �� �����ϰ�
         * k��°�� ã���� �ȴ�.
         *******************************/
        for(int[] arr : commands) {
        	int i = arr[0];
        	int j = arr[1];
        	int k = arr[2];
        	
        	AtomicInteger atomicInteger = new AtomicInteger(0);
        	
        	answer[idx++]= IntStream.range(i-1, j).mapToObj(cnt->array[cnt])
							        			 .sorted().filter(in->atomicInteger.incrementAndGet()==k)
							        			 .findFirst()
							        			 .get();
        }
        
        return answer;
    }
}
