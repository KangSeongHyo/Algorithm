import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Solution {
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        /******************************
         * 단순 문제해결, 배열을 자르고 
         * map으로 변환 후 정렬하고
         * k번째를 찾으면 된다.
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
