import java.util.Scanner;

public class Main {
	static int n;
	static int[][] map;
	static int[][] memo;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/******************************
         * DP �޸����̼�(���)�� �̿��Ͽ� �Ǵٰ� �� �� �ִ�
         * �ִ� ���ڸ� ���Ѵ�. 
         * 
         * ex)
         *      map       �ϼ�
         * 	   1 3 9     0 0 0
         * 	   2 5 4     0 0 0
         *     6 8 7     0 0 0
         *     
         *   �� �� �� �� ���� Ž���Ѵٰ� ����
         *   
         * 1 -> 3 -> 5 -> 8 
         *  8����(1)->5(1+1)->3(2+1)->1(3+1)
         *   -> 3 -> 9
         *   9����(1)->3(1+1)->1(2+1)
         *   �� �ռ��� �ִ��ϼ��� ������ ������ �ʴ´�
         *   -> 2 -> 5
         *   5����(2)->2(2+1)->1(3+1)
         *   �� 5�� �̹� Ž���߱� ������ Ž������ �ʴ´�. 
         * 	  (����������� ��� ���� Ž���ϱ� ����)
         *******************************/
		n = sc.nextInt();
		map = new int[n][n];
		memo = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(memo[i][j] == 0)
					search(i, j);
			}
		}
		
		System.out.println(max);
	}
	static int max = 1; // �ּ� �Ϸ�� ���.
	public static int search(int x, int y) {
	
		if(memo[x][y] > 0) // �̹� Ž����
			return memo[x][y];		
		
		
		 memo[x][y] = 1; // �湮�� ������ 1, �ڱ��ڽ�
		
		 for(int i = 0; i < 4; i++) {
			 int nx = x + dx[i];
			 int ny = y + dy[i];
			 int start = map[x][y];
			 if(isBoundry(nx, ny) && start < map[nx][ny]) {
				 memo[x][y] = Math.max(memo[x][y], search(nx, ny)+1);
				 // �ڱ��� �湮���� �ִ밪, �̴� �տ� Ž���ϴ� �Ϳ� �������
				 max = Math.max(max, memo[x][y]);
			 }
		 } 
	 
	  return memo[x][y]; // �����������
	}
	
	public static boolean isBoundry(int nx,int ny) {
		if(nx >=0 && ny >=0 && nx < n && ny < n) {
			return true;
		}else {
			return false;
		}
	}
}
