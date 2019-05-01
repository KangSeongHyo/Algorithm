import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 100;
		for(int t = 1; t<=10; t++) {
			sc.nextInt();
			map = new int[n][n];
			for(int i = 0; i < n;i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int i = 0;
			flag = false;
			for(i = 0; i < n; i++) {
				if(map[0][i]==1) {
					visited = new boolean[n][n];
					dfs(0, i);
					if(flag) break;
				}
			}
			
			System.out.println("#"+t+" "+i);
		}
	}
	static int[] dx = {0,0,1};
	static int[] dy = {-1,1,0};
	static boolean flag;
	static boolean[][] visited;
	public static void dfs(int x, int y) {
		if(map[x][y]== 2) {
			flag = true;
			return;
		}
		visited[x][y] = true;
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isBoundry(nx, ny) &&!visited[nx][ny] &&(map[nx][ny] == 1 || map[nx][ny]==2)) {
				dfs(nx, ny);
				return;
			}
		}
		
	}
	private static boolean isBoundry(int nx,int ny) {
		if(nx < 0|| ny < 0|| nx >=n || ny>=n) return false;
		return true;
	}
 }
