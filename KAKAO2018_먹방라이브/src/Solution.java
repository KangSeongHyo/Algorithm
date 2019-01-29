import java.util.Arrays;

public class Solution {

    public int solution(int[] food_times, long k) {
        long answer = 0;
        Food[] food = new Food[food_times.length];
      
      //IntStream.range(0, food_times.length)
      // .forEach(i->food_list.add(new Food(food_times[i], i+1)));
      		
       for(int i = 0; i < food_times.length; i++) {
    	   food[i] = new Food(food_times[i], i+1);
      }
       
       /******************************
        * ȿ������ �����ϸ�
        * food_time�� ������������ �����ؼ�
        * �տ� �ִ� food���� * ���� ���� ���� �ϸ�
        * �ѹ��� �ϳ��� ������ ó���� �� �ִ�.
        * ó�����Ĵ� �տ� �ִ� ������ �����߱� ������
        * �׸�ŭ �����ϰ� * ���� ���ļ��� ó�����ش�
        * �����ϸ鼭 �ð��� ��� �����ְ� 
        * k���� �Ѿ�� ������ ���ĸ� ó���� ��������
        * k���� ������ ó�� �� ���� �ð��� ���ְ�
        * �װ��� ���� ���� ���� ������ 
        * ���� ������ �ε����� �� �� �ִ�.
        *******************************/
       
       Arrays.sort(food);

        long sum = 0;
        long remainder = 0;
        int size = food.length;
        int idx = 0; // ó���� ���ļ��� ������ index
        boolean flag = false; // k�� food_times�� �Ѿ���

        for(int i = 0; i < size; i++) {
        	long perv = sum;

        	if(i == 0) {
        		sum += food[i].time*size;
        	}else {
        		sum += (food[i].time-food[i-1].time)*(size-i);
        	}
        	
        	if(sum > k) {
        		remainder = k-perv;
        		idx = i;
        		flag = true; 
        		break;
        	}
        	food[i].idx = -1; // ó���� ����
        }
        
        if(!flag) return -1;

        Arrays.sort(food,Food::compareIdx);
        int len = size-idx;
        int count = 0;
        int ans = 0;
        answer = remainder % (long)len;
        
        for(int i = 0; i < size; i++) {
        	if(food[i].idx == -1) continue;
        	if(count == answer) {
        		ans = i;
        		break; 
        	}
        	count++;
        }
        
        return food[ans].idx;

    }

}

class Food implements Comparable<Food>{

	int time;
	int idx;

	public Food(int time, int idx) {
		this.time = time;
		this.idx = idx;
	}

	public int compareIdx(Food other) {
		return idx - other.idx;
	}
	@Override
	public int compareTo(Food other) {
		return time - other.time;
	}

}