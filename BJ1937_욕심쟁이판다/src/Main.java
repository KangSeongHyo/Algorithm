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
         * DP 메모제이션(재귀)을 이용하여 판다가 살 수 있는
         * 최대 일자를 구한다. 
         * 
         * ex)
         *      map       일수
         * 	   1 3 9     0 0 0
         * 	   2 5 4     0 0 0
         *     6 8 7     0 0 0
         *     
         *   우 하 좌 상 으로 탐색한다고 가정
         *   
         * 1 -> 3 -> 5 -> 8 
         *  8종료(1)->5(1+1)->3(2+1)->1(3+1)
         *   -> 3 -> 9
         *   9종료(1)->3(1+1)->1(2+1)
         *   ※ 앞서가 최대일수기 때문에 변하지 않는다
         *   -> 2 -> 5
         *   5종료(2)->2(2+1)->1(3+1)
         *   ※ 5는 이미 탐색했기 때문에 탐색하지 않는다. 
         * 	  (도착햇을경우 모든 방향 탐색하기 때문)
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
	static int max = 1; // 최소 하루는 산다.
	public static int search(int x, int y) {
	
		if(memo[x][y] > 0) // 이미 탐색함
			return memo[x][y];		
		
		
		 memo[x][y] = 1; // 방문의 시작은 1, 자기자신
		
		 for(int i = 0; i < 4; i++) {
			 int nx = x + dx[i];
			 int ny = y + dy[i];
			 int start = map[x][y];
			 if(isBoundry(nx, ny) && start < map[nx][ny]) {
				 memo[x][y] = Math.max(memo[x][y], search(nx, ny)+1);
				 // 자기의 방문수의 최대값, 이는 앞에 탐색하는 것에 영향받음
				 max = Math.max(max, memo[x][y]);
			 }
		 } 
	 
	  return memo[x][y]; // 갇혀있을경우
	}
	
	public static boolean isBoundry(int nx,int ny) {
		if(nx >=0 && ny >=0 && nx < n && ny < n) {
			return true;
		}else {
			return false;
		}
	}
}
