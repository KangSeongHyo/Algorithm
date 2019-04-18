import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {50,50,50,50,50},60));
	}
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        /******************************
  		 * 정렬된 사람 무게를 탐색하여 앞 뒤의 포인터를
  		 * 두고 구명보트에 탈 수 있을때까지 포인터를
  		 * 옮겨주는 방식으로 구명보트 수를 구한다.
         *******************************/
        List<Integer> plist = Arrays.stream(people).boxed().collect(Collectors.toList());
        int front = 0;
        int end = plist.size()-1;
        int boat = plist.size();
        while (front <= end) {
			while (plist.get(front) + plist.get(end) > limit && end > 0) end--;
			if(front>=end)break;
			boat--;
			front++;
			end--;
		}
        return boat;
        /*boolean[] visited = new boolean[people.length];
        int boat = people.length;
        for(int i = 0; i < people.length; i++) {
        	int pivot = people[i];
        	if(visited[i]) continue;
        	for(int j = people.length-1; j > i; j--) {
        		int with = people[j];
        		if(pivot+with <= limit && !visited[j]) {
        			visited[i] = true;
        			visited[j] = true;
        			boat--;
        			break;
        		}
        	}
        }*/
    }
}