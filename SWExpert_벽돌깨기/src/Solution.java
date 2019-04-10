import java.util.Scanner;

public class Solution {
	static int n;
	static int w;
	static int h;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1; t <= test; t++ ) {
			/******************************
			 * 벽돌을 N번 쏘는 위치를 완전탐색한다.
			 * 그리고 DFS를 이용하여 해당 벽돌의
			 * 크기 만큼 반복을 하여 상하좌우
			 * 를 벽돌크기만큼 없애주고 한번 쏘고 난후에
			 * 정렬해주고 다시쏘는 것을 반복하여
			 * 남은 벽돌의 최솟값을 구한다.
	         *******************************/
			n = sc.nextInt(); w = sc.nextInt(); h = sc.nextInt();
			map = new int[h][w];
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					int temp = sc.nextInt();
					if(temp != 0) {
						map[i][j] = temp;
					}
				}
			}
			res = Integer.MAX_VALUE;
			solve(0);
			System.out.println("#"+t+" "+res);
		}
	}
	static int res;
	private static void solve(int deep) {
		//벽돌위치 완전탐색 
		
		int[][] temp_map = new int[h][w];
		deepClone(map, temp_map);
		
		if(n==deep) {
			int cnt = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] != 0) cnt++; 
				}
			}
			res = Math.min(res, cnt);
			return;
		}		
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				if(map[j][i] != 0) {
					dfs(j, i);
					break;
				}
			}
			pullDown();
			solve(deep+1);
			deepClone(temp_map, map);
		}
	}
	private static void dfs(int x,int y) {
		int range = map[x][y];
		map[x][y] = 0;
		
		for(int i = 0; i < 4; i++) {
		  for(int size = 0; size < range; size++) {
			  // 벽돌 크기만큼 dfs 반복
				int nx = x + dx[i]*size;
				int ny = y + dy[i]*size; 
				if(isBoundary(nx, ny)&&map[nx][ny] != 0) { 
					dfs(nx, ny);
				}
			}
		}
		
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static boolean isBoundary(int nx,int ny) {
		if(nx < 0 || ny < 0 || nx >= h || ny >= w)
			return false;
		return true;
	}
	
	private static void pullDown() {
		// 중력
		for(int i = 0; i < w; i++) {
			for(int j = h-1; j >= 1; j--) {
				for(int p = j-1; p >= 0;p--) {
					if(map[j][i]!=0) 
						break;
					if(map[p][i]!=0) {
						map[j][i] = map[p][i];
						map[p][i] = 0; 
						break;
					}
				}
			}
		}
		
	}
	public static void deepClone(int[][] origin,int[][] copy) {
		for(int i = 0; i < h; i++) {
			copy[i] = origin[i].clone();
		}
	}
	
}
