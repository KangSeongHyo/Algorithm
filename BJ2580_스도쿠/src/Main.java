import java.util.Scanner;

public class Main {
	static int[][] map;
	static int count;
	public static void main(String[] args) {
		/***************************
		 * DFS ��Ʈ��ŷ�� �̿��ؼ� ���
		 * ��츦 Ž���Ѵ�. �̶� ������ ������
		 * ����, ����, 3*3 �׷쿡 ���� üũ
		 * �� �����Ѵ�.
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
							// 0���� �ϴ� ������
							// ����üũ�Ҷ� �����ؼ� üũ�ϱ� ����
						}
					}
					return; // Ž�� �ʿ���� ������ 0�� �������� �ʱ⶧��
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
