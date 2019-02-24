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
         * �Ƕ�̵��� ���̸� Ȱ���� ���� ���� ���ڸ�
         * ���Ѵ�. �̶� �� ����,�� ����, 1���� 
         * �׿� �� 4���� ��츦 �Ǵ������ �Ѵ�.
         * ���� ����� BFS Ž���� ���ؼ�
         * ���ϴ� ���� ������ Ž���� �����ϰ�
         * �׿� �ش��ϴ� �Ÿ��� ����Ѵ�.
         *******************************/
        
        
        for(int i = 0; i  < 150 ; i ++){
            heigh[i] = res;
            res += cnt++;
            set_left.add(res); // �� ���� ���
        }
        res = 1;
        cnt = 2;
        for(int i = 0; i  < 150 ; i ++){
            res += cnt++;
            set_right.add(res); // �� �������
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
