import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int k;
	static int[][] map;
	static int[] kyung = new int[20];
	static int[] minho = new int[20];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    n = sc.nextInt(); //손동작수
		k = sc.nextInt(); // 승수
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < 20; i++) {
			kyung[i] = sc.nextInt()-1;
		}
		for(int i = 0; i < 20; i++) {
			minho[i] = sc.nextInt()-1;
		}
		visited = new boolean[n];
		permu("", 0);
		System.out.println(ans);
	}
	static int ans = 0;
	static boolean[] visited;
	public static void permu(String order,int deep) {
		if(deep == n) {
			ans = Math.max(ans, solve(order));
			return;
		}
		
		for(int i = 0; i < n; i ++) {
			if(!visited[i] && ans == 0) {
				visited[i] = true;
				permu(order+i,deep+1);
				visited[i] = false;
			}
		}
	}
	public static int solve(String order) {
		
		char[] jiwu = order.toCharArray();
		final int jiwu_order = 0;
		final int kyung_order = 1;
		final int minho_order = 2;
		int[] winner = {0,0,0};
		int cnt = 0;
		int cnt_kyung = 0;
		int cnt_minho = 0;
		int round = 0;
		Queue<Integer> order_match = new LinkedList<>();
		order_match.add(jiwu_order);
		order_match.add(kyung_order);
		order_match.add(minho_order);
		
		while (round < 20) {
			int pre = order_match.poll();
			int post = order_match.poll();
			int wait = order_match.poll();
			
			int res = 0;
			
			if(jiwu_order== pre && kyung_order == post) {
				res = map[jiwu[cnt++]-'0'][kyung[cnt_kyung++]];
			}else if(jiwu_order == pre && minho_order == post) {
				res = map[jiwu[cnt++]-'0'][minho[cnt_minho++]];
			}else if(kyung_order == pre && jiwu_order == post){
				res = map[kyung[cnt_kyung++]][jiwu[cnt++]-'0'];
			}else if(kyung_order == pre && minho_order == post) {
				res = map[kyung[cnt_kyung++]][minho[cnt_minho++]];
			}else if(minho_order == pre && jiwu_order == post) {
				res = map[minho[cnt_minho++]][jiwu[cnt++]-'0'];
			}else if(minho_order == pre && kyung_order == post) {
				res = map[minho[cnt_minho++]][kyung[cnt_kyung++]];
			}
			
			if(res == 1) {
				if(pre < post) res = 0;
				else res = 2;
			}
			
			if(res == 2) {
				winner[pre]++;
				order_match.add(pre);
				order_match.add(wait);
				order_match.add(post);
			}else if(res == 0) {
				winner[post]++;
				order_match.add(post);
				order_match.add(wait);
				order_match.add(pre);
			}
			
			/*if(order.equals("04123")) {
				System.out.println(round+"라운드 "+" 상대 "+pre+" vs "+post +" 결과 : "+res + " 지우 : "+winner[0]+" 명희 : "+winner[1]+" 민호 : "+winner[2]);
			}*/
			
			if(winner[0] == k || winner[1] == k || winner[2] == k) {
				if(winner[0] == k ) {
					return 1;
				}
				else return 0;
			}
			
			if(!(cnt < n)) return 0;
			round++;
		}
		return 0;
	}
}
