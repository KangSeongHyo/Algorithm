import java.util.Arrays;

public class Solution {
	 public int solution(int distance, int[] rocks, int n) {
	    Arrays.sort(rocks);
	    int start = 0;
	    int end = distance;
	    /******************************
         * 이분탐색을 활용하여 사이의 최댓값인 
         * distance를 기준으로 분할한다. 
         * 이때 내부는 중간값을 목표로 크기비교를
         * 통해서 이 중간값에 해당하는 돌 사이
         * 최솟값을 구할 수 있는지를 판단하여
         * 
         *******************************/
	    while (start < end) {
			int rm = 0;
	    	int mid = (start+end+1)/2;
	    	int current = 0;
	    	for(int i = 0; i < rocks.length;i++) {
	    		if(rocks[i] - current < mid) 
	    			rm++; // 사이값이 기준값보다 작을시
	    				  // 바위를 제거해야함
	    		else 
	    			current = rocks[i];
	    	}
	    	if(rm > n) end = mid -1;
	    	// 지울 바위가 많다는 것은 더 촘촘하게 놓여있으므로
	    	// 기준 값보다 작은 값을 탐색해야 한다.
	    	else start = mid;
		}
	    
	    return start;
	 }
}
