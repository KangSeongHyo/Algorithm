import java.util.Scanner;

public class Solution {
	static int UP =1;
	static int DOWN =2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		/***************************
		 * 가장 높은산을 기준으로 올라오는산
		 * 과 내려가는 산을 곱하면 원하는 
		 * 우뚝선산의 경우의 수를 구할 수 있다.
		 ***************************/
		for(int c=1; c<=t; c++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			
			int up,down,total;
			up=down=total=0;
			int flag = UP;
			
			for(int i = 0; i < n-1; i++) {
				if(flag == UP) {
					if(arr[i]<arr[i+1]) {
						up++;
					}else {
						down++;
						flag = DOWN;
					}
				}else {
					if(arr[i]>arr[i+1]) {
						down++;
					}else {
						total+= up * down;
						up = 1;
						down = 0;
						flag = UP;
					}
				}
			}
			total+= up *down; // 내려오고 끝나는 경우 처리
			System.out.println("#"+c+" "+total);
		}
	}
}
