import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int k;
    static int[][] map;
    static List<Pair> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /******************************
         * BFS를 이용해서 Cell을 번식하고 
         * 정렬을 이용해서 더 생명력이 큰 Cell이
         * 먼저 번식할 수 있도록 만든다. 그리고 
         * 살아남을 수 있는 세포들을 K초까지 구하고
         * 이를 출력한다.
         *******************************/
        int T = sc.nextInt();
        for(int t = 1; t<=T; t++) {
            pq = new ArrayList<>();
            map = new int[700][700];
            int r = sc.nextInt();
            int c = sc.nextInt();
            k = sc.nextInt();
            res = 0;
            for(int i = 0; i < r ; i++) {
                for(int j = 0; j < c; j++) {
                    int size = sc.nextInt();
                    map[i+350][j+350] = size;
                    if(size!=0) {
                        pq.add(new Pair(i+350, j+350, size, size+1));
                        //세포를 큐에 담는다. time 라이프 주기
                        
                        if(size*2>k) res++;
                        // k초동안 살아남을 수 있는 세포
                    }
                }
            }
            Collections.sort(pq);
            bfs();
            System.out.println("#"+t+" "+res);
        }
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int res;
    public static void bfs() {

        while (true) {// 번식
            Pair cell = pq.remove(0);
            if (cell.time > k) break;
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];
                if (map[nx][ny] == 0) {
                    pq.add(new Pair(nx, ny, cell.size, cell.time + cell.size + 1));
                    map[nx][ny] = cell.size;
                    if(cell.time+cell.size*2>k) res++;
                }
            }
            Collections.sort(pq);
        }
    }
 
    static class Pair implements Comparable<Pair>{
        int x,y,size,time;

        public Pair(int x, int y,int size, int time) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.time = time;
        }

        @Override
        public int compareTo(Pair o2) {
            if(time != o2.time)
            	return Integer.compare(time, o2.time);
            else
            	return Integer.compare(o2.size, size);
        }
    }
}
