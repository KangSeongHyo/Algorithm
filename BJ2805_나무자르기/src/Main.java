import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		int max = 0;
		/****************************
		 * 높이를 기준으로 이분탐색을 하여
		 * 될수있는 경우 중 가장 최대 높이를
		 * 구하여 출력한다.
         ****************************/
		for(int i = 0; i < n ; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		
		int start = 0;
		int end = max;
		int ans = 0;
		while(start<end) {
			int mid = (start+end)/2;
			long total = 0;
			for(int i = 0; i < n; i++) {
				total+= arr[i]-mid>0?arr[i]-mid:0;
			}
			if(total > m) {
				ans = mid;
				start = mid+1;
			}else if(total < m){
				end = mid;
			}else {
				ans = mid;
				break;
			}
		}
		System.out.println(ans);
	}
}
