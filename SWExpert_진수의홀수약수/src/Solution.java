import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/***************************
		 * 홀수의 약수가 되는 수를 미리 구한후
		 * 이를 이용해 구간합을 구하고 
		 * 약수합을 출력한다.
		 ***************************/
		long[] nums = new long[1_000_001];
		long[] sum = new long[1_000_001];
		// 약수의 합 구하기
		// i는 약수 i*j는 구하려는 약수
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
