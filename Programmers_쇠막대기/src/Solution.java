import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {
	  public int solution(String arrangement) {
	        Stack<Character> stack = new Stack<>();
	        int[] res = new int[1];
	        char[] prev = new char[1];
	        /******************************
	         * (는 판자  ()가 같이 들어오면 레이저이다.
	         * ()를 기점으로 앞에 잘린 판자의 수는 
	         * (의 갯수가 된다. 이때 레이저가 여러개
	         * 일때는 앞에 레이저가 자른 갯수와 같다.
	         * 레이저를 기점으로 뒤에 잘린 판자수는
	         * )의 갯수와 같다. 그러므로 )들어올떄
	         * pop을 해주고 레이저면 스택의 갯수를 더하고
	         * 판자면 +1 만 처리해 주면 된다. 
	         * 
	         * ex)
	         * 
	         * (  ( ( ) )  )  (   (  ( )  )	 ( )	)
	         *   --- | ---        --- | ---   |
	         * ----- | -----   ------ | ----- | ----
	         *******************************/
	        
	   IntStream
	   		.range(0, arrangement.length())
	   		.mapToObj(i->arrangement.charAt(i))
	   		.forEach(i->{
	   			if(i == ')') {
	   				stack.pop();
	   				 res[0] = prev[0] == '('? res[0]+stack.size() : res[0]+1;
	   			}else {
	   				stack.push(i);
	   			}
	   			prev[0] = i;
	   		});
	        	
	        return res[0];
	    }
}
