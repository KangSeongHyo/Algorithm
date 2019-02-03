import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int n;
	static int m;
	static char[][] arr;
	static boolean wall[][];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		wall = new boolean[n][m];
		arr = new char[n][m];
		Queue<Pair> coinsq = new LinkedList<>();
		/******************************
         *BFS를 활용해서 모든 경우의 수를 count가
         *10까지만 확인하여 최솟값을 구한다.
         *이때 Queue에 동전의 좌표를 넣어주고
         *제거하고 옮긴 위치를 다시 넣어주는 방식으로
         *진행된다.
         *******************************/
		for(int i = 0; i < n ; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == '#') wall[i][j] = true;
				if(arr[i][j] == 'o') coinsq.add(new Pair(i, j,0));
			}
		}
		
		int[] nx = {0,0,1,-1};
		int[] ny = {1,-1,0,0};
		
			while(true) {
				if(coinsq.size()<2)break;
				Pair coin1 = coinsq.remove();
				Pair coin2 = coinsq.remove();
				int count1 = coin1.count;
				int count2 = coin2.count;
				if(count1 >=10 || count2 >=10) break;
				
				for(int i = 0; i < 4; i++) {
					int	coin1x = nx[i] + coin1.x;
					int coin1y = ny[i] + coin1.y;
					int	coin2x = nx[i] + coin2.x;
					int coin2y = ny[i] + coin2.y;
					
					if(coin1x < 0 || coin1x >= n || coin1y < 0 || coin1y >= m) {
						if(coin2x >= 0 && coin2x < n && coin2y >= 0 && coin2y < m ) {
							min = Math.min(count1, min);
						}
						continue;
					}
					
					if(coin2x < 0 || coin2x >= n || coin2y < 0 || coin2y >= m) {
						if(coin1x >= 0 && coin1x < n && coin1y >= 0 && coin1y < m ) {
							min = Math.min(count2, min);
						}
						continue;
					}
					
					 
					if(!wall[coin1x][coin1y]) {
						coinsq.add(new Pair(coin1x, coin1y,count1+1));
					}else {
						coinsq.add(new Pair(coin1.x, coin1.y,count1+1));
					}
					
					if(!wall[coin2x][coin2y]) {
						coinsq.add(new Pair(coin2x, coin2y,count2+1));
					}else {
						coinsq.add(new Pair(coin2.x, coin2.y,count2+1));
					}
				 }
			}
			
		if(min >= 10 || min == Integer.MIN_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min+1); // +1이 min값 찾기 아래에 있으므로 +1을 더해준다.
		}
	}
}
class Pair{
	int x ;
	int y ;
	int count;
	public Pair(int x, int y,int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}