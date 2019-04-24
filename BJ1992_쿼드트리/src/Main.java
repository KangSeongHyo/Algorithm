import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		/***************************
		 * �迭�� 4��� �ϸ鼭 Ž���Ѵ�.
		 * �ϳ��� ���ڷ� �̷�����ִ��� üũ
		 * �ƴϸ� �����ϴ� ������� ���� ���Ѵ�.
		 ***************************/
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
		  char[] temp = br.readLine().toCharArray();
		  for(int j = 0; j < temp.length; j++) {
			  map[i][j] = temp[j] - '0';
		  }
		}
		solve(0, 0, n);
		System.out.println(res);
	}
	static String res="";
	private static void solve(int x, int y, int n) {
		
		if(isSame(x, y, n)) {
			res+=map[x][y];
			return;
		}else {
			res+="(";
		}
		
		int div = n/2;
		
		for(int i = 0; i < 2; i++) {
		  for(int j = 0; j < 2; j++) {
			  solve(x+i*div, y+j*div, div);
		   }
		}
		res+=")";
	}
	private static boolean isSame(int x, int y, int n) {
		for(int i = x; i < x + n; i++) {
		  for(int j = y; j < y + n; j++) {
			  if(map[i][j] != map[x][y]) return false;
		  }
		}
		return true;
	}
	
}
