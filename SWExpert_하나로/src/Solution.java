import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;
import static java.lang.Math.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		/******************************
         * bfs를 이용하여 가중치를 비교하여
         * 더 최단거리의 가중치 일 경우
         * 값을 바꿔주는 Prim 알고리즘을
         * 이용하여 최소 스패닝 트리를 구한다.
         *******************************/
		for(int t = 1; t <= T ; t++) {
			
			int n = sc.nextInt();

			List<Integer> list = new LinkedList<>();
			int arr[][] = new int[n][n];
			Node[] nodes = new Node[n];
			
			for(int i = 0; i < n*2; i++) {
				int a = sc.nextInt();
				list.add(a);
			}
			
			for(int i = 0; i < n; i++) {
				nodes[i] = new Node(list.get(i),list.get(i+n));
			}
			List<Edge>[] map = new ArrayList[n];			
			IntStream.range(0, n).forEach(i->map[i]=new ArrayList<>());
			double e = sc.nextDouble();
			dist = new double[n];
			visited = new boolean[n];
			Arrays.fill(dist, Double.MAX_VALUE);
			 
			for(int i = 0; i < n; i++) {
				Node a = nodes[i];
				for(int j=0; j < n; j++) {
					if(i==j) continue;
					Node b = nodes[j];
					double dx = pow(abs(a.x-b.x),2);
					double dy = pow(abs(a.y-b.y),2);
					double len = sqrt(dx+dy);
					double w = e*pow(len,2);
					map[i].add(new Edge(j, w));
				}
			}
			
			dist[0] = 0;
			prim(map);
			
			 double ans = 0;
			 
		        for(int i = 0; i < n ; i++) {
		            ans += dist[i];
		        }
		        System.out.println("#"+t+" "+round(ans));
		}
	}
	static double dist[];
	static boolean visited[];
	public static void prim(List<Edge>[] map) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.w, o2.w);
			}
		});
		
		pq.add(new Edge(0, dist[0]));
		
		while (!pq.isEmpty()) {
			Edge eg = pq.poll();
			int v = eg.y;
			
			if(visited[v])continue;
			visited[v] = true;
			
			for(Edge e : map[v]) {
                if(!visited[e.y]) {
                    int destination = e.y;
                    double weight = e.w;
                    if(weight < dist[destination]) {
                        dist[destination] = weight;
                        pq.add(new Edge(destination, dist[destination]));
                    }
                }
            }
			
		}
		
	}
	
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static class Edge{
		int y;
		double w;
		public Edge(int y, double w) {
			super();
			this.y = y;
			this.w = w;
		}
	
	}
}
