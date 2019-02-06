import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] friend_list;
	static int n;
	static int m;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		lvl = new int[n+1];
		Arrays.fill(lvl, 1);
		friend_list = new LinkedList[n+1];
		for(int i = 0; i < n+1; i++) friend_list[i] = new LinkedList<>();
		/******************************
         * BFS를 이용해서 탐색할때 마다 단계를
         * 올려주면서 lvl 값을 구한 뒤 리스트에
         * 저장하고 Sort해서 가장 최소가 되는
         * index를 구한다 
         *******************************/
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!friend_list[a].contains(b)&&!friend_list[b].contains(a)) {
				friend_list[a].add(b);
				friend_list[b].add(a);
			}
		}
		
		List<People> ans = new LinkedList<>();
		
		for(int i = 1; i < n+1;i++) {
			sum = 0;
			
			for(int j = 1; j < n+1; j++) {
				if(i==j) continue;
				visited = new boolean[n+1];
				Arrays.fill(lvl, 1);
				bfs(i, j);
			}
			ans.add(new People(i, sum));
		}
		Collections.sort(ans);
		System.out.println(ans.get(0).num);
		long end = System.currentTimeMillis();
		System.out.println(end-start+"ms");
	}
	
	static int lvl[];
	static int sum = 0;
	public static void bfs(int target, int friend) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(target);
		
		while(!queue.isEmpty()) {
			int idx = queue.remove();
			visited[idx] = true;
			for(Integer in : friend_list[idx]) {
				if(!visited[in]) {
					if(in == friend) {
						sum += lvl[idx];
						return;
					}else {
						queue.add(in);
						lvl[in] = lvl[idx]+1;
						//System.out.println(lvl[in]);
					}
				}
			}
		}
		
	}
	static class People implements Comparable<People>{
		int num;
		int sum;
		
		public People(int num, int sum) {
			super();
			this.num = num;
			this.sum = sum;
		}

		@Override
		public int compareTo(People other) {
			if(sum == other.sum) {
				return num - other.num;
			}
			return sum - other.sum;
		}
	}
}
