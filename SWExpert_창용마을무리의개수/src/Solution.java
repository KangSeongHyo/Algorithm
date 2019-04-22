import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int[] parent,level;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1; t<=test; t++) {
			/***************************
			 * UnionFind를 이용해 친구의 친구들을
			 * 모두 연결하여 무리의 개수를 구한다.
			 ***************************/
			int n = sc.nextInt();
			int m = sc.nextInt();
			parent = new int[n];
			level = new int[n];
			for(int i = 0; i < n; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			
			for(int i = 0; i < m; i++) {
				union(sc.nextInt()-1, sc.nextInt()-1);
			}
		 Set<Integer> set = new HashSet<>();
		 for(int i = 0; i < n; i++) {
			 set.add(find(i));
		 }
			
		System.out.println("#"+t+" "+set.size());
		}
	}
	
	private static int find(int v) {
		if(v == parent[v]) return v;
		else return parent[v] = find(parent[v]);
	}
	private static void union(int i,int j) {
		int iroot = find(i);
		int jroot = find(j);
		
		if(iroot == jroot) return;
		
		if(level[iroot]<level[jroot]) {
			int temp = iroot;
			iroot = jroot;
			jroot = temp;
		}
		parent[jroot] = iroot;
		
		if(level[iroot] == level[jroot]) {
			level[iroot]++;
		}
	}
}
