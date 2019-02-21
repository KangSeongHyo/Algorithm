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
             * HashSet�� Ȱ���Ͽ� �����հ�
             * �������� ������ ���Ѵ�.�ߺ��� ���� 
             * �迭�� �̿��ؼ� ������ ������ �����ϰ�
             * �ߺ��� ��� �ϳ��� �������鼭 ��������
             * ���Ѵ�.
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
