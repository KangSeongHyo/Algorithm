import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    static HashSet set_left;
    static HashSet set_right;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        int res = 1;
        int cnt = 1;
        set_left = new LinkedHashSet();
        set_right = new LinkedHashSet();
        int[] heigh = new int[10001];
        
        /******************************
         * 피라미드의 높이를 활용해 인접 방의 숫자를
         * 구한다. 이때 맨 좌측,맨 우측, 1번방 
         * 그외 총 4가지 경우를 판단해줘야 한다.
         * 시작 방부터 BFS 탐색을 통해서
         * 원하는 방을 만나면 탐색을 종료하고
         * 그에 해당하는 거리를 출력한다.
         *******************************/
        
        
        for(int i = 0; i  < 150 ; i ++){
            heigh[i] = res;
            res += cnt++;
            set_left.add(res); // 맨 좌측 방들
        }
        res = 1;
        cnt = 2;
        for(int i = 0; i  < 150 ; i ++){
            res += cnt++;
            set_right.add(res); // 맨 우측방들
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist = new int[10001];
            visited = new boolean[10001];
            if(a == b ) {
                sb.append("#"+(t+1)+" "+0+"\n");
                continue;
            }

            bfs(Math.max(a,b),Math.min(a,b),heigh);

            sb.append("#"+(t+1)+" "+(dist[Math.min(a,b)])+"\n");
        }
        System.out.println(sb.toString());
    }
    public  static  void bfs(int start,int target,int[] heigh){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            int item = queue.poll();
            int hei = 0;

            for(int i = 0; i < 149; i++){
                if(heigh[i] <= item && item < heigh[i+1]){
                    hei = i+1;
                    break;
                }
            }
            if(item == 1 && target != 1)continue;
            try {
                if (set_left.contains(item)) {
                    int[] adj = new int[]{item - hei + 1, item + 1, item + hei, item + hei + 1};
                    for (int i = 0; i < adj.length; i++) {
                        if (!visited[adj[i]]) {
                            visited[adj[i]] = true;
                            queue.offer(adj[i]);
                            dist[adj[i]] = dist[item] + 1;
                            if (adj[i] == target) {
                                return;
                            }
                        }
                    }
                } else if (set_right.contains(item)) {
                    int[] adj = new int[]{item - hei, item - 1, item + hei, item + hei + 1};
                    for (int i = 0; i < adj.length; i++) {
                        if (!visited[adj[i]]) {
                            visited[adj[i]] = true;
                            queue.offer(adj[i]);
                            dist[adj[i]] = dist[item] + 1;
                            if (adj[i] == target) {
                                return;
                            }
                        }
                    }
                } else {
                    int[] adj = new int[]{item - hei, item - hei + 1, item - 1, item + 1, item + hei, item + hei + 1};
                    for (int i = 0; i < adj.length; i++) {
                        if (!visited[adj[i]]) {
                            visited[adj[i]] = true;
                            queue.offer(adj[i]);
                            dist[adj[i]] = dist[item] + 1;
                            if (adj[i] == target) {
                                return;
                            }
                        }
                    }

                }
            }catch (Exception e){
            }
        }
    }
}
