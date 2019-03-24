import java.util.Scanner;

public class Solution {
	static long[] rooms;
	static long max;
	static long n ;
	static long m;
	static long min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/******************************
         * 이분탐색을 이용해서 시간을 기준으로
         * 각 방당 수용할 수 있는 인원을 모두 
         * 구하고 필요한 인원을 수용할 수 있는
         * 최소 값을 구한다.
         *******************************/
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			max = -1;
			rooms = new long[(int)(n)];
			for(int i = 0; i < n; i++) {
				rooms[i] = sc.nextInt();
				max = Math.max(max, rooms[i]);
			}
			long start = 0;
			long end = max * m;
			min = end;
			
			binary(start, end);
			System.out.println("#"+t+" "+min);
		}
	}
	
	public static void binary(long start, long end) {
		if(start>=end) return;
		long mid = (start + end)/2;
		long capacity = 0;
		
		for(int i = 0; i < n ; i++) {
			capacity += mid/rooms[i];
		}
		if(capacity < m) {
			binary(mid+1, end);
		}else {
			min = Math.min(min, mid);
			binary(start, mid);
		}
	}
}
