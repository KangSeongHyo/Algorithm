import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int n;
	static List<Pair> plist;
	static List<Pair> slist;
	static int[] time = new int[2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			/******************************
	         * 비트마스크를 통해 모든 경우에 대해
	         * 완전탐색한다. 이때 Queue를 이용해서
	         * 최대 3명이 될때 다음 들어오는 사람과
	         * 처음 사람을 비교해서 뒷사람의 내려오는 
	         * 시간을 구한다. 그리고 두 계단 중에
	         * 최대시간을 구하고 이것이 최소가 되는
	         * 시간을 출력한다.
	         *******************************/
			n = sc.nextInt();
			plist = new ArrayList<>();
			slist = new ArrayList<>();
			int cnt = 0;
			for(int i = 0 ; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int element = sc.nextInt();
					if(element == 1) {
						plist.add(new Pair(i, j));
					}else if(element > 1) {
						time[cnt++] = element;
						slist.add(new Pair(i, j));
					}
				}
			}
			res = Integer.MAX_VALUE;
			solve();
			System.out.println("#"+t+" "+res);
		}
	}
	
	public static void solve() {
		
		for(int i = 0; i < 1<<plist.size(); i++) {
			
			step(i);
		}
	}
	
	public static void step(int bit) {
		//System.out.println(bit);
		PriorityQueue<Integer> pq1= new PriorityQueue<>(Integer::compareTo);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Integer::compareTo);
 		Pair step1 = slist.get(0);
 		Pair step2 = slist.get(1);
 		
		for(int i = 1,u=0; i < 1<<plist.size(); i= i<<1,u++) {
			//System.out.println(u);
			int d = 0;
			Pair person = plist.get(u);
			if((bit & i) == i) {
				d = Math.abs(step1.x-person.x)+Math.abs(step1.y - person.y);
				pq1.add(d+1);
				//System.out.println(step1.toString()+" "+person.toString()+" "+d);
			}else {
				d = Math.abs(step2.x-person.x)+Math.abs(step2.y - person.y);
				pq2.add(d+1);
				//System.out.println(step2.toString()+" "+person.toString()+" "+d);
			}
		}
		calc(pq1, pq2);
	}
	static int res;
	public static void calc(PriorityQueue<Integer> pq1,PriorityQueue<Integer> pq2) {
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();
		if(!pq1.isEmpty())
			queue1.add(pq1.poll());
		if(!pq2.isEmpty())	
			queue2.add(pq2.poll());
		
		while (!pq1.isEmpty()) {
			if(queue1.size() == 3) {
				int t = queue1.poll();
				int wait = pq1.poll();
				
				if((t+time[0])<wait) {
					queue1.add(wait);
				}else {
					queue1.add(t+time[0]);
				}
			}else {
				queue1.add(pq1.poll());
			}
		}
		
		while (!pq2.isEmpty()) {
			if(queue2.size() == 3) {
				int t = queue2.poll();
				int wait = pq2.poll();
				if((t+time[1])<wait) {
					queue2.add(wait);
				}else {
					queue2.add(t+time[1]);
				}
			}else {
				queue2.add(pq2.poll());
			}
		}
		int t1=0,t2=0;
		
		while(!queue1.isEmpty()) {
			t1 = queue1.poll();
		}
		
		while(!queue2.isEmpty()){
			t2 = queue2.poll();
		}
		t1 += time[0];
		t2 += time[1];
		res = Math.min(res, Math.max(t1, t2));
	}
	
	static class Pair{
		
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
