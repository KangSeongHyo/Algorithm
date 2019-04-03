import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int n,m;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visted;
	static List<Pair> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		/******************************
		 * BFS를 이용해 방법 서비스의 모든 영역이
		 * 되는 구간을 완전탐색을 통해 구해서
		 * 그 안에 들어가는 카메라의 개수를 구한다.
         *******************************/
		for(int t = 1; t <= T; t++) {
			list = new LinkedList<>();
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++ ) {
					int home = sc.nextInt();
					map[i][j] = home;
				}
			}
			
			int max = 0;
			for(int k = 1; k <= n+1; k++) {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						dist = new int[n][n];
						visted = new boolean[n][n];
						count = 0;
						bfs(i, j, k);
						int cost = k*k+(k-1)*(k-1);
						int total = count*m-cost;
						//System.out.println("k : "+k+" cost : "+cost+" total : "+ total+" count : "+count);
						if(total >= 0) 
							max = Math.max(max, count);
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
	static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int count;
	private static void bfs(int x,int y,int k) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		visted[x][y] = true;
		dist[x][y] = 1;
		if(map[x][y]== 1) count++;
		
		while (!queue.isEmpty()) {
			Pair start = queue.remove();
			if(dist[start.x][start.y] > k) return;
			//if(k == 2 && x==0 &&y==0) print();
			for(int i = 0; i < 4; i++) {
				int nx = start.x + dx[i];
				int ny = start.y + dy[i];
				if(isBoundary(nx, ny)&&!visted[nx][ny]) {
					dist[nx][ny] = dist[start.x][start.y]+1;
					visted[nx][ny] = true;
					if(dist[nx][ny]<=k) {
						queue.add(new Pair(nx, ny));
						count = map[nx][ny]==1?count+1:count;
					}
				}
			}
		}
	}
	
	public static boolean isBoundary(int nx,int ny) {
		if(nx >= 0 && ny >= 0 && nx < n && ny < n) 
			return true;
		return false;
	}
	static class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
