import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Node>[] map = new ArrayList[N+1];
        for(int i = 1; i<N+1;i++ ) map[i] = new ArrayList<>();
        for(int i = 0; i < road.length;i++) {	
        	int a = road[i][0];
        	int b = road[i][1];
        	int dist = road[i][2];
        	map[a].add(new Node(b,dist));
        	map[b].add(new Node(a,dist));
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        int[] path = new int[N+1];
        Arrays.fill(path, 99999999);
        path[1] = 0;
        while(!queue.isEmpty()) {
        	Node n = queue.remove();
        	
        	for(Node adj : map[n.number]) {
        		int len = path[n.number]+adj.dist;
        		if(path[adj.number] > len) {
        			path[adj.number] = len;
        			queue.add(adj);
        		}
        	}
        }
        System.out.println(Arrays.toString(path));
        for(int i = 1; i < path.length;i++) {
        	if(path[i] <= K) answer++;
        }
        return answer;
    }
    static class Node{
    	int number, dist;
		public Node(int number, int dist) {
			super();
			this.number = number;
			this.dist = dist;
		}
    }
}