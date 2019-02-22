import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	 static String str;
	    static boolean[] visited;
	    static List<Integer> idx_list;
	    public static void main(String[] args) throws IOException {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder("");
	        /******************************
	         * BFS를 이용해서 그래프의 갈 수 있는 노드
	         * 들을 탐색하고 그에 따른 거리를 저장한다.
	         * 그리고 마지막이 되는 것은 가장 거리가
	         * 긴 것이므로 이를 이용해 최대 index를
	         * 구한다.
	         *******************************/
	        for (int t = 0; t < 10; t++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
	        	int len = Integer.parseInt(st.nextToken());
	        	int start = Integer.parseInt(st.nextToken());
	        	List<Integer>[] contact_list = new LinkedList[101];
	        	max = Integer.MIN_VALUE;
	        	for(int i = 1; i < 101 ; i++) {
	        		contact_list[i] = new LinkedList<>();
	        	}
	        	
	        	st = new StringTokenizer(br.readLine());
	        	
	        	while(st.hasMoreTokens()) {
	        		int x = Integer.parseInt(st.nextToken());
	        		int y = Integer.parseInt(st.nextToken());
	        		contact_list[x].add(y);
	        	}
	        	
	        	boolean[] visited = new boolean[101];
	        	dist = new int[101];
	        	max_list = new LinkedList<>();
	        	bfs(visited, contact_list, start);
	        	int res = max_list.stream().mapToInt(i->i).max().getAsInt();
	        	
	        	 sb.append("#"+(t+1)+" "+(res)+"\n");
	        }
	        System.out.println(sb.toString());
	    }
	    static int max;
	    static int[] dist;
	    static List<Integer> max_list;
	    public static void bfs(boolean[] visited, List<Integer>[] contact_list, int start) {
	    	
	    	Queue<Integer> queue = new LinkedList<>();
	    	
	    	queue.add(start);
	    	visited[start] = true;
	    	dist[start] = 1;
	    	while(!queue.isEmpty()) {
	    		int x = queue.poll();
	    		
	    		contact_list[x]
	    				.stream ()
	    				.filter (i->visited[i]==false)
	    				.forEach(i->{
	    					queue.add(i);
	    					dist[i] = dist[x] + 1;
	    					visited[i] = true;
	    					
	    					if( max == dist[i]) {
	    						max_list.add(i);
	    					}else if(max < dist[i]) { // 클경우 초기화
	    						max = dist[i];
	    						max_list.clear();
	    						max_list.add(i);
	    					}
	    			});
	    	}
	    }
	    
}
