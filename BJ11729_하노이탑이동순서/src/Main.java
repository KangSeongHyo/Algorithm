import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder("");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/******************************
         * ��͸� �̿��Ͽ� n-1 �������� 
         * 2�� �ܻ����� �ű��
         * n��°�� 3�� �ܻ����� �ű���
         * �ٽ� 2�� �ܻ󿡼� 3���ܻ����� �ű��
         * ������ ���Ѵ�.
         *******************************/
		int n = sc.nextInt();
		System.out.println((1<<n)-1);
		move(n, 1, 3);
		System.out.println(sb);
	}
	private static void move(int n, int a, int b) {
		if(n==0) return;
		move(n-1, a, 6-a-b);
		sb.append(a+" "+b).append("\n");
		move(n-1, 6-a-b, b);
	}
}
