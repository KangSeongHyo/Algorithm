import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/******************************
         * sort를 이용해서 n번째 단어를 찾는다.
         *******************************/
		int T = sc.nextInt();
		
		for(int t= 1; t <= T; t++ ) {
			
			int n = sc.nextInt();
			String str = sc.next();
			List<String> list = new LinkedList<>(); 
			
			for(int i = 0; i < str.length(); i++) {
				list.add(str.substring(i));
			}
			
		List<String> sort= list.stream()
				.sorted()
				.limit(n)
				.collect(Collectors.toList());
		 System.out.println("#"+t+" "+sort.get(sort.size()-1));
		}
	}
}
