import java.util.Scanner;

public class Solution {
	static int n;
	static int[] oper = new int[4];
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/******************************
         * 완전탐색을 이용하여 모든경우의 수를 구한다.
         * 이때 연산자가 없을경우는 탐색하지 않는다.
         *******************************/
		int test =sc.nextInt();
		for(int t = 1; t <= test; t++) {
			n = sc.nextInt();
			nums = new int[n];
			for(int i = 0; i < 4; i++) {
				oper[i] = sc.nextInt();
			}
			for(int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			solve(1, nums[0]);
			System.out.println("#"+t+" "+(max-min));
		}
	}
	static int min;
	static int max;
	public static void solve(int start, int total) {
		if(start == n) {
			max = Math.max(max, total);
			min = Math.min(min, total);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(oper[i] != 0) {
				oper[i]--;
				int temp = total;
				switch (i) {
				case 0:
					total += nums[start];
					break;
				case 1:
					total -= nums[start];
					break;
				case 2:
					total *= nums[start];
					break;
				default:
					total /= nums[start];
					break;
				}
				solve(start+1, total);
				oper[i]++;
				total = temp;
			}
		}
		
	}
}
