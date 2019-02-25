import java.util.Scanner;

public class Solution {
	
	static int n;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		/******************************
         * ���� & ��͸� Ȱ���� ������ ���� �ʴ� ����
         * �� �Ǵ��Ͽ� �ش�Ǵ� ��츦 ã�´�.
         * (��Ʈ����ũ ����)
         * 
         * ex) 1 2 3 �� ���
         *  ��� ��� ����
         * 	  0, 1, 2, 3, 12, 13, 23, 123
         * 
         *  true false�� ǥ���ϸ�
         *    fff,tff,ftf,fft ~~~
         * 
         *  ������ �� ������ �ϳ��� true�� �� �� ����
         *    => ��Ʈ��ŷ�� ���� �ʴ´�.
         *    
         *   1 - 2 �� ������ �ƴѰ��
         *     ���� ����
         *     tff -> ttf -> ttt, ttf
         *         -> tff -> tft, tff
         *     ���� ����
         *     tff -> tff -> tft, tff
         *   
         *   ������ �ƴ� ��쿡 ���� ��Ʈ��ŷ�� 
         *   �߻����� �ʴ´�.
         * 
         *******************************/
		
		for(int t = 0; t < T; t++) {
			cnt = 0;
			n = sc.nextInt();
			int m = sc.nextInt();
			visited = new boolean[n+1];
			boolean[][] material = new boolean[n+1][n+1]; 
			
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				material[a][b] = material[b][a] = true; 
			}
			cook(material, 1);
			System.out.println("#"+(t+1)+" "+cnt);
		}
		
	}
	static boolean visited[];
	static int cnt;
	public static void cook(boolean[][] material, int idx) {
		
		if(idx > n) {
			cnt++;
			//System.out.println(Arrays.toString(visited));
			return;
		}
		boolean flag = true;
		for(int i = 1; i < n+1; i++) { // ��Ḧ ����ص� �Ǵ��� üũ
			if(material[idx][i] && visited[i]) {
				flag = false;
				break;
			}
		}
		
		if(flag) {   
			visited[idx] = true; // ��� ���
			cook(material, idx+1);
			visited[idx] = false;
		}
		cook(material, idx+1);
	}
	
}
