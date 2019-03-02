import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[8][8];
        int[] alp = new int[100];
        int[] sw = {7,6,5,4,3,2,1,0};
        for(int i = 0; i < 8 ; i++){
            alp['A'+i] = i;
        }
        /******************************
         * 예외처리를 이용하여 돌과 킹이 판밖으로
         * 넘어가는 경우는 Exception을 발생시켜 
         * 무시하고 다음것을 처리하여 위치를 구한다.
         *******************************/
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String k = st.nextToken();
        Pair king = new Pair(sw[(k.charAt(1)-'0')-1],alp[k.charAt(0)]);
        String s = st.nextToken();
        Pair stone = new Pair(sw[(s.charAt(1)-'0')-1],alp[s.charAt(0)]);
        int n = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> dx = new HashMap<>();
        HashMap<String,Integer> dy = new HashMap<>();
        dx.put("R",0);      dy.put("R",1);
        dx.put("L",0);     dy.put("L",-1);
        dx.put("B",1);      dy.put("B",0);
        dx.put("T",-1);     dy.put("T",0);

        dx.put("RT",-1);    dy.put("RT",1);
        dx.put("LT",-1);    dy.put("LT",-1);
        dx.put("RB",1);     dy.put("RB",1);
        dx.put("LB",1);     dy.put("LB",-1);

        for(int i = 0; i < n ; i++){
            try{
                String str = br.readLine();
                System.out.println(str);
                int kx = king.x;
                int ky = king.y;
                int sx = stone.x;
                int sy = stone.y;

                kx = kx + dx.get(str);
                ky = ky + dy.get(str);
                if(kx == sx && ky == sy){
                    sx = sx + dx.get(str);
                    sy = sy + dy.get(str);
                    arr[sx][sy] = 2;
                }
                arr[kx][ky] = 1;

                king.x = kx;
                king.y = ky;
                stone.x = sx;
                stone.y = sy;

            }catch (Exception e){
                continue;
            }
        }
        char[] res = {'A','B','C','D','E','F','G','H'};
        System.out.println(res[king.y]+""+(sw[(king.x)]+1));
        System.out.println(res[stone.y]+""+(sw[(stone.x)]+1));
    }
    static class Pair{
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
