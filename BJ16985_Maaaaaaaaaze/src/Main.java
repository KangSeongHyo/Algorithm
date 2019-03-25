import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][][][] qube = new int[4][5][5][5];
	// �Ǿ� 0 ~ 3 �ð���� ȸ�� �� , �ι�° ��
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = 4;
		/******************************
         * ť�� ���� �ٲٴ� 5!�� ��� ���
         * �� ���� ȸ���ϴ� ����� 4*4*4*4*4
         * �� ����Ž���ϰ� BFS�� ���� 3������
         * �ּڰ��� ���� ��� ��쿡���� 
         * �ּڰ��� ����Ѵ�.
         *******************************/
		for(int k = 0; k < 5; k++) {
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					qube[0][k][i][j] = sc.nextInt();
				}
			}
			// ȸ��
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					qube[1][k][i][j] = qube[0][k][len-j][i];
				}
			}
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					qube[2][k][i][j] = qube[0][k][len-i][len-j];
				}
			}
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					qube[3][k][i][j] = qube[0][k][j][len-i];
				}
			}
		}
		
		qube_rotation(0, "");
		res = res == Integer.MAX_VALUE?-1:res;
		System.out.println(res);
	}
	
	static boolean[] visited_board = new boolean[5];
	
	// ť������ ������ ��� ���Ѵ�.
	public static void qube_rotation(int deep,String order) {
		if(deep == 5) {
			board_rotation(order.split(","));
			return;
		}
		 for(int i = 1; i <= 5; i++) {
			 if(!visited_board[i-1]) {
				 visited_board[i-1] = true;
				 qube_rotation(deep+1,order+i+",");
				 visited_board[i-1] = false;
			 }
		 }
	} 
	
	static int[][][] board = new int[5][5][5];
	static int res = Integer.MAX_VALUE;
	// ������ ȸ���ϴ� ��� ��츦 ���Ѵ�.
	public static void board_rotation(String[] order) {
		for(int tmp = 0; tmp < 1024; tmp++) { 
			// 4���� -> ���� ȸ������ �����ϴ� ��� ����� �� 4^5��
			int brute = tmp;
			
			for(int k = 0; k < 5; k++) {
			  int dir = brute % 4; 
			  // ������ ������ ���� ���� �ǿ� �ش��ϴ� ������ ���Ѵ�.
			  brute /= 4; 
			  // �������� ������ ���ϱ� ���� �������� �̿��Ѵ�. 
			  // ex) 3*4^1 + 4^0 --������--> 3*4^0
			  
			  for(int i = 0; i < 5; i++) {
				  for(int j = 0; j < 5; j++) {
					  board[k][i][j] = qube[dir][Integer.parseInt(order[k])-1][i][j];
				  }
			  }
			}
			res = Math.min(res, bfs());
		}
	}
	
	static int[] dx = {0,0,1,-1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	public static int bfs() {
		boolean visited[][][] = new boolean[5][5][5];
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		int min = Integer.MAX_VALUE;
		
		if(board[0][0][0] == 0) return min;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			int x = p.x; int y = p.y; int z = p.z; int w = p.w;
			for(int u = 0; u < 6; u++) {
				int nx = x + dx[u]; int ny = y + dy[u]; int nz = z + dz[u];
				if(isBoundry(nx, ny, nz) && !visited[nx][ny][nz] && board[nx][ny][nz] == 1) {
					if(nx == 4 && ny == 4 && nz == 4) {
						min = Math.min(min, w+1);
					}else {
						Pair np = new Pair(nx, ny, nz, w+1);
						visited[nx][ny][nz] = true;
						queue.add(np);
					}
				}
			}
		}
		
		return min;
		
	}
	
	
	public static boolean isBoundry(int x,int y,int z) {
		if(x >= 0 && y >= 0 && z >= 0 && x < 5 && y < 5 && z < 5) {
			return true;
		}
		return false;
	}
	
	static class Pair{
		int x,y,z,w;
		public Pair(int x, int y, int z,int w) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.w = w;
		}
	}
}
