import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int example = Integer.parseInt(st.nextToken()); 
		
		Map<String, String> eng_map = new HashMap<>();
		Map<String, String> int_map = new HashMap<>();
        List<String> res = new LinkedList<>();		
		for(int i = 1; i <= N ; i++) {
			String input = br.readLine();
			eng_map.put(input, i+"");
			int_map.put(i+"",input);
		}
		for(int i = 0 ; i < example; i++) {
			String exmp = br.readLine();
			if(eng_map.containsKey(exmp)) {
				res.add(eng_map.get(exmp));
			}else {
				res.add(int_map.get(exmp));
			}
		}
		res.stream().forEach(i->System.out.println(i));
		
	}
	
}
