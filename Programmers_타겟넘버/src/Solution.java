
class Solution {
	static int count = 0;
	
    public int solution(int[] numbers, int target) {
    	/******************************
         * ���̿켱Ž���� ���ؼ� + -�� ����츦 
         * Ž���Ѵ�.
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