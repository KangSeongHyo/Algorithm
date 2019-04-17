class Solution {
	public static void main(String[] args) {
		System.out.println(solution("784542123132813531535156541313", 2));
	}
    public static String solution(String number, int k) {
        int resLen = number.length() - k;
        /******************************
		 * 문자열을 탐색하면서 가장 큰 수를 판단하는
		 * 그리디를 이용하여 답을 출력한다.
         *******************************/
        if(number.charAt(0) == '0') return "0";
        char[] nums = number.toCharArray();
        int start_idx = 0;
        StringBuilder sb = new StringBuilder();
        while (resLen > 0) {
        	int max = -1;
        	int max_idx = 0;
        	for(int i = start_idx; i <= nums.length-resLen; i++){
        		if(max < nums[i]-'0') {
        			max = nums[i]-'0';
        			max_idx = i;
        		}
        	}
        	start_idx = max_idx+1;
        	sb.append(max);
        	resLen--;
		}
        
        return sb.toString();
    }
}