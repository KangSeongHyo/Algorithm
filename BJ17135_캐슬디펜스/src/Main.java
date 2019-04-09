import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n,m,d;
	static int[][] map,temp;
	static boolean[] arrow;
	static List<Pair> emen;
	static int res,total;
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n+1][m];
		temp = new int[n+1][m];
		arrow = new boolean[m];
		emen = new ArrayList<>();
		/******************************
		 * 궁수가 있을 수 있는 위치를 완전탐색하여
		 * 적을 죽일 수 있는 경우 중 최대를 구한다.
         *******************************/
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int elemnt= sc.nextInt();
				map[i][j] = elemnt; 
				temp[i][j] = elemnt;
				if(map[i][j] == elemnt) {
					emen.add(new Pair(i, j, -1));
					// 적 좌표 저장
				}
			}
		}
		res = 0;
		solve(0, 0);
		System.out.println(res);
	}
	private static void solve(int deep, int idx) {
		// 궁수의 위치 완전탐색   
		if(deep == 3) {
			clone(map, temp);
			attak();
			return;
		}
		
		for(int i = idx; i < m; i++) {
			if(!arrow[i]) {
				arrow[i] = true;
				solve(deep+1, i+1);
				arrow[i] = false;
			}
		}
	}
	private static void attak() {
		List<Pair> arrowlist = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			if(arrow[i])
				arrowlist.add(new Pair(n, i, 0));
		}
		
		int line = n;
		
		total = 0;
		
		while(line > 0) {
			
			Queue<Pair> dead = new LinkedList<>();
			
			for(Pair aw : arrowlist) {
				PriorityQueue<Pair> pq = new PriorityQueue<>(Pair::compare);
				aw.x = line;
				// 궁수 라인 당기기
				
				int min = Integer.MAX_VALUE;
				for(Pair tg: emen) {
					if(map[tg.x][tg.y] !=1) continue;
					int dist = Math.abs(aw.x-tg.x)+Math.abs(aw.y-tg.y);
						if(dist <= d && tg.x < aw.x && min>=dist) {
							min= Math.min(min, dist);
							pq.add(new Pair(tg.x, tg.y, dist));
						}
				}
				
				if(!pq.isEmpty())
					dead.add(pq.poll());
				// 가장 가깝고 왼쪽인 처음것
			}
			
			if(!dead.isEmpty()) {				
				dead.stream().filter(dd->map[dd.x][dd.y]==1)
							 .forEach(dd->{
								 map[dd.x][dd.y] = 0;
								 total++;
							 });
			}
			line--;
		}
		
		res = Math.max(res,total);
	}
	
	private static void clone(int[][] taget, int[][] origin) {
		for(int i = 0; i < n ; i++) {
			taget[i] = origin[i].clone();
		}
	}
	static class Pair{
		int x,y,dist;

		public Pair(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		private static int compare(Pair o1,Pair o2) {
			if(o1.dist != o2.dist)
				return Integer.compare(o1.dist, o2.dist);
			else
				return Integer.compare(o1.y, o2.y);
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", dist=" + dist + "]";
		}
	}
}
