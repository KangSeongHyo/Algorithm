import java.util.Scanner;

public class Solution {
	
	static int n;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		/******************************
         * 순열 & 재귀를 활용해 궁합이 맞지 않는 조건
         * 을 판단하여 해당되는 경우를 찾는다.
         * (비트마스크 형태)
         * 
         * ex) 1 2 3 일 경우
         *  모든 경우 조합
         * 	  0, 1, 2, 3, 12, 13, 23, 123
         * 
         *  true false로 표현하면
         *    fff,tff,ftf,fft ~~~
         * 
         *  궁합이 안 맞으면 하나는 true가 될 수 없음
         *    => 백트래킹을 하지 않는다.
         *    
         *   1 - 2 가 궁합이 아닌경우
         *     기존 순열
         *     tff -> ttf -> ttt, ttf
         *         -> tff -> tft, tff
         *     조건 순열
         *     tff -> tff -> tft, tff
         *   
         *   궁합이 아닌 경우에 대한 백트래킹이 
         *   발생하지 않는다.
         * 
         *******************************/
		
		for(int t = 0; t < T; t++) {
			cnt = 0;
			n = sc.nextInt();
			int m = sc.nextInt();
			visited = new boolean[n+1];
			boolean[][] material = new boolean[n+1][n+1]; 
			
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				material[a][b] = material[b][a] = true; 
			}
			cook(material, 1);
			System.out.println("#"+(t+1)+" "+cnt);
		}
		
	}
	static boolean visited[];
	static int cnt;
	public static void cook(boolean[][] material, int idx) {
		
		if(idx > n) {
			cnt++;
			//System.out.println(Arrays.toString(visited));
			return;
		}
		boolean flag = true;
		for(int i = 1; i < n+1; i++) { // 재료를 사용해도 되는지 체크
			if(material[idx][i] && visited[i]) {
				flag = false;
				break;
			}
		}
		
		if(flag) {   
			visited[idx] = true; // 재료 사용
			cook(material, idx+1);
			visited[idx] = false;
		}
		cook(material, idx+1);
	}
	
}
