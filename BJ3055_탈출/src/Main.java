import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
		 static int r;
		 static int c;
		 static String[][] arr;
		 static boolean[][] visited;
		 static int[][] dist;
		 static int min = Integer.MAX_VALUE;
		
		 public static void main(String[] args) throws IOException {
		
			  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			  StringTokenizer st = new StringTokenizer(br.readLine());
			  /******************************
		       * Bfs 알고리즘과 Queue의 순서를 이용하여
		       * 물이 들어올거라 예상되는 경우는 S가 움직
		       * 일 수 없기 때문에 반대로 물을 먼저 진행시
		       * 키고 그다음에 S가 움직이는 방식으로 진행한다.
		       * 이때 S가 D를 만나면 끝나고 그 값의
		       * min값을 출력한다. 
		       ******************************/
			  
			  r = Integer.parseInt(st.nextToken());
			  c = Integer.parseInt(st.nextToken());
			  arr = new String[r][c];
			  visited = new boolean[r][c];
			  dist = new int[r][c];
			  Pair s = null;
			
			  Queue<Pair> dq = new LinkedList<>();
			
			  for(int i = 0; i < r; i++) {
			
			   String str = br.readLine();
			
			   for(int j = 0; j < c; j ++) {
			     arr[i][j] = str.charAt(j)+"";
			     
			    if(arr[i][j].equals("S")) {
			       s = new Pair(i, j);
			       dist[i][j] = 0;
			       visited[i][j] = true;
			    }else if(arr[i][j].equals("*")) {
			      dq.add(new Pair(i, j));
			    }
			   }
			  }
			  	dq.add(s);
			
			  	bfs(dq);
			  	if(min == Integer.MAX_VALUE) {
			  		System.out.println("KAKTUS");
			  		return;
			  	}
			  System.out.println(min);
			
		 }
		
		
		 public static void bfs(Queue<Pair> dq) {
		
			 int dx[] = {0,0,1,-1};
			 int dy[] = {1,-1,0,0};
		
			 while(!dq.isEmpty()) {
		
				 Pair p = dq.poll();
		
				 if(arr[p.x][p.y].equals("*")) {
		
				    for(int k = 0; k < 4; k++) {
				     int nx = p.x + dx[k];
				     int ny = p.y + dy[k];
				
					     if(nx >= 0 && nx < r && ny >= 0 && ny < c && !arr[nx][ny].equals("*") && !arr[nx][ny].equals("X") && !arr[nx][ny].equals("D") && !arr[nx][ny].equals("S")){
					
					      arr[nx][ny] = "*";
					      dq.add(new Pair(nx, ny));
					
					     }
				     }
			
				 }else {
		
					 	if(arr[p.x][p.y].equals("*")) continue;
					 	//visited[p.x][p.y] = true;
					    for(int k = 0; k < 4; k++) {
							     int nx = p.x + dx[k];
							     int ny = p.y + dy[k];
							
							     if(nx >= 0 && nx < r && ny >= 0 && ny < c&&!visited[nx][ny] &&!arr[nx][ny].equals("*") && !arr[nx][ny].equals("X")) {
							      dist[nx][ny] = dist[p.x][p.y] + 1;
							      
							      if(arr[nx][ny].equals("D")) {
							       min = Math.min(dist[nx][ny], min);
							       return;
							      }
							      visited[nx][ny] = true;
							      arr[nx][ny] = "S";
							      dq.add(new Pair(nx, ny));
							
					     }
					
					 }
		
				 }
		
			 }
		 }
		
		
		 static class Pair{
		    int x;
		    int y;
		 
		    public Pair(int x, int y) {
		    	super();
		    	this.x = x;
		    	this.y = y;
		  }
		}

}