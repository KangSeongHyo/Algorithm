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
	        * ��Ʈ������ �̿��Ͽ� ��� ��츦 Ž���Ѵ�.
	        * �̶� ��ǰ ���� 1�� 0 �ΰ��� ����� �����Ƿ�
	        * 2*2^n ���� ��츦 Ž���ϰ� ���� ����
	        * ���� ���Ѵ�.
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
                  // ���μ��� ����
              }
          }

          if (isPass()) {
              sb.append("#"+(t+1)+" "+0+"\n");
              continue; // ���� �ʿ� ���°��
          }
          int[][] temp = new int[w][d];
          copy(temp, arr);
          for (int i = 1; i < 1 << d; i++) {
              max_len = new int[w];
              combi(i, 0); // 0 ����
              copy(arr, temp);

              max_len = new int[w];
              combi(i, 1); // 1 ����
              copy(arr, temp);
          }
          sb.append("#"+(t+1)+" "+(min)+"\n");
      }
        System.out.println(sb.toString());
    }
    static int min = Integer.MAX_VALUE;
    public static void combi(int bit,int val){
            int cnt = 0; // ���� ����
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
