import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/***************************
		 * Ȧ���� ����� �Ǵ� ���� �̸� ������
		 * �̸� �̿��� �������� ���ϰ� 
		 * ������� ����Ѵ�.
		 ***************************/
		long[] nums = new long[1_000_001];
		long[] sum = new long[1_000_001];
		// ����� �� ���ϱ�
		// i�� ��� i*j�� ���Ϸ��� ���
		// NlogN
		for(int i = 1; i < nums.length; i=i+2) {
			for(int j = 1; i*j < nums.length; j++) {
				nums[i*j] +=i;
			}
		}
		sum[0] = nums[0];
		for(int i = 1; i<nums.length; i++ ) {
			sum[i] = sum[i-1]+nums[i];
		}
		int test = sc.nextInt();
	        
		for(int t=1; t<=test; t++) {
			int L = sc.nextInt();
			int R = sc.nextInt();
			System.out.println("#"+t+" "+(sum[R]-sum[L-1]));
		}
	}
}
