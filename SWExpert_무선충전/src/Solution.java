import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Math.*;

public class Solution {
	static int[][] arr;
	static int[] move_a;
	static int[] move_b;
	static int m,a;
	static Pair[] user;
	static Pair[] bc;
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			/******************************
			 * �� ��ġ���� 2���� ����ڰ� bc�� ����ϴ�
			 * ��� ���(�Ⱦ��°͵� ����)�� DFS�� �̿��Ͽ�
			 * Ž���Ѵ�. �̶� ���ÿ� ����ϴ� ����
			 * ������ ������ ����Ͽ� ó���Ͽ� �ִ��D��
			 * ã�Ƽ� �� �ð����� ���ؼ� �ִ��� ���Ѵ�.
	         *******************************/
			m = sc.nextInt();// �̵��ð�
			a = sc.nextInt(); // bc ����
			user = new Pair[2];
			bc = new Pair[a]; 
			arr = new int[11][11];
			move_a = new int[m];
			move_b = new int[m];
			
			for(int i = 0; i < m; i++) {
				move_a[i] = sc.nextInt();
			}
			for(int i = 0; i < m; i++) {
				move_b[i] = sc.nextInt();
			}
			
			for(int i = 0; i < a ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt(); // ��������
				int p = sc.nextInt(); // ����
				bc[i] = new Pair(x, y, c, p);
			}
			user[0]= new Pair(1, 1, 0, 0);
			user[1]= new Pair(10, 10, 0, 0);
			
			System.out.println("#"+t+" "+solve());
		}
		
	}
	public static int solve() {
		int time = 0;
		int total = 0;
		int end = m;
		while(end-->=0) {
			max = 0;
			used_bc= new int[a];
			charge(0, 0);
			total += max;
			//System.out.println(max+" ��������  "+time+"��");
			if(time > m-1) break;
			user[0].x += dx[move_a[time]];
			user[0].y += dy[move_a[time]];
			user[1].x += dx[move_b[time]];
			user[1].y += dy[move_b[time]];
			
			time++;
		}
		return total;
	}
	static int[] used_bc;
	static int max;
	private static void charge(int unum,int sum) {

		if(unum == 2) {
			for(int i = 0; i < a; i++) {
				if(used_bc[i]==2) sum= sum/2;
			}
			//System.out.println(sum+" ��������");			
			max = Math.max(sum, max);
			return;
		}
		for(int i = 0; i < a; i++) {
			//System.out.println("user number : "+unum+" bc number : "+i);
			if(isRange(bc[i], user[unum])) {
				used_bc[i]++;
				charge(unum+1, sum+bc[i].p);
				used_bc[i]--;
			}else {
				charge(unum+1, sum);
			}
		}
	}
	private static boolean isRange(Pair bc,Pair user) {
		int dist = Math.abs(bc.x-user.x)+Math.abs(bc.y-user.y);
		//System.out.println("user : "+user);
		//System.out.println("bc : "+bc);
		if(dist <= bc.c) return true;
		return false;
	}
	
	static class Pair{
		int x,y,c,p;

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}

		public Pair(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
}
