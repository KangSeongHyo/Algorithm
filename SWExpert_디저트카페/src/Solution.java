import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	static int n;
	static int[][] map;
	static int[][] dist;
	static List<Integer> cafes;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		/******************************
         * DFS와 백트래킹을 이용해서 정사각형
         * 직사각형이 이루어질 수 있는 모든 경우를
         * 탐색하여 경로의 수를 구한다.
         *******************************/
		for(int t = 1; t <= T; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++ ) {
					map[i][j] =  sc.nextInt();
				}
			}
			
			res = -1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(j==0) continue;
					vistied = new boolean[n][n];
					startx = i; starty = j;
					desert = new boolean[101];
					dfs(i, j, 0,0);
				}
			}
			System.out.println("#"+t+" "+res);	
		}
		
	}
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {-1,1,1,-1};
	static int startx;
	static int starty;
	static boolean[][] vistied;
	static boolean[] desert;
	static int res;
	public static void dfs(int x,int y,int curent,int cnt) {
		
		if(startx == x && starty == y && cnt !=0) {
			res = Math.max(res,cnt);
			return;
		}
		for(int i = curent; i <= curent+1; i++) {
			if(i == 4) break;
			if(startx == x && starty == y && i==1) break;
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(isBoundary(nx, ny) && !vistied[nx][ny] && !desert[map[nx][ny]]) {
				vistied[nx][ny] = true;
				desert[map[nx][ny]] = true;
				dfs(nx, ny,i,cnt+1);
				vistied[nx][ny] = false;
				desert[map[nx][ny]] = false;
			}
		}
		
	}
	
	public static boolean isBoundary(int nx,int ny) {
		if(nx >= 0 && ny >= 0 && nx < n && ny < n) 
			return true;
		return false;
	}
	
}
