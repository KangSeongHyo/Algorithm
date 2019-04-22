import java.util.Scanner;

public class Main {
	static int n,m;
	static int[] parent,level;
	public static void main(String[] args) {
		/***************************
		 * UnionFind를 이용해서 연결이 있을
		 * 경우 해당 경로들을 Union 시키고
		 * 루트노드를 맞춰준다. 그 후 경로에
		 * 대해 루트가 일치하면 YES를 출력한다.
		 ***************************/
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		parent = new int[n];
		level = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			level[i] = 1;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				if(temp!= 0) {
						union(i, j);
				}
			}
		}
		int prev = sc.nextInt()-1;
		for(int i = 1; i < m; i++ ) {
			int next = sc.nextInt()-1;
			if(!union(prev, next)) {
				System.out.println("NO");
				return;
			}
			prev = next;
		}
		System.out.println("YES");
	}
	private static int find(int v) {
		if(v == parent[v]) return v;
		else return parent[v] = find(parent[v]);
		//find(parent[v]만 하지 않는 이유는 한번 find가 
		// 발생했을때 처리 상태를 누적하기 위함이다(root노드는 같다)
		// 누적함으로서 다음번에 호출이 필요할경우 O(1)의 복잡도를 가진다.
	}
	private static boolean union(int i, int j) {
		int iroot = find(i);
		int jroot = find(j);
		
		if(iroot == jroot) return true;
		
		if(level[iroot] < level[jroot]) {
			int temp = iroot;
			iroot = jroot;
			jroot = temp;
		}
		parent[jroot] = iroot;
		
		if (level[iroot] == level[jroot]) level[iroot]++;
		// 크기가 같은경우 붙였을때 1깊이 늘어난다.
		return false;
	}
}
