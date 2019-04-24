import java.util.Scanner;

public class Main {
	static int[][] map;
	static int count;
	public static void main(String[] args) {
		/***************************
		 * DFS 백트래킹을 이용해서 모든
		 * 경우를 탐색한다. 이때 스도쿠 조건인
		 * 가로, 세로, 3*3 그룹에 대한 체크
		 * 를 포함한다.
		 ***************************/
		Scanner sc = new Scanner(System.in);
		map = new int[9][9];
		count = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==0) count++;
			}
		}
		
		solve(0);
	}
	private static void print() {
		//System.out.println();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void solve(int deep) {
		//print();
		if(count == deep) {
			print();
			System.exit(0);
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(map[i][j] == 0) {
					for(int k = 1; k <= 9; k++) {
						if(isBoundary(i, j, k)) {
							map[i][j] = k;
							solve(deep+1);
							map[i][j] = 0;
							// 0으로 하는 이유는
							// 조건체크할때 포함해서 체크하기 때문
						}
					}
					return; // 탐색 필요없음 스도쿠에 0은 존재하지 않기때문
				}
			}
		}
	}
	static int[] chg = {0,0,0,3,3,3,6,6,6};
	public static boolean isBoundary(int x, int y, int target) {
		for(int i = 0; i < 9; i++) {
			if(map[i][y] == target||map[x][i]==target) {
				return false;
			}
		}
		x = chg[x];
		y = chg[y];
		for(int i = x; i < x+3; i++) {
			for(int j = y; j<y+3; j++ ) {
				if(map[i][j]==target)
					return false;
			}
		}
		return true;
	}
}
