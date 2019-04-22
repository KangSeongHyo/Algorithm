import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int start = 1,end=k+1;
		int ans = 0;
		/***************************
		 * �̺�Ž���� �̿��� K��°���� ���Ѵ�.
		 * �̶� ��ø�Ǵ� ������ �߻��ϱ� ������
		 * i*j�� ����� �̿��Ͽ� ������ �Ǵ���
		 * �̺�Ž������ ���ϴ� ���Ҹ� ã�´�.
		 ***************************/
		while (start<end) {
			// start < end �̹Ƿ� end���� ������ +1�� �ؾ��Ѵ�.
			int mid = (start+end)/2;
			int count = 0;
			for(int i = 1; i <= n; i++) {
				 count+=Math.min(mid/i,n);// n���� ū���� ������ ����.
			}
			if(count >= k) {
				ans = mid;
				end = mid;
			}else {
				start = mid+1;
			}
		}
		System.out.println(ans);
	}
}
