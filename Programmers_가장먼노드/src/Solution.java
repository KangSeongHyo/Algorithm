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
        * BFS�� �̿��� ���ͽ�Ʈ�� �����Ͽ�
        * ���� 0������ ������ �������� �ִܰ�θ�
        * ���Ѵ�. �̶� �ִ��� �Ǵ��Ͽ� �� ������
        * ����Ѵ�.
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
