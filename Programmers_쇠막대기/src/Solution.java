import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {
	  public int solution(String arrangement) {
	        Stack<Character> stack = new Stack<>();
	        int[] res = new int[1];
	        char[] prev = new char[1];
	        /******************************
	         * (�� ����  ()�� ���� ������ �������̴�.
	         * ()�� �������� �տ� �߸� ������ ���� 
	         * (�� ������ �ȴ�. �̶� �������� ������
	         * �϶��� �տ� �������� �ڸ� ������ ����.
	         * �������� �������� �ڿ� �߸� ���ڼ���
	         * )�� ������ ����. �׷��Ƿ� )���Ë�
	         * pop�� ���ְ� �������� ������ ������ ���ϰ�
	         * ���ڸ� +1 �� ó���� �ָ� �ȴ�. 
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
