import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
	static int not = 0;
	public int solution(int n, int[] lost, int[] reserve) {
	     int[] clothes = new int[n];
	    /******************************
	     * 여벌 옷도 없는 사람들을 늘려주고
	     * 여벌 옷이 없는 경우를 찾아서
	     * 	1. 앞 또는 뒤 2벌
	     * 	2. 앞 뒤 모두 2벌
	     * 의 경우가 발생하면 모두 옷을 늘려주고
	     * 없는 사람의 수를 줄여준다.
	     * 이때 같은 사람을 2벌 가능하게 해주는 이유는
	     * 도난 당한 사람이 2명 이상이기 때문에
	     * 있는 사람이라 생각하고 해주어도 무방하다.
	     * 결과는 전체 - 없는 사람을 하면 된다.
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

