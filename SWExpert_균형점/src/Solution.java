import java.util.Scanner;

public class Solution {
	static double[] pairx;
	static double[] wei;
	static double[] answer;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1 ; t <= test; t++) {
			/******************************
	         * 이분탐색을 이용하여 좌표를 찾는다.
	         * 이때 좌우인력은 갯수만큼 플러스 된다.
	         *******************************/
			n = sc.nextInt();
			pairx = new double[n];
			wei = new double[n];
			answer = new double[n-1];
			for(int i = 0; i < n; i++) {
				pairx[i] = sc.nextDouble();
			}
			
			for(int i = 0; i < n; i++) {
				wei[i] = sc.nextDouble();
			}
			
			for(int i = 0; i < n-1; i++) {
				left_idx = i;
				min = Double.MAX_VALUE;
				count = 0;
				binary(pairx[i],pairx[i+1], i);
			}
			System.out.print("#"+t+" ");
			for(int i = 0; i < n-1; i++) {
				System.out.print(String.format("%.10f", answer[i])+" ");
			}
			System.out.println();
		}
	}
	static int left_idx;
	static double min;
	static int count;
	public static void binary(double start, double end,int idx) {
		count++;
		if(count > 100) {
			return;
		}// 실행 수
		if(start >= end) {
			return;
		}
		double mid = (start + end)/2f;
		double F_left = 0.0;
		double F_right = 0.0;
		
		for(int i = 0; i <= left_idx; i++) {
			F_left += wei[i]/Math.pow(Math.abs(pairx[i]-mid), 2);
		}
		for(int i = left_idx+1; i < n; i++) {
			F_right += wei[i]/Math.pow(Math.abs(pairx[i]-mid), 2);
		}
		
		if(min > Math.abs(F_left-F_right)) {
			answer[idx] = mid;
			min = Math.abs(F_left-F_right);
		}
		if(Math.abs(F_left-F_right) < 1e-13) {
			answer[idx] = mid;
            return;
        }
	    
		if(F_left < F_right) {
			binary(start, mid,idx);
		}else if(F_left > F_right) {
			binary(mid, end,idx);
		}
		
	}
}
