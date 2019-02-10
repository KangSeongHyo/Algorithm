import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] apple;
	static int dir;
	static Deque<Pair> snake;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		apple = new int[n+1][n+1];
		 /******************************
	     * Deque를 이용해서 이동할때 head를 늘려주고 
	     * 사과가 없으면 꼬리를 제거한다.
	     * 이때 부딛히는 경우는 이동한 순간의 head를
	     * Deque 있는 위치들과 비교해서 판단한다.
	     * 방향 명령이 끝난 경우는 그 방향으로 
	     * 끝날때까지 시간이 진행된다.
         ******************************/
		
		StringTokenizer st;
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			apple[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		int l = Integer.parseInt(br.readLine());
		List<String> list = new LinkedList<>();
		snake = new LinkedList<>();
		
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(st.nextToken());
			list.add(st.nextToken());
		}
		list.add("F");
		snake.add(new Pair(1, 1));
		dir = 0;// 0 오른쪽 1 아래 2 왼쪽 3 위
		int cnt = 0;
		for(String str : list) {
			if(str.equals("D") || str.equals("L")) {
				dir = str.equals("D")?dir+1:dir-1;
				if(dir < 0) {
					dir = 3;
				}else if(dir > 3) {
					dir = 0;
				}
				
			}else {
				int time;
				if(str.equals("F")) {
					time = 101;
				}else {
					time = Integer.parseInt(str);
				}
				Pair head = snake.getLast();
				int x = head.x;
				int y = head.y;
				//System.out.println(time + "초  // " + dir +" 방향");
				for(int i = cnt; i < time; i++) {
					
					switch (dir) {
						case 0:
							y = y + 1;
							if(y>n) { System.out.println(cnt+1); return; }
							break;
						case 1:
							x = x + 1;
							if(x>n) { System.out.println(cnt+1); return; }
							break;
						case 2:
							y = y - 1;
							if(y<=0) { System.out.println(cnt+1); return; }
							break;
						default:
							x = x - 1;
							if(x<=0) { System.out.println(cnt+1); return; }
							break;
					}
					
					//System.out.println("머리"+x+":"+y+" "+i+"초경과");
					//snake.stream().forEach(sl->System.out.print(sl.x+":"+sl.y+" "));
					//System.out.println();
					if(check(x, y)) { System.out.println(cnt+1); return; }
					snake.addLast(new Pair(x, y));
					if(apple[x][y] == 0) {
						snake.poll();
					}else {
						apple[x][y] = 0;
					}
					
					cnt ++;
					//System.out.println(x+" : " + y + " : " + cnt +"초 경과 " + snake.getFirst().x+"-"+snake.getFirst().y);
				}
			}
		}
		System.out.println(cnt-1);
	}
	static boolean check(int i, int j) {
		for(Pair p : snake) {
			if(i == p.x && j == p.y) return true;
		}
		return false;
	}
	
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
		
}
