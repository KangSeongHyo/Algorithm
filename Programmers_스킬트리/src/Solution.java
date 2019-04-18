import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
	
    public static int solution(String skill,String[] skill_trees) {
        int answer = 0;
        char[] order = skill.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char a:order) set.add(a);
        loop:for(String str : skill_trees) {
        	char[] arr = str.toCharArray();
        	int lvl = 0;
        	for(char ch : arr) {
        		if(set.contains(ch)) {
        			if(order[lvl] != ch) continue loop;
        			else lvl++;
        		}
        	}
        	answer++;
        }
        
        return answer;
    }
}