import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int T = sc.nextInt();
		/******************************
         * 순열 문제, 재귀 방식으로 모든 순열에 
         * 대한 값을 구한다.
         * 
         * n = 5, 
         *  12345 1234X 123X5 12X45 12X4X 12XX5
         *   
         * 	t-> t-> t-> t-> t->
         *               -> f->
         *  	    t-> f-> t->  
         * 				 -> f->
         * 
         *******************************/
		for(int t = 1 ; t <= T; t++) {
			int n = sc.nextInt();
			int b = sc.nextInt();
			//int[] arr = new int[n];
			//List<Integer> arr = new ArrayList<>(); 
			  List<Integer> arr = new LinkedList<>(); 
			min = Integer.MAX_VALUE;
			for(int i = 0; i < n ; i++) {
				int ele = sc.nextInt();
				//arr[i] = ele;
				arr.add(ele);
			}		
			req(arr, b, n, 0, 0);
			System.out.println("#"+t+" "+min);
		}
		
	}
	
	static int min;
	public static void req(List<Integer> arr,int b,int n,int idx,int total) {
		if(total >= b) {
			min = Math.min(min, total-b);
			if(min == 0) return;
		}
		if(idx == n) return;
		
		req(arr, b, n, idx + 1, total+arr.get(idx));
		req(arr, b, n, idx + 1, total);
	}
	
}
