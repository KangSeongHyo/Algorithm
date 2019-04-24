import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,zero,mone,pone;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		/***************************
		 * 배열을 9등분 하면서 탐색한다.
		 * 예를들어(n기준) 27 -> 9 -> 3
		 * 하나의 숫자로 이루어저있는지 체크
		 * 이후에 맞으면 종료, 아니면 9등분
		 * 을 반복한다. 
		 ***************************/
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0, n);
		System.out.println(mone);
		System.out.println(zero);
		System.out.println(pone);
		
	}
	
	private static void solve(int x, int y, int n) {
		
		if(isPaper(x, y, n)) {
			if(map[x][y] == -1) {
				mone++;
			}else if(map[x][y] == 0) {
				zero++;
			}else {
				pone++;
			}
			return;
		}
		
		int div = n/3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				solve(x+i*div, y+j*div, div);
			}
		}
		
	}
	private static boolean isPaper(int x, int y, int n) {
		for(int i = x; i < x+n; i++) {
			for(int j = y; j < y+n; j++) {
				if(map[x][y] != map[i][j]) 
					return false;
			}
		}
		return true;
	}
}
