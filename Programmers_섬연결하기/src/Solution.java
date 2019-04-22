import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	static List<Node>[] map;
    public int solution(int n, int[][] costs) {
    	/***************************
		 * prim 알고리즘을 이용해서 MST를
		 * 구하고 그 가중치 총합을 출력한다.
		 ***************************/
        map = new ArrayList[n];
        for(int i = 0; i < n; i++)
        	map[i] = new ArrayList<>();
        for(int i = 0; i < costs.length; i++) {
        	int a = costs[i][0];
        	int b = costs[i][1];
        	int c = costs[i][2];
        	map[a].add(new Node(b, c));
        	map[b].add(new Node(a, c));
        }
        vistied = new boolean[n];
        dist = new int[n];
        prim();
        
        return Arrays.stream(dist).sum();
    }
    static int[] dist;
    static boolean vistied[]; 
    private static void prim() {    	
    	PriorityQueue<Node> pq = new PriorityQueue<>(Node::compare);
    	
    	Arrays.fill(dist, 99999);
    	dist[0] = 0;
    	pq.add(new Node(0, dist[0]));
    	while (!pq.isEmpty()) {
    		Node node = pq.remove();
    		if(vistied[node.vertax]) continue;
    		vistied[node.vertax] = true;
    		// 여기에 방문설정하는 이유는 양방향성 떄문에
    		// 왔던길 돌아가는 것을 방지하기 위함이다.
    		// 자신이 기준점이 되는 순간에 자신과 가장 가까운
    		// 거리를 알 수있기 때문에 더이상 방문할 필요가 없다.
    		for(Node adj : map[node.vertax]) {
    			if(!vistied[adj.vertax]) {
    				if(dist[adj.vertax] > adj.cost) {
    					pq.add(new Node(adj.vertax, adj.cost));
    					dist[adj.vertax] = adj.cost;
    				}
    			}
    		}
		}
	}
    static class Node{
    	int vertax,cost;
		public Node(int vertax, int cost) {
			super();
			this.vertax = vertax;
			this.cost = cost;
		}
		private static int compare(Node o1, Node o2) {
			return Integer.compare(o1.cost, o2.cost);
		}
    }
}