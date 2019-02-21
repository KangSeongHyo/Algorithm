import java.util.HashSet;

public class Solution {
	 public int solution(String str1, String str2) {
		  str1 = str1.toLowerCase();
	        str2 = str2.toLowerCase();
	        int[][] stor = new int[1000][1000];
	        int str1_inter = 0;
	        int str2_inter = 0;

	        HashSet<String> hashSet = new HashSet();
	        /******************************
             * HashSet을 활용하여 교집합과
             * 합집합의 갯수를 구한다.중복의 경우는 
             * 배열을 이용해서 원소의 갯수를 저장하고
             * 중복될 경우 하나씩 지워가면서 합집합을
             * 구한다.
             *******************************/
	        for(int i = 0; i < str1.length()-1; i++){
	            char ch1 = str1.charAt(i);
	            char ch2 = str1.charAt(i+1);
	            if(!(ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') ) continue;
	            stor[ch1][ch2]++;
	            str1_inter++;
	            hashSet.add(ch1+""+ch2);
	        }
	        int union = 0;
	        int inter = 0;

	        for(int i = 0; i < str2.length()-1; i++){
	            char ch1 = str2.charAt(i);
	            char ch2 = str2.charAt(i+1);
	            if(!(ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') ) continue;
	            str2_inter++;
	            if(hashSet.contains(ch1+""+ch2)){
	                if(!(stor[ch1][ch2] == 0)){
	                    stor[ch1][ch2] --;
	                    union ++;
	                    str1_inter--;
	                    str2_inter--;
	                }
	            }
	        }
	        inter = str1_inter + str2_inter + union;
	        double jaka = (double)(union)/inter;
	        if(union == 0 && inter == 0) jaka = 1;
	        return (int)(jaka*65536);
		 
	 }
}
