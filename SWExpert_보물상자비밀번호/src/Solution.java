import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		/******************************
         * String의 subString을 이용하여
         * 한칸씩 미루는 방법으로 나누기 4한 만큼의
         * 변의 숫자를 구하고 sort 통해 k번째
         * 수를 구한다.
         *******************************/
		alpa['A'-'0'] = 10;alpa['B'-'0'] = 11;alpa['C'-'0'] = 12;alpa['D'-'0'] = 13;alpa['E'-'0'] = 14;alpa['F'-'0'] = 15;
		//System.out.println(alpa['A'-'0']);
		for(int i = 0; i < 10; i++) alpa[i] = i;
		StringBuilder sb = new StringBuilder("");
		for(int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			List<Integer> list = new LinkedList<>();
			String str = br.readLine();
			int rotation = n/4;
			
			for(int i = 0; i < rotation; i++) {
				for(int j = 0; j < n ; j+=rotation) {
					String temp = str.substring(j, j+rotation);
					//System.out.println(temp);
					char[] charArr= temp.toCharArray();
					int parse10 = to10(charArr);
					//System.out.println(parse10);
					if(!list.contains(parse10)) {
						list.add(parse10);
					}
				}
				str = str.substring(1, str.length())+str.substring(0,1);
			}
			
			Collections.sort(list,Collections.reverseOrder());
			sb.append("#"+t+" "+list.get(k-1)+"\n");
		}
		System.out.println(sb.toString());
	}
	static int[] alpa = new int[100];
	public static int to10(char[] charArr) {
		int total = 0;
		for(int i = charArr.length-1,u=0; i >= 0; i--,u++) {
			total+= alpa[charArr[i]-'0']*Math.pow(16, u);
		}
		//System.out.println(total + " 변환");
		return total;
	}
}
