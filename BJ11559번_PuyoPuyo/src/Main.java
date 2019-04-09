import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static int count;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int chain;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		/******************************
		 * DFS�� �̿��Ͽ� ���� ���� �ѿ��� ������
		 * Ž���Ѵ�. �̶� 4���̻��� ��� �ѿ並
		 * ��Ʈ����.(�����) �׸��� ���ִ�
		 * �ѿ���� �Ʒ��� ����� �� �������� �ݺ��Ͽ�
		 * ���� �� Ƚ���� ����Ѵ�.
         *******************************/
		for(int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		chain = 0;
		solve();
		System.out.println(chain);
	}
	
	private static void solve() {
	 while (true) {			
		boolean check = false;
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if(map[i][j] !='.') {
					count = 0;
					visited = new boolean[12][6];
					dfs(i, j, map[i][j]);
					if(count >=4) {
						clean();
						check = true;
					}
				}
			}
		}
		
		if(check) {
			chain++;
			pullDown();
		}
		else break;
	  }
	}
	private static void pullDown() {
		for(int i = 0; i < 6; i++) {
			for(int j = 11; j >= 1; j--) {
				for(int k = j-1; k>=0; k--) {
					if(map[j][i] != '.') break;
					if(map[k][i] != '.' ) {
						map[j][i] = map[k][i];
						map[k][i] = '.';
						break;
					}
				}
			}
		}
	}
	private static void clean() {
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if(visited[i][j]) {
					map[i][j] = '.';
				  }
			}
		}
	}
	private static void dfs(int x, int y, char puyo) {
		
		visited[x][y] = true;
		count++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isBoundary(nx, ny) &&!visited[nx][ny]&& map[nx][ny] == puyo) {
				dfs(nx, ny, puyo);
			}
		}
	}
	public static boolean isBoundary(int nx,int ny) {
		if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) 
			return false;
		return true;
	}
}
