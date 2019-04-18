import java.util.Arrays;

public class Solution {
	
	 public int solution(int[] weight) {
		 Arrays.sort(weight);
	    int accum = 1;
	    for(int i = 1; i < weight.length; i++) {
	    	if(accum+1 < weight[i]) break;
	    	else accum += weight[i];
	    }
	    return accum+1;
	 }
}
