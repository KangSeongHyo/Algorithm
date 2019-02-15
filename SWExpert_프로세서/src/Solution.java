import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		/******************************
         * Core를 확인하면서 가장자리에 있는 것은
         * length에 카운트가 되지않기 때문에 
         * 있는지만 판단하고 list에는 넣지않는다.
         * Core들의 좌표가 담긴 리스트를 이용해서
         * DFS와 백트래킹을 이용해 모든 경우에 대한
         * length를 구하고 Core가 가장많이 연결된
         * 경우의 최소 length 값을 구한다. 
         *******************************/
		
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			List<Pair> core = new LinkedList<>();
			visited = new boolean[n][n];
			len = 0;
			min = Integer.MAX_VALUE;
			core_cnt = 0;
			
			for(int i = 0; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n ; j++) {
					int k = Integer.parseInt(st.nextToken());
					if(k == 1) {
						visited[i][j] = true;
					    if(i==0||j==0||i==n-1||j==n-1) continue; // 가장자리 코어
						core.add(new Pair(i, j));
					}
				}
			}
			dfs(core, 0,0);
			sb.append("#"+(t+1)+" "+(min)+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0}; // 동 서 남 북
	static int min = Integer.MAX_VALUE;
	static int len = 0;
	static int core_cnt = 0;
	public static void dfs(List<Pair> core, int cur, int cnt) {
		
		if(core.size() <= cur) {
			if(cnt > core_cnt) {
				core_cnt = cnt;
				min = len;
			}else if(cnt == core_cnt) {
				min = Math.min(len, min);
			}
			if(core.size() == cur) return; // core 개수보다 많아지는 경우는 없음
		}
		
		
		Pair p = core.get(cur);
		
		int x = p.x;
		int y = p.y;
		boolean temp[][] = new boolean[n][n];
		boolean flag = false;

		copy(temp, visited);
		
		for(int i = 0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!visited[nx][ny] && check(i, nx, ny)) {
				flag = true;
				
				switch (i) {
				case 0: // 동
					Arrays.fill(visited[nx], ny, n, true);
					len += n - ny;
					dfs(core, cur+1, cnt+1);
					len -= (n - ny);//백트래킹
					break;
				case 1: // 서
					Arrays.fill(visited[nx], 0, ny+1, true);
					len += ny+1;
					dfs(core, cur+1, cnt+1);
					len -= (ny+1);
					break;
				case 2: // 남
					for(int j = nx; j < n; j++) {
						Arrays.fill(visited[j],ny,ny+1,true);
					}
					len += n - nx;
					dfs(core, cur+1, cnt+1);
					len -= (n - nx);
					break;

				default://북
					for(int j = 0; j <= nx; j++) {
						Arrays.fill(visited[j],ny,ny+1,true);
					}
					len += nx+1;
					dfs(core, cur+1, cnt+1);
					len -= (nx+1);
					break;
				}
				copy(visited, temp);
			}
			
			if(!flag) dfs(core, cur+1, cnt); // 최대한 많이 연결하는 것이므로
		}
		
	}
	
	public static void copy(boolean[][] target, boolean[][] arr) {
		for(int i = 0; i < n;i++) {
			target[i] = arr[i].clone();
		}
	}
	
	public static boolean check(int dir,int nx,int ny) {
		switch (dir) {
		case 0:
			for(int i = ny + 1; i < n; i++) {
				if(visited[nx][i]) return false;
			}
			break;
		case 1:
			for(int i = 0 ; i < ny; i++) {
				if(visited[nx][i]) return false;
			}
			break;
		case 2:
			for(int i = nx + 1 ; i < n; i++) {
				if(visited[i][ny]) return false;
			}			
			break;
		default:
			for(int i = 0 ; i < nx; i++) {
				if(visited[i][ny]) return false;
			}
			break;
		}
		
		return true;
	}
	
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
