import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
		System.out.println(solution(new int[][]{{-20,15}, {-14,-5}, {-18,-13},{-5,-3}}));
	}
	public static int solution(int[][] routes) {
        int answer = 0;
        /****************************
         * ��θ� ���� �������� ������ �ϰ�
         * ù��° �ڵ����� ���������� �����Ͽ�
         * ���� �ڵ����� �պκа� ���ϰ�
         * ���� �������� ���� �չ����� ���ԵǴ���
         * �ȵǴ��� �׸��� ���ԵǸ� ���� ��������
         * ���� �չ����� �����ϴ��� ���ϴ����� 
         * �Ǵ��Ͽ� ������ ī�޶� ����� ���Ѵ�.
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

