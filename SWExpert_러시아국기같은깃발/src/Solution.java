import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
        	/******************************
        	 * W B R에 대한 갯수를 각각 구해서
        	 * 전체갯수에서 해당 갯수를 빼면 칠해야
        	 * 하는 갯수가 나오는 방법으로 구현한다.
        	 * W R은 끝에 항상 있어야하므로 선처리하고
        	 * B를 기준으로 크기를 늘려가면서 그중에서
        	 * 최솟값을 구한다.
             *******************************/
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            int[] alp = new int[100];
            alp['W'] = 0;
            alp['B'] = 1;
            alp['R'] = 2;

            int[][] wbr = new int[n][3];

            for(int i = 0; i < n; i++){
                String str = br.readLine();

                for(int j = 0; j < str.length(); j++){
                    wbr[i][alp[str.charAt(j)]]++;
                }
            }
            int res = 0;

            res += m - wbr[0][alp['W']]; res += m - wbr[n-1][alp['R']];

            for(int i = 1; i < n; i++){
                int blue_start = 1;
                int blue_end = blue_start + i;
                search(wbr,blue_start,blue_end,i,n-1,n,0,alp,m);
            }
            System.out.println("#"+t+" "+(res+min));
        }

    }
    static int min;
    public static void search(int[][] wbr,int blue_start,int blue_end,int blue_cnt,int red,int n,int total,int[] alp,int m){
        if(blue_end > n-1) return;

        for(int i = 1; i < blue_start; i++){
            total+= m - wbr[i][alp['W']];
        }
        for(int i = blue_start; i < blue_end; i++){
            total+= m - wbr[i][alp['B']];
        }
        for(int i = blue_end; i < red; i++) {
            total += m - wbr[i][alp['R']];
        }
        min = Math.min(min,total);
        blue_start++;
        blue_end = blue_start+blue_cnt;
        search(wbr,blue_start,blue_end,blue_cnt,red,n,0,alp,m);
    }

}