import java.util.Scanner;

public class Solution {
	static int n,x;
	static int[][] map;
	static int len;
	static int res;
	public static void main(String[] args) {
		/******************************
		 * 활주로의 가로 세로를 붙여 하나의 배열로
		 * 만들고 앞에서 부터 탐색하면서 
		 * 경사로가 될수있는지 없는지 판단하여
		 * 그 갯수를 출력한다.
         *******************************/
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			n = sc.nextInt();
			x = sc.nextInt();
			map = new int[n+n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i+n][j] = map[j][i];
				}
			}
			res = 0;
			solve();
			System.out.println("#"+t+" "+res);
		}
	}
	private static void solve() {
		for(int i = 0; i < n+n; i++) {
			len = 1;
			boolean isPossible = true;
			for(int j = 0; j < n-1; j++){
				int curent = map[i][j];
				int next =map[i][j+1];
				if(curent == next) len ++;
				else if(curent+1 == next && len>=x) len = 1;
				//앞이 높을 경우
				else if(curent-1 == next && len>=0) len = 1-x;
				//앞이 낮을 경우
				else {
				// 경사로 세울수 없는 경우
					isPossible = false;
					break;
				}
			}
			if(len >= 0 && isPossible) res++;
		}
	}
	
}
