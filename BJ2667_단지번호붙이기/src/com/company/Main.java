
import java.util.*;

public class Main {
    private static int[][] map;
    private static int n;
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n ; i++){
            String str = sc.next();
            for(int j = 0; j < n ; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        start();
    }
    private static boolean[][] visited;
    public static void start(){
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    int count = bfs(i,j);
                    list.add(count);
                }
            }
        }
        System.out.println(list.size());
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
    public static int bfs(int i, int j){
        Queue<Pair> queue = new LinkedList<>();
        int count = 1;
        queue.add(new Pair(i,j));
        while (!queue.isEmpty()){
            Pair pair = queue.remove();
            int x = pair.x;
            int y = pair.y;
            for(int u = 0; u < 4; u++){
                int nx = x + dx[u];
                int ny = y + dy[u];
                if(isBoundary(nx,ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    count++;
                    queue.add(new Pair(nx,ny));
                }
            }
        }
        return count;
    }
    public static boolean isBoundary(int x, int y){
        if(x > n -1 || y > n -1 || x < 0 || y < 0 ){
            return false;
        }
        return true;
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static class Pair{
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
