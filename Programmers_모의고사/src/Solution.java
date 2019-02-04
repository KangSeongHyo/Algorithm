import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
	  static int[] ans_peo = new int [3];
	  public int[] solution(int[] answers) {
	        int[][] people = {
					{},
					{1, 2, 3, 4, 5},
					{2, 1, 2, 3, 2, 4, 2, 5},
					{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
													};
	        /******************************
	         * 문제답과 찍는 방식을 완전탐색으로
	         * 비교하여 최대치를 구하고 
	         * 최대치와 같은 사람을 출력한다
	         *******************************/
	        
	        IntStream.range(0, answers.length)
	        		 .forEach(i->{
	        			 if(answers[i] == people[1][i%5]) {
	        				 ans_peo[0]++;
	        			 }
	        			 if(answers[i] == people[2][i%8]) {
	        				 ans_peo[1]++;
	        			 }
	        			 if(answers[i] == people[3][i%10]) {
	        				 ans_peo[2]++;
	        			 }
	        		 });
	         
	        List<Integer> list = new LinkedList<>();
	    	int max = IntStream.of(ans_peo).max().getAsInt();
	    	
	        IntStream.range(0, 3).filter(i->ans_peo[i]==max).forEach(i->list.add(i+1));
	    	   
	       return list.stream().mapToInt(i->i).toArray();
	    }
}
