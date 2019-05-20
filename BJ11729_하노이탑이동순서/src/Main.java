import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder("");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/******************************
         * 재귀를 이용하여 n-1 번쨰까지 
         * 2번 단상으로 옮기고
         * n번째를 3번 단상으로 옮긴후
         * 다시 2번 단상에서 3번단상으로 옮기는
         * 순서를 구한다.
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
