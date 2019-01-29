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
        * 효율성을 생각하면
        * food_time을 오름차순으로 정렬해서
        * 앞에 있는 food부터 * 남은 음식 수를 하면
        * 한번에 하나의 음식을 처리할 수 있다.
        * 처음이후는 앞에 있는 음식을 제거했기 때문에
        * 그만큼 제거하고 * 남은 음식수를 처리해준다
        * 진행하면서 시간은 모두 더해주고 
        * k값을 넘어가면 이전의 음식만 처리된 것임으로
        * k에서 이전에 처리 된 음식 시간을 빼주고
        * 그값을 남은 음식 수로 나누면 
        * 남은 음식의 인덱스를 알 수 있다.
        *******************************/
       
       Arrays.sort(food);

        long sum = 0;
        long remainder = 0;
        int size = food.length;
        int idx = 0; // 처리된 음식순서 다음번 index
        boolean flag = false; // k가 food_times를 넘어갈경우

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
        	food[i].idx = -1; // 처리된 음식
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