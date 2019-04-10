import java.util.Scanner;

public class Main {
	static int n,m;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/******************************
		 * DFS를 이용해 벽 쌓는 것을 완전탐색하고
		 * 바이러스가 퍼지는 경우를 체크해서
		 * 안전영역의 갯수를 구한다.
         *******************************/
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for(int i = 0; i <n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		count = 0;
		solve(0);
		System.out.println(count);
	}
	public static boolean[][] visited;
	static int count;
	private static void solve(int wall) {
		if(wall == 3) {
			visited = new boolean[n][m];
			for(int i = 0; i <n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 2 && !visited[i][j]) {
							dfs(i, j);
					}
				}
			}
			
			int total = 0;
			for(int i = 0; i <n; i++) {
				for(int j = 0; j < m; j++) {
					if(!visited[i][j]&&map[i][j]==0) {
						total++;
					}
				}
			}
			count = Math.max(count,total);
			return;
		}
		
		for(int i = 0; i <n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					solve(wall+1);
					map[i][j] = 0;
				}
			}
		}
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isBoundary(nx, ny)&&!visited[nx][ny]&&map[nx][ny]==0) {
				dfs(nx, ny);
			}
		}
	}
	public static boolean isBoundary(int nx,int ny) {
		if(nx < 0 || ny < 0 || nx >= n || ny >= m)
			return false;
		return true;
	}
}
