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
         * �̺�Ž���� �̿��ؼ� �ð��� ��������
         * �� ��� ������ �� �ִ� �ο��� ��� 
         * ���ϰ� �ʿ��� �ο��� ������ �� �ִ�
         * �ּ� ���� ���Ѵ�.
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
