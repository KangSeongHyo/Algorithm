	import java.util.Scanner;
	
	public class Main {
		static int n,k;
		static String words[];
		static char[] alpa;
		static boolean visited[];
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			k = sc.nextInt();
			sc.nextLine();
			/***************************
			 * 배울 수 있는 글자수를 완전탐색하여
			 * 주어진 글자를 읽을 수 있는지 판단
			 * 하고 그 최댓값을 구한다.
			 ***************************/
			words = new String[n];
			for(int i = 0; i < n; i++) {
				String temp = sc.nextLine();
				words[i] = temp.substring(4, temp.length()-4);
			}
			if (k < 5) {
				System.out.println(0);
				return;
			}
			visited = new boolean[26];
			visited['a'-97] = visited['t'-97]= visited['c'-97]= visited['i'-97]= visited['n'-97] = true;
			brute(5,97);
			System.out.println(max);
		}
		static int max =0;
		public static void brute(int deep,int idx) {
			if(deep == k) {
				int count = 0;
				loop:for(int i = 0; i < words.length; i++) {
					char[] ch = words[i].toCharArray();
					for(int j = 0; j < ch.length; j++) {
						if(!visited[ch[j]-97]) continue loop;
					}
					count++;
				}
				
				max = Math.max(max, count);
				return;
			}
			for(int i = idx; i <= 122; i++) {
				if(!visited[i-97]) {
					visited[i-97] = true;
					brute(deep+1, i+1);
					visited[i-97] = false;
				}
			}
		}
	}
