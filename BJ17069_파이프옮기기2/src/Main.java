import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] imp = {{1,0,1},
						  {0,1,1},
						  {1,1,1}};
	static int[] dx = {0,1,1};
	static int[] dy = {1,0,1};
	static boolean[][] visited;
	static long [][][] path;
	static int n;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n][n];
		path = new long[3][n][n];
		map = new int[n][n];
		/******************************
		 * DFS를 이용하여 모든 경로에 대해서
		 * 갈수 있는지 판단한다. 이때 n이 크기 
		 * 때문에 DP 메모제이션을 이용하여
		 * 이미 탐색한 부분에 대한 경로를 저장하여
		 * 탐색 수를 줄여서 끝점까지 갈수 있는
		 * 경우의 수를 구한다.
         *******************************/
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		solve();
		
		System.out.println(path[0][0][1]);
	}
	
	public static void solve() {
		visited[0][0] = true;
		visited[0][1] = true;
		dfs(0, 1, 0);
	}
	static int count;
	public static long dfs(int x ,int y, int dir) {
		//System.out.println(x+" "+y);
		
		if(path[dir][x][y] != 0) 
			return path[dir][x][y];
		
		if(x == n-1 && y == n-1) 
			return 1;
		
		for(int i = 0; i < 3; i++) {
			if(imp[dir][i] == 1) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(boundary(nx, ny)&&!visited[nx][ny]&&map[nx][ny]!=1) {
					if(i==2&&(map[nx][ny-1]==1||map[nx-1][ny]==1)) continue;
					visited[nx][ny] = true;
					path[dir][x][y] += dfs(nx, ny, i);
					visited[nx][ny] = false;
				}
				
			}
		}
		return path[dir][x][y];
	}
	private static boolean boundary(int nx,int ny) {
		if(nx < 0 || ny < 0|| nx >= n || ny >= n ) 
			return false;
		return true;
	}
	
	
	static class Pair{
		int x,y,dist,dir;

		public Pair(int x, int y, int dist,int dir) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.dir  = dir;
		}
	}
}
