import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(4, new int[][] {{0,0},{1,1},{0,2},{2,0}}));
	}
	public int solution(int n, int[][] data) {
	  int answer = 0;
	  /******************************
       * 좌표 압축과 2차원 배열의 구간합을 이용해서
       * 텐트를 칠 수 있는 경우의 수를 모두 구한다.
       *******************************/
	  
	  // 좌표압축
	  List<Integer> xList = new ArrayList<>();
	  List<Integer> yList = new ArrayList<>();
	  
	  for(int i = 0; i < n; i++) {
		  xList.add(data[i][0]);
		  yList.add(data[i][1]);
	  }
	  xList = xList.stream().distinct().sorted().collect(Collectors.toList());
	  yList = yList.stream().distinct().sorted().collect(Collectors.toList());
	  //System.out.println(Arrays.toString(xList.toArray()));
	  int[][] s = new int[n][n]; 
	 
	  for(int i = 0; i < n;i++) {
		  int x = xList.indexOf(new Integer(data[i][0]));
		  int y = yList.indexOf(new Integer(data[i][1]));
		  data[i][0] = x;
		  data[i][1] = y;
		  s[x][y] = 1;
	  }
	  
	  // 구간합
	  for(int i = 0; i < n; i++) {
		  for(int j = 0; j < n; j++) {
			  if(i != 0) {
				  s[i][j] += s[i-1][j];
			  }
			  if(j != 0) {
				  s[i][j] += s[i][j-1];
			  }
			  if(i !=0 && j != 0) {
				  s[i][j] -= s[i-1][j-1];
			  }
		  }
	  }
	  
	  for(int i = 0; i < n; i++) {
		  for(int j = i+1; j< n; j++ ) {
			  
			  // 대각선이 아닐 경우 
			  if(data[i][0] == data[j][0] || data[i][1] == data[j][1]) continue;
			  
			  int minx = Math.min(data[i][0], data[j][0]);
			  int miny = Math.min(data[i][1], data[j][1]);
			  int maxx = Math.max(data[i][0], data[j][0]);
			  int maxy = Math.max(data[i][1], data[j][1]);
			  
			  int count;
			  // 내부의 쐐기가 있는지 판단
			  if(minx + 1 > maxx-1 || miny+ 1 > maxy-1) {
				  count = 0;
			  }else {
				  count = s[maxx-1][maxy-1] - s[minx][maxy-1] - s[maxx-1][miny] + s[minx][miny];
			  }
			  
			  // 쐐기가 없을 경우 카운팅
			  answer = (count==0)? answer+1:answer;
		  }
	  }
	  
	  return answer;
	}
}
