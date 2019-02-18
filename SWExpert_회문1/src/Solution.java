import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder("");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 10; t ++){

            int N = Integer.parseInt(br.readLine());

            String arr[][]= new String[16][8];
            for(int i = 0; i < 8 ; i++){
                String str = br.readLine();
                for(int j = 0; j < 8 ; j++){
                    arr[i][j] = str.charAt(j)+"";
                }
            }
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8 ; j++){
                    arr[i+8][j] = arr[j][i];
                }
            }
            int cnt = 0;
            for(int i = 0; i < 16; i++){
                for(int j = 0; j < 8 ; j++){
                    if(j+(N-1) > 7) break;
                    boolean ck = false;

                    for(int k = 0; k < (j+N)/2; k++){
                        if((j+N-1)-k > 7 || j+k >7 ) break;
                      //  System.out.println("i : "+i+" j : "+j+" k : "+k+" µÚ : "+(j+N-1-k)+" N : "+N);
                        if(!arr[i][j+k].equals(arr[i][(j+N-1)-k])){ ck = true; break;}
                    }
                    if(!ck) cnt++;
                }
            }
            sb.append("#"+(t+1)+" "+(cnt)+"\n");
        }
        System.out.println(sb.toString());
    }
}
