import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
		System.out.println(solution(new int[][]{{-20,15}, {-14,-5}, {-18,-13},{-5,-3}}));
	}
	public static int solution(int[][] routes) {
        int answer = 0;
        /****************************
         * 경로를 왼쪽 기준으로 정렬을 하고
         * 첫번째 자동차의 끝범위부터 시작하여
         * 다음 자동차의 앞부분과 비교하고
         * 이전 끝범위가 다음 앞범위에 포함되는지
         * 안되는지 그리고 포함되면 이전 끝범위가
         * 다음 앞범위를 포함하는지 안하는지를 
         * 판단하여 최적의 카메라 대수를 구한다.
         ****************************/
        Arrays.sort(routes, (r1,r2)-> Integer.compare(r1[0], r2[0]));
        //Arrays.stream(routes).forEach(i->System.out.println(Arrays.toString(i)));
        int front_tail = routes[0][1];
        
        for(int i = 1; i < routes.length; i++) {
        	int next_head = routes[i][0]; 
        	int next_tail = routes[i][1];
        	
    	   if(next_head <= front_tail) {
    		   if(front_tail >= next_tail) {
    			   front_tail = next_tail;
    		   }
    	   }else {
    		   front_tail = next_tail;
    		   answer++;
    	   }
       }
        return answer+1;
    }
}

