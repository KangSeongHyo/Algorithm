import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			/************************
			 * 가로 세로 길이가 2가 되는
			 * 부분들을 지워나가는 방법으로
			 * 최대 콩 개수를 구한다.
			 ************************/
			int total = n*m;
			boolean visited[][] = new boolean[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(!visited[i][j]) {
						visited[i][j] = true;
						if(i+2<n&&!visited[i+2][j]) {
							visited[i+2][j] = true;
							total--;
						}
						if(j+2<m&&!visited[i][j+2]) {
							visited[i][j+2] = true;
							total --;
						}
					}
				}
			}
			System.out.println("#"+t+" "+total);
		}
	}
}
