
class Solution {
	static int count = 0;
	
    public int solution(int[] numbers, int target) {
    	/******************************
         * 깊이우선탐색을 통해서 + -의 모든경우를 
         * 탐색한다.
         *******************************/
        dfs(numbers, target, 0, 0);
        return count;
    }
    
    public void dfs(int[] numbers,int target,int deep,int res) {
    	
    	if(deep == numbers.length) {
			if(res == target) {
				count++;
				return;
			}else {
				return;
			}
		}
    	
		dfs(numbers, target, deep+1,res+numbers[deep]);
		dfs(numbers, target, deep+1,res-numbers[deep]);
	}
}