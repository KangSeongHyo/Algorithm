import java.util.Scanner;

public class Solution {
	  static int day;
	  static int month;
	  static int month_three;
	  static int year;
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int T = sc.nextInt();
	  /******************************
       * 재귀를 이용하여 모든 경우를 완전탐색하여
       * 최소 비용을 구한다.
       *******************************/
      for(int t = 1; t <= T; t++) {
    	  day = sc.nextInt();
    	  month = sc.nextInt();
    	  month_three = sc.nextInt();
    	  year = sc.nextInt();
    	  int[] plan = new int[12];
    	  min = Integer.MAX_VALUE;
    	  for(int i = 0; i < 12; i++) {
    		  plan[i] = sc.nextInt();
    	  }
    	  solve(plan, 0, 0);
    	  min = Math.min(year, min);
    	  System.out.println("#"+t+" "+min);
      }
  }
  static int min;
  public static void solve(int[] plan, int deep, int total) {
	  if(deep >= 12) {
		  min = Math.min(total, min);
		  return;
	  }
	  
	  if(plan[deep] == 0) solve(plan, deep+1, total);
	  
	  solve(plan, deep+1, total + plan[deep]*day);
	  solve(plan, deep+1, total + month);
	  solve(plan, deep+3, total + month_three);
		  
  }
}
