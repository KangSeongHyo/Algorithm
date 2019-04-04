import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int n,m,l;
	static int[][] map;
	static List<Integer>[] dirlist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			/******************************
	         * BFS를 이용해서 갈수 있는 방향에 대한
	         * 탐색을 진행한다. 그 후 L 시간이 될경우
	         * 에 그동안 탐색한 갯수를 출력한다.
	         *******************************/
			n = sc.nextInt();
			m = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			l = sc.nextInt();
			map = new int[n][m];
			visited = new boolean[n][m];
			dist = new int[n][m];
			count = 1; // 시작 맨홀 포함
			dirlist = new ArrayList[8];// 갈수있는 방향을 담는다.
			for(int i = 0; i < 8;i++) {
				dirlist[i] = new ArrayList<>();
			}
			
			for(int i = 0 ; i < n; i++) {
				for(int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			dirlist[1].add(0);dirlist[1].add(1);dirlist[1].add(2);dirlist[1].add(3);
			dirlist[2].add(0);dirlist[2].add(1);
			dirlist[3].add(2);dirlist[3].add(3);
			dirlist[4].add(0);dirlist[4].add(3);
			dirlist[5].add(1);dirlist[5].add(3);
			dirlist[6].add(1);dirlist[6].add(2);
			dirlist[7].add(0);dirlist[7].add(2);
			bfs(r, c);
			System.out.println("#"+t+" "+count);
			
		}
	}
	static int[][] dist;
	static boolean[][] visited;
	static int[][][] pass= {{},{{-1,0},{1,0},{0,-1},{0,1}}, // 상,하,좌,우
							{{-1,0},{1,0},{0,0},{0,0}},// 상,하
							{{0,0},{0,0},{0,-1},{0,1}},// 좌,우
							{{-1,0},{0,0},{0,0},{0,1}},// 상,우
							{{0,0},{1,0},{0,0},{0,1}}, // 하,우
							{{0,0},{1,0},{0,-1},{0,0}},// 하,좌 
							{{-1,0},{0,0},{0,-1},{0,0}}};// 상,좌
	
	static int[] dir = {1,0,3,2}; // 갈수있는 방향
	static int count;
	public static void bfs(int x, int y) {
		Queue<Passage> queue= new LinkedList<>();
		
		queue.add(new Passage(x, y));
		visited[x][y] = true;
		dist[x][y] = 1;
		
		while(!queue.isEmpty()) {
			Passage p = queue.remove();
			int pnum = map[p.x][p.y];
			if(dist[p.x][p.y] == l) break;
			for(int i = 0; i < pass[pnum].length;i++) { 
				int nx = p.x+pass[pnum][i][0];
				int ny = p.y+pass[pnum][i][1];
				
				if(pass[pnum][i][0] == 0 && pass[pnum][i][1] == 0 ) continue;
				
				if(isBoundary(nx, ny) && !visited[nx][ny] && dirlist[map[nx][ny]].contains(dir[i])){
					count++;
					visited[nx][ny] = true;
					dist[nx][ny] = dist[p.x][p.y] + 1;
					queue.add(new Passage(nx, ny));
				}
			}
		}
	}
	public static boolean isBoundary(int nx,int ny) {
		if(nx >= 0 && ny >= 0 && nx < n && ny < m) 
			return true;
		return false;
	}
	static class Passage{
		int x,y;
		public Passage(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
