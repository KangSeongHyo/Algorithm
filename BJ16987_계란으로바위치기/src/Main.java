import java.util.Scanner;

public class Main {
	static int n;
	static int[] dur;
	static int[] wei;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dur = new int[n];
		wei = new int[n];
		/******************************
         * 백트래킹을 이용해서 모든 경우를 구한다.
         * 이때 이미 깨진 경우와 쥔거 뺴고 다깨져 있는
         * 경우를 처리해서 깨진 계란의 최대값을
         * 구한다.
         *******************************/
		for(int i = 0; i < n; i++) {
				dur[i] = sc.nextInt();
				wei[i] = sc.nextInt();
		}
		solve(0);
		System.out.println(max);
	}
	static int max = 0;
	static int egg = 0;
	
	public static void solve(int hold) {
		if(hold == n) {
			max = Math.max(max, egg);
			return;
		}
		
		for(int target = 0; target < n; target++) {
			
			if(dur[hold] <= 0 || egg == n-1) {
				solve(hold+1);
				return;
			}
			
			if(dur[target] <= 0) continue;
			
			if(target == hold) continue;
			
			int target_dur = dur[target];
			int hold_dur = dur[hold];
			int egg_temp = egg;
			dur[target] -= wei[hold];
			dur[hold] -= wei[target];
			if(dur[target] <= 0) egg++;
			if(dur[hold] <= 0) egg++;
			solve(hold+1);
			
			dur[target] = target_dur;
			dur[hold] = hold_dur;
			egg = egg_temp;
		}
	}
		
}
