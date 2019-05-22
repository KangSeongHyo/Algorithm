import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] arr = new int[n+1][m+1];
		/******************************
         * 2���� �迭�� �κ����� ���Ͽ� 
         * ���ϴ� ���簢���� ���� ���̸� ���Ѵ�. 
         *******************************/
		for(int i = 1; i < n+1; i++)
			for(int j = 1; j < m+1; j++)
				arr[i][j] = sc.nextInt();
		
		for(int i = 1; i < n+1; i++)
			for(int j = 2; j < m+1; j++)
				arr[i][j] += arr[i][j-1];
		
		for(int i = 1; i < m+1; i++)
			for(int j = 2; j < n+1; j++)
				arr[j][i] += arr[j-1][i];
		
		int q = sc.nextInt();
		
		while(q-->0) {
			int i = sc.nextInt(), j = sc.nextInt(),x = sc.nextInt(),y = sc.nextInt();
			System.out.println(arr[x][y]- arr[x][j-1]-arr[i-1][y]+arr[i-1][j-1]);
		}
	}
}
