import java.util.Scanner;

public class Main {
	static int[] oper;
	static int[] nums;
	public static void main(String[] args) {
		/******************************
         * 완전탐색을 이용해서 모든 경우를 
         * 계산하여 최대값 최소값을 찾는다.
         *******************************/
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		oper = new int[4];
		nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		for(int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
		}//+ - x /
		long total = nums[0];
		dfs(n, 1, total);
		System.out.println(max);
		System.out.println(min);
	}
	static long min = Integer.MAX_VALUE;
	static long max = Integer.MIN_VALUE;
	
	public static void dfs(int n,int deep,long total) {
		if(n == deep) {
			min = Math.min(min, total);
			max = Math.max(max, total);
			return;
		}
		
		if(oper[0] != 0) {
			oper[0]--;
			dfs(n, deep+1,total+nums[deep]);
			oper[0]++;
		}
		if(oper[1] != 0) {
			oper[1]--;
			dfs(n, deep+1,total-nums[deep]);
			oper[1]++;
		}
		if(oper[2] != 0) {
			oper[2]--;
			dfs(n, deep+1,total*nums[deep]);
			oper[2]++;
		}
		if(oper[3] != 0) {
			oper[3]--;
			dfs(n, deep+1,total/nums[deep]);
			oper[3]++;
		}
		
	}
}
