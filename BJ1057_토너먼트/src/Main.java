import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int temp = a;
		a = Math.min(a, b);
		b = Math.max(temp, b);
		/******************************
         * 나누기 2 + 나머지 2의 식을 이용하면
         * 다음번 번호부여를 알 수 있고
         * 이 번호가 같을때까지 반복한다.
         *******************************/
		int count = 0;
		while(a!=b) {
			a = a/2+a%2;
			b = b/2+b%2;
			count ++;
		}
		System.out.println(count);
		
		/*int start = 1;
		int end = n;
		int total = 0;
		
		if(n%2 != 0) total++;
		
		while(n > 1) {
			n = n/2;
			total++;
		}
		if(a==end || b==end) {
			System.out.println(total);
			return;
		}
		
		while(start <= end) {
			
			int m = (start+end)/2;
			
			if(a >= start && a <= m && b > m && b <= end) {
				break;
			}else {
				if(a >= start && a <= m && b >= start && b <= m) {
					end = m;
				}else {
					start = m+1;
				}
			}
			total--;
		}
		System.out.println(total);
*/	}
}
