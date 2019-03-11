import java.util.Scanner;

public class Solution {
	static int max;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		/******************************
         * DFS 탐색을 이용하여 자리를 바꿨을떄
         * 숫자가 커지는 모든 경우의 탐색하여
         * 최댓값을 구한다.
         *******************************/
		for(int t = 1; t <= T; t++ ) {
			
			int num = sc.nextInt();
			int n = sc.nextInt();
			int len = String.valueOf(num).length();
			max = Integer.MIN_VALUE;
			dfs(num, n, 0, 0,len);
			
			System.out.println("#"+t+" "+max);
			
		}
		
	}
	public static void dfs(int num, int n, int idx,int cnt,int len) {
		
		if(n == cnt) {
			max = Math.max(max, num);
			return;
		}
		
		  for(int i = idx; i < len; i++) { // 삼각탐색
			for(int j = i; j < len ; j++) {
				if(i == j) continue;
				int a = String.valueOf(num).charAt(i)-'0';
				int b = String.valueOf(num).charAt(j)-'0';
				
				if(b >= a) {
					int num_swap = swap(num, i, j);
					dfs(num_swap, n, i, cnt+1, len);
				}
			}
		  }
	}
	
	public static int swap(int num, int start, int idx) {
		
			char[] chrarr = String.valueOf(num).toCharArray();
			char temp = chrarr[start];
			chrarr[start] = chrarr[idx];
			chrarr[idx] = temp;
			
			String str = new String(chrarr, 0, chrarr.length);
			return Integer.parseInt(str);
			
	}
}
