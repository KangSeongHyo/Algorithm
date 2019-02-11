import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		List<Integer> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder("");
		/******************************
         * 3개씩 묶었을때 큰값이면 되므로
         * sort해서 3개씩 묶어서
         * 처리하면 된다.
         *******************************/
		for(int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			IntStream.range(0, N).forEach(i->list.add(Integer.parseInt(st.nextToken())));
			
			Collections.sort(list,Comparator.reverseOrder());
			
			int cnt = 1;
			int total = 0;
			for(Integer in : list) {
				if(cnt == 3) {cnt=1;continue;} 
				total+=in;
				cnt ++;
			}
			sb.append("#"+(t+1)+" "+total +"\n");
			list.clear();
		}
		
		System.out.println(sb.toString());
		
	}
}
