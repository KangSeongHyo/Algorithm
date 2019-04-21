import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		/***************************
		 * ���� ǰ�� ���� �����ؼ� ��������
		 * ���ϰ� �־��� ������ ���� ��������
		 * ����Ѵ�.
		 ***************************/
		for(int t=1; t<=test; t++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			int[][] cowsum = new int[n+1][4]; 
			for(int i = 1; i <= n; i++) {
				int a = sc.nextInt();
				for(int j = 1; j < 4; j++) {
					cowsum[i][j] = cowsum[i-1][j];
				}
				cowsum[i][a]++;
			}
			System.out.println("#"+t);
			while(q-->0) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				System.out.print(cowsum[r][1]-cowsum[l-1][1]+" ");
				System.out.print(cowsum[r][2]-cowsum[l-1][2]+" ");
				System.out.println(cowsum[r][3]-cowsum[l-1][3]);
			}
		}
	}
}
