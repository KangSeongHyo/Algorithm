import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[] lan = new int[k];
		long max = 0;
		/****************************
		 * �ִ���̸� �������� �̺�Ž���� �Ͽ�
		 * k�� �̻��� �����ϴ� ���� �� �ִ밪��
		 * ã�� ����Ѵ�.
         ****************************/
		for(int i = 0; i < k ; i++) {
			lan[i] = sc.nextInt();
			max = Math.max(max, lan[i]);
		}
		long start = 0;
		long end = max+1;
		long ans = 0;
		while(start<end) {
			long mid = (start+end)/2;
			long count = 0;
			for(int i = 0; i < lan.length; i++) {
				count+= lan[i]/mid;
			}
			if(count >= n) {
				ans = Math.max(ans, mid);
				start = mid+1;
			}else {
				end = mid;
			}
		}
		System.out.println(ans);
	}
}
