import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int[][] wall;
	static int n;
	static int l;
	static int r;
	static int[] dx = {-1,0,1,0}; // 시계방향
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static boolean[][] visited2;
	static int total;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		arr = new int[n][n];
		wall = new int[n][n];
		visited = new boolean[n][n];
		visited2 = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		/******************************
         * DFS와 비트연산을 이용하여 
         * 먼저 통로를 만들어서 길을 만들고
         * DFS를 통해 탐색하여 인구수를 바꿔준다.
         * 위를 반복하여 더이상 통로를 만들 수 없을
         * 경우 답을 출력한다.  
         *******************************/
		
	  int move = 0;
	  while(wallCheck()) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					visited2 = new boolean[n][n];
					total = arr[i][j];
					cnt = 1;
					dfs(i, j);
					if(cnt > 1) {
						arr[i][j] = total/cnt;
						dfs_modify(i, j, total/cnt);
					}
				}
			}
		 }
		move++;
		/*System.out.println(move+"초 시간");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}*/
		
		visited = new boolean[n][n];
		wall = new int[n][n];
	  }
	  System.out.println(move);
	}
	
	public static void dfs(int i, int j) {
		
		for(int k = 0; k < 4; k++) {
			int dir = 1<<k;
			int nx = i + dx[k];
			int ny = j + dy[k];
			if(nx>=0 && ny>=0 && nx<n && ny<n && (wall[i][j]&dir)==dir && !visited[nx][ny]) {
				visited[nx][ny] = true;
				visited2[nx][ny] = true;
				total += arr[nx][ny];
				cnt ++;
				dfs(nx, ny);
			}
		}
		
	}
	public static void dfs_modify(int i,int j,int people) {
		/*for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if(nx>=0 && ny>=0 && nx<n && ny<n && visited2[nx][ny]) {
				visited2[nx][ny] = false;
				arr[nx][ny] = people; 
				dfs_modify(nx, ny, people);
			}
		}*/
		for(int x = 0; x < n; x++) {
			for(int y = 0; y < n; y++) {
				if(visited2[x][y]) {
					visited2[x][y] = false;
					arr[x][y] = people; 
				}
			}
		}
		
	}
	
	
	public static boolean wallCheck() {
		boolean hasWall = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int people = arr[i][j];
				for(int k = 0; k < 4; k++) {
					int dir = 1<<k;
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx>=0 && ny>=0 && nx<n && ny<n) {
						int diff = Math.abs(people-arr[nx][ny]);
						if(diff >=l && diff <= r) {
							hasWall = true;
							wall[i][j]+=dir;
						}
					}
				}
			}
		}
		return hasWall;
	}
}
