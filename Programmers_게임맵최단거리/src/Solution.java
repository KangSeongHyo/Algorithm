import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static int m;
	public int solution(int[][] maps) {
		int answer = 0;
		n = maps.length;
		m = maps[0].length;
		/******************************
         * BFS 탐색을 통해서 끝점까지가는
         * 경로의 최솟값을 구한다.
         *******************************/
		visited = new boolean[n][m];
		dist = new int[n][m];
		answer = solve(maps);
		return answer;
	}
	static boolean[][] visited;
	static int[][] dist;
	public int solve(int[][] maps) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0));
		visited[0][0] = true;
		dist[0][0] = 1;
		while (!queue.isEmpty()) {
			Pair p = queue.remove();
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(isBoundary(nx, ny) && maps[nx][ny]==1) {
					visited[nx][ny] = true;
					dist[nx][ny] = dist[p.x][p.y]+1;
					queue.add(new Pair(nx, ny));
					if(nx == n-1 && ny == m-1) {
						return dist[nx][ny];
					}
				}
			}
		}
		return -1;
	}
	public boolean isBoundary(int nx, int ny) {
		if(nx < 0||ny < 0||nx >= n||ny>=m||visited[nx][ny]) {
			return false;
		}else
			return	true;
	}
	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
}