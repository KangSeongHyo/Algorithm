import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int path;
    static int[][] arr;
    static int d;
    static int w;
    static int k;
    static int[] max_len;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
       for(int t = 0; t < T; t++) {
		   /******************************
	        * 비트연산을 이용하여 모든 경우를 탐색한다.
	        * 이때 약품 투입 1과 0 두가지 방식이 있으므로
	        * 2*2^n 가지 경우를 탐색하고 가장 적은
	        * 값을 구한다.
	        *******************************/
          min = Integer.MAX_VALUE;
          StringTokenizer st = new StringTokenizer(br.readLine());
          d = Integer.parseInt(st.nextToken());
          w = Integer.parseInt(st.nextToken());
          k = Integer.parseInt(st.nextToken());
          arr = new int[w][d];
          max_len = new int[w];

          for (int i = 0; i < d; i++) {
              st = new StringTokenizer(br.readLine());
              for (int j = 0; j < w; j++) {
                  arr[j][i] = Integer.parseInt(st.nextToken());
                  // 가로세로 반전
              }
          }

          if (isPass()) {
              sb.append("#"+(t+1)+" "+0+"\n");
              continue; // 투입 필요 없는경우
          }
          int[][] temp = new int[w][d];
          copy(temp, arr);
          for (int i = 1; i < 1 << d; i++) {
              max_len = new int[w];
              combi(i, 0); // 0 투입
              copy(arr, temp);

              max_len = new int[w];
              combi(i, 1); // 1 투입
              copy(arr, temp);
          }
          sb.append("#"+(t+1)+" "+(min)+"\n");
      }
        System.out.println(sb.toString());
    }
    static int min = Integer.MAX_VALUE;
    public static void combi(int bit,int val){
            int cnt = 0; // 투입 개수
            for(int i = 1,u=0; i < 1 << d; i=i*2,u++){
                if((i & bit) == i){
                    cnt ++;
                    for(int k = 0; k < w; k++){
                        arr[k][u] = val;
                    }
                }
            }

            if(isPass()) {
                min = Math.min(min,cnt);
            }
    }

    public static void copy(int[][] target,int[][] arr){
        for(int i = 0; i < arr.length;i++){
            target[i] = arr[i].clone();
        }
    }


    public static boolean isPass(){
        for(int i = 0; i < w; i++){
            int cnt = 1;
            for(int j = 0; j < d-1; j++){
                if(arr[i][j] == arr[i][j+1]){
                    cnt += 1;
                }else{
                    max_len[i] = Math.max(max_len[i],cnt);
                    cnt = 1;
                }
            }
            max_len[i] = Math.max(max_len[i],cnt);
        }
        for(int i = 0; i < w; i++){
            if(max_len[i]-k < 0) return false;
        }
        return  true;
    }

}
