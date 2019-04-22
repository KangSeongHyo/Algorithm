import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int start = 1,end=k+1;
		int ans = 0;
		/***************************
		 * 이분탐색을 이용해 K번째수를 구한다.
		 * 이때 중첩되는 갯수가 발생하기 때문에
		 * i*j의 배수를 이용하여 갯수를 판단한
		 * 이분탐색으로 원하는 원소를 찾는다.
		 ***************************/
		while (start<end) {
			// start < end 이므로 end까지 돌려면 +1을 해야한다.
			int mid = (start+end)/2;
			int count = 0;
			for(int i = 1; i <= n; i++) {
				 count+=Math.min(mid/i,n);// n보다 큰수는 있을수 없다.
			}
			if(count >= k) {
				ans = mid;
				end = mid;
			}else {
				start = mid+1;
			}
		}
		System.out.println(ans);
	}
}
