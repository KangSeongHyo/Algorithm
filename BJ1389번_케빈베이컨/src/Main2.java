import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	static int n;
	static int m;
	static boolean visited[];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		//long start = System.currentTimeMillis();
		/******************************
         * 플로이드 워셜 알고리즘을 이용해서 
         * 각각의 최단거리를 구한 뒤
         * 최단거리의 합을 이용해서
         * 가장 최소가 되는 index를 구한다 
         *******************************/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n+1][n+1];
		for(int i = 1; i < n+1;i++) {
			Arrays.fill(arr[i], 999999);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			 arr[a][b] = 1;
			 arr[b][a] = 1;
		}
			
		for(int k = 1; k < n+1; k++) {
			for(int i = 1; i < n+1; i++) {
				for(int j = 1; j < n+1; j++) {
				   if(i==j) continue;
				   if(arr[i][j] > arr[i][k] + arr[k][j]) {
					   arr[i][j] = arr[i][k] + arr[k][j];
				   }
				}
			}
		}
		int idx = 0;
		for(int i = 1; i < n+1; i++) {
			int sum = 0;
			for(int j = 1; j < n+1; j++) {
				if(i == j) continue;
				sum += arr[i][j];
			}
			if(sum < min) {
				min = sum;
				idx = i;
			}
		}
		System.out.println(idx);
		//long end = System.currentTimeMillis();
		//System.out.println(end-start+"ms");
	}	
}
