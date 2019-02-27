import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/******************************
         * Stack�� �̿��ؼ� ������ ��ġ �������
         * (���⼭�� �ڷ�) �ΰ��� ���ڸ� pop�ؼ�
         * 10�̻��̸� �ΰ��� pop 
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
