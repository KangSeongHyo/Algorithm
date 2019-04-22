import java.util.Scanner;

public class Main {
	static int n,m;
	static int[] parent,level;
	public static void main(String[] args) {
		/***************************
		 * UnionFind�� �̿��ؼ� ������ ����
		 * ��� �ش� ��ε��� Union ��Ű��
		 * ��Ʈ��带 �����ش�. �� �� ��ο�
		 * ���� ��Ʈ�� ��ġ�ϸ� YES�� ����Ѵ�.
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
		//find(parent[v]�� ���� �ʴ� ������ �ѹ� find�� 
		// �߻������� ó�� ���¸� �����ϱ� �����̴�(root���� ����)
		// ���������μ� �������� ȣ���� �ʿ��Ұ�� O(1)�� ���⵵�� ������.
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
		// ũ�Ⱑ ������� �ٿ����� 1���� �þ��.
		return false;
	}
}
