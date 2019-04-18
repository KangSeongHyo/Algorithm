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
  		 * ���ĵ� ��� ���Ը� Ž���Ͽ� �� ���� �����͸�
  		 * �ΰ� ����Ʈ�� Ż �� ���������� �����͸�
  		 * �Ű��ִ� ������� ����Ʈ ���� ���Ѵ�.
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