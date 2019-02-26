import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int testcase = 1;
		/******************************
         * ������ �̿��ؼ� A+M/2�� �ִ밡 �Ǵ�
         * ��Ģ�� n-k ��°�� ū�ź��� n����
         * ������ ���� ���� ����Ѵ�.
         *******************************/
		
		while(t-- >0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			double a = 0;
			List<Integer> list = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			
			list = list.stream().sorted().collect(toList());
			
			if(k == 1) {
				System.out.println("#"+(testcase++)+" "+((double)list.get(n-1)/2));
				continue;
			}
			
			for(int i = n-k; i < n ; i++) {
				int num = list.get(i);
				a = (double)((a+num)/2);
			}
			System.out.println("#"+(testcase++)+" "+a);
		}
		
	}
}
