import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			HashMap<Character, Integer> hashMap = new HashMap<>();
			hashMap.put('a', 2);hashMap.put('b', 2);hashMap.put('c', 2);
			hashMap.put('d', 3);hashMap.put('e', 3);hashMap.put('f', 3);
			hashMap.put('g', 4);hashMap.put('h', 4);hashMap.put('i', 4);
			hashMap.put('j', 5);hashMap.put('k', 5);hashMap.put('l', 5);
			hashMap.put('m', 6);hashMap.put('n', 6);hashMap.put('o', 6);
			hashMap.put('p', 7);hashMap.put('q', 7);hashMap.put('r', 7);hashMap.put('s', 7);
			hashMap.put('t', 8);hashMap.put('u', 8);hashMap.put('v', 8);
			hashMap.put('w', 9);hashMap.put('x', 9);hashMap.put('y', 9);hashMap.put('z', 9);
			/******************************
	         * HashMap을 이용해서 각 패드에 해당하는
	         * 단어를 매칭시킨후 주어진 다이얼에
	         * 그 자리수가 맞는지 확인하여 값을 구한다.
	         *******************************/
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int count = 0;
			loop:while(n-- > 0) {
				char[] word = st.nextToken().toCharArray();
				
				if(word.length==s.length()) {
					for(int i = 0; i < word.length; i++) {
						if(hashMap.get(word[i])!=Integer.parseInt(s.charAt(i)+"")) {
							continue loop;
						}
					}
					
				}else {
					continue loop;
				}
				
				count++;
			}
			
			sb.append("#"+t+" "+count+"\n");
		}
		System.out.println(sb.toString());
	 }		
}
/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[][] dial = {{},{},
						{'a','b','c'},
						{'d','e','f'},
						{'g','h','i'},
						{'j','k','l'},
						{'m','n','o'},
						{'p','q','r','s'},
						{'t','u','v'},
						{'w','x','y','z'}};
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s = st.nextToken().toCharArray();
			word_len = s.length;
			int n = Integer.parseInt(st.nextToken());
			hashSet = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			isPossible = new boolean[word_len+1][1000];
			while(n-->0) {
				String str = st.nextToken();
				char[] char_arr = str.toCharArray();
				
				if(word_len >= char_arr.length)
				for(int i = 0; i < char_arr.length; i++) {
					isPossible[i][char_arr[i]]=true;
				}
				
				hashSet.add(str);
			}
			count = 0;
				req(dial, word_len, 0, "");
			sb.append("#"+t+" "+count+"\n");
		}
		System.out.println(sb.toString());
		
	}
	static HashSet<String> hashSet;
	static char[] s;
	static boolean[][] isPossible;
	static int word_len;
	static int count;
	public static void req(char[][] dial,int size, int idx,String word) {
		if(idx == size) {
			count = hashSet.contains(word)?count+1:count;
			return;
		}
		
		int len = dial[s[idx]-'0'].length;
		
		for(int i = 0; i < len; i++) {
			if(isPossible[idx][dial[s[idx]-'0'][i]]) {
				req(dial, size, idx+1, word+""+dial[s[idx]-'0'][i]);
			}
		}
	}
}*/
