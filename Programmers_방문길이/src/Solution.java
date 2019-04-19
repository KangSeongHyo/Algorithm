class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] dirArr = new int[100];
        boolean[][][][] visited = new boolean[11][11][11][11];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        char[] order = dirs.toCharArray(); 
        int x = 5; int y=5;
        dirArr['U'] = 0; dirArr['D'] = 1; dirArr['R'] = 2; dirArr['L'] = 3;        
        /****************************
         * 4차원 배열을 이용하여 지나간 선을
         * 표시한다. 이때 위로 올라가거나
         * 아래로 내려가는 것은 공통선이므로
         * 처리를 해주어야한다.
         ****************************/
        for(int i = 0; i < order.length; i++) {
        	char d = order[i];
        	int nx = x+dx[dirArr[d]];
        	int ny = y+dy[dirArr[d]];
        	if(nx>=0&&ny>=0&&nx<=10&&ny<=10) {
        		if(!visited[x][y][nx][ny]) {
        			visited[x][y][nx][ny] = true;
        			visited[nx][ny][x][y] = true;
        			answer++;
        		}
        		x = nx; y = ny;
        	}
        }
        
        return answer;
    }
   
}