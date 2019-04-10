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
			 * ������ N�� ��� ��ġ�� ����Ž���Ѵ�.
			 * �׸��� DFS�� �̿��Ͽ� �ش� ������
			 * ũ�� ��ŭ �ݺ��� �Ͽ� �����¿�
			 * �� ����ũ�⸸ŭ �����ְ� �ѹ� ��� ���Ŀ�
			 * �������ְ� �ٽý�� ���� �ݺ��Ͽ�
			 * ���� ������ �ּڰ��� ���Ѵ�.
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
		//������ġ ����Ž�� 
		
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
			  // ���� ũ�⸸ŭ dfs �ݺ�
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
		// �߷�
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
