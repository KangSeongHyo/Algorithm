import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
   static List<Integer>[] list;
   static int[] dist;
   static int max;
   public static int solution(int n, int[][] edge) {
	   /******************************
        * BFS를 이용해 다익스트라를 구성하여
        * 정점 0부터의 각각의 정점까지 최단경로를
        * 구한다. 이때 최댓값을 판단하여 그 갯수를
        * 출력한다.
        *******************************/
	    list = new ArrayList[n];
	    for(int i = 0; i < n; i++) list[i] = new ArrayList<>();
	    for(int i = 0; i < edge.length; i++) {
	    	list[edge[i][0]-1].add(edge[i][1]-1);
	    	list[edge[i][1]-1].add(edge[i][0]-1);
	    }
	    dist = new int[n];
	    Arrays.fill(dist, 9999);
	    path(n);
	    int cnt = 0;
	    for(int i = 0; i < dist.length; i++) {
	    	if(max == dist[i]) cnt++;
	    }
	    return cnt;
    }
   public static void path(int n) {
	   Queue<Integer> queue = new LinkedList<>();
	   queue.add(0);
	   dist[0] = 0;
	   while (!queue.isEmpty()) {
		   int vertex = queue.remove();
		   for(Integer i : list[vertex]) {
			   if(dist[i] > dist[vertex]+1 && dist[i] == 9999) {
				   dist[i] = dist[vertex]+1;
				   queue.add(i);
				   max = Math.max(max, dist[i]);
			   }
		   }
	   }
   }
}
