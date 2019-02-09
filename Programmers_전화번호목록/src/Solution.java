import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
   public boolean solution(String[] phone_book) {
        boolean answer = false;
        /******************************
	     * 주어진 문자배열을 크기순으로 sort를
	     * 하고 2중 반복을 통해서 왼쪽에서
	     * 오른쪽으로 해당 문자열 만큼
	     * 비교해서 접두사인지 판단한다. 
         ******************************/
        List<String> list = Stream.of(phone_book)
        				   .sorted((str1,str2)->str1.length()-str2.length())
        				   .collect(Collectors.toList());
        
        for(int i = 0; i < list.size()-1; i++){
        	for(int j = i+1; j < list.size(); j++) {
        	 answer = list.get(i).equals(list.get(j).substring(0, list.get(i).length()));
        	 if(answer) return !answer;
        	}
        }
        
        return !answer;
    }
}
