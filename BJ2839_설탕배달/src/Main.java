import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c3 = 0;
		/************************
		 * 3kg ºÀÅõ¸¦ »©¸é¼­
		 * ÃÖ¼Ú°ªÀ» ±¸ÇÑ´Ù.
		 ************************/
		while (!(n < 0)){
			if(n%5 == 0) {
				System.out.println(n/5+c3);
				return;
			}
			n -= 3;
			c3++;
		}
		System.out.println(-1);
	}
}
