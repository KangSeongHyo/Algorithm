class Solution {
	public static void main(String[] args) {
		System.out.println(solution("784542123132813531535156541313", 2));
	}
    public static String solution(String number, int k) {
        int resLen = number.length() - k;
        /******************************
		 * ���ڿ��� Ž���ϸ鼭 ���� ū ���� �Ǵ��ϴ�
		 * �׸��� �̿��Ͽ� ���� ����Ѵ�.
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