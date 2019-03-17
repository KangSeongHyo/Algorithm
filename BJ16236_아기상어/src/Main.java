import java.io.IOException;
import java.util.*;

public class Main {

    static boolean[][] visited;
    static Pair baby ;
    static int[][] dist;
    static int cnt = 0;
    static int weight = 2;
    static int N;
    static int time = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int arr[][] = new int [N][N];
        visited = new boolean[N][N];
        dist = new int[N][N];
        /******************************
         * BFS를 이용하여 각 턴마다 아기상어가
         * 먹으러 가는 물고기의 위치와 거리를 
         * 구하고 조건에 맞게 모든 짧은 거리의
         * 물고기를 비교해서 위치를 이동시킨다. 
         * 위에 과정을 반복하면서 아기상어가
         * 먹을 수 없을때까지의 시간을 구하여 출력한다. 
         *******************************/
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j++){
                int temp = sc.nextInt();
                if(temp != 0) {
                    if(temp == 9){
                        baby = new Pair(i,j);
                    }else{
                        arr[i][j] = temp;
                    }
                }
            }
        }

        while (bfs(baby.x,baby.y,arr)){
            visited = new boolean[N][N];
            dist = new int[N][N];
            dis = Integer.MAX_VALUE;
        }

        System.out.println(time);
    }
    static int dis = Integer.MAX_VALUE;
    
    public static boolean bfs(int x, int y,int[][] arr){
        Queue<Pair> queue = new LinkedList<>();
        List<Pair> list = new LinkedList<>();
        // 물고기를 담는 배열
        
        Comparator<Pair> comparator = (o1,o2)->{
           if(o1.distance < o2.distance) {
            return -1;
           }else if(o1.distance == o2.distance){
               if (o1.x < o2.x) {
                   return -1;
               } else if (o1.x == o2.x) {
                   if (o1.y < o2.y) {
                       return -1;
                   } else if (o1.y == o2.y) {
                       return 0;
                   } else {
                       return 1;
                   }
               } else {
                   return 1;
               }
           }else{
               return 1;
           }

        }; // 정렬 조건

        /*35  10   6   5   7  21
          11   9   4   8   19 20
          12  13   0   18  23 22
          14  1    3   17  24 25
          15  16   2   28  27 26
          32  31   30  29  33 34*/


        queue.offer(new Pair(x,y));
        dist[x][y] = 0;
        visited[x][y] = true;
        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        boolean flag = false;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            for(int i = 0; i < 4; i ++){
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if(nx >= 0 && ny >=0 && nx < N && ny < N && !visited[nx][ny] && arr[nx][ny] <= weight){

                    dist[nx][ny] = dist[pair.x][pair.y] + 1;
                    if(arr[nx][ny] < weight && arr[nx][ny] != 0){
                    	// 먹을수 있는경우
                        flag = true;
                        dis = dist[nx][ny];
                        list.add(new Pair(nx,ny,dist[nx][ny]));
                    }else {
                        visited[nx][ny] = true;
                        if(dis > dist[nx][ny]){
                            queue.offer(new Pair(nx,ny));
                        }
                      }
                }
            }
        }
        if(!flag) return false;// 먹을 물고기 없는경우

        Collections.sort(list,comparator);
        // 거리가 제일 짧고 여러마리면 위에 있고 같으면 왼쪽 물고기

        Pair fish = list.get(0);

        baby.x = fish.x;
        baby.y = fish.y;

        arr[baby.x][baby.y] = 0; // 먹은 자리 물고기 없음
        time+= dist[baby.x][baby.y];
        cnt++;

        if(cnt == weight){
        	// 먹을수 있는 물고기 증가
            weight++;
            cnt = 0;
        }

        return true;
    }

    static class Pair{
        int x,y,distance;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
