import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections; 
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		visited = new boolean[n][m];
		/******************************
         * 먼저 좌표평면을 배열형태로 바꾼 후 
         * 사각형의 영역만큼 1로 표시하고 
         * DFS 탐색을 통해서 영역의 크기와
         * 갯수를 구한다.
         *******************************/
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int u = x1 ; u < x2; u++) {
				for(int v = y1; v < y2; v++) {
					arr[u][v] = 1;
				}
			}
		}
		//System.out.println(Arrays.deepToString(arr));
		int count = 0;
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && arr[i][j] != 1) {
					dfs(arr, i, j);
					count++;
					list.add(breath+1);
					breath = 0;
				}
			}
		}
		
		System.out.println(count);
		Collections.sort(list);
		for(Integer in : list) System.out.print(in+" ");
		
	}
	static int breath = 0;
	public static void dfs(int[][] arr,int x, int y) {
		visited[x][y] = true;
		int[] nx = {0,0,1,-1};
		int[] ny = {1,-1,0,0};
		
		for(int i = 0; i < 4; i++) {
			
			int dx = x + nx[i];
			int dy = y + ny[i];
			
			if(dx >= 0 && dy >=0 && dx < n && dy < m && arr[dx][dy] != 1 && !visited[dx][dy] ) {
				dfs(arr, dx, dy);
				breath ++;
			}
		}
	}
	
}
