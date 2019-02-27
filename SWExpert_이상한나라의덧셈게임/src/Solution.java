import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/******************************
         * Stack를 이용해서 덧셈의 위치 상관없이
         * (여기서는 뒤로) 두개의 숫자를 pop해서
         * 10이상이면 두개를 pop 
         *******************************/
		int T = Integer.parseInt(sc.nextLine());
		
		for(int t = 0; t < T; t++ ) {
			String num = sc.nextLine();
			int len = num.length();
			
			Stack<Integer> st = new Stack<>();
			
			if(len == 1) {
				System.out.println("#"+(t+1)+" B");
				continue;
			}
			
			for(int i = 0; i < len; i++) {
				st.add(num.charAt(i)-'0');
			}
			
			int step = 0;
			
			while(st.size() != 1) {
				int sum =st.pop()+st.pop();
				
				if(sum < 10) {
					st.push(sum);
				}else {
					st.push(sum/10);
					st.push(sum%10);
				}
				step++;
			}
			
				String res = (step%2==0)?"B":"A";
				System.out.println("#"+(t+1)+" "+res);
		}
		
	}
}
