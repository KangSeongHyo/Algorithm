import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    static String str;
    static boolean[] visited;
    static List<Integer> idx_list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int T = Integer.parseInt(br.readLine());
        /******************************
         * 재귀반복을 통해 앞에서 부터 개구리
         * 울음소리를 지워나가며 개구리의 수를 구한다.
         * 이때 하나라도 문자가 남을 경우는
         * 개구리 울음 소리가 될 수 없다.
         *******************************/
        loop: for (int t = 0; t < T; t++) {
            str = br.readLine();
            visited = new boolean[str.length()];
            List<Integer> c_list = new LinkedList<>();
            idx_list = new LinkedList<>();

            for(int i = 0;i < str.length();i++){
                if(str.charAt(i) == 'c') c_list.add(i);
            }
            int cnt = 0;
            for(Integer idx : c_list) {
                idx_list.clear();
                if (!visited[idx]) {
                    dfs(idx, "", 0);
                    cnt++;
                }
            }
            for(boolean ck : visited){
                if(!ck) {
                    sb.append("#"+(t+1)+" "+(-1)+"\n");
                    continue loop; // 개구리 울음소리가 아닌경우
                }
            }
            sb.append("#"+(t+1)+" "+(cnt)+"\n");

        }
        System.out.println(sb.toString());
    }
    public static void dfs(int x, String frog, int nums) {
        if (frog.equals("croak")) {
            for (Integer idx : idx_list)
                visited[idx] = true;
            idx_list.clear();
            frog = "";
        }
        if (x == str.length()) {
            return;
        }
        if (!visited[x]) {
            switch (nums) {
                case 0:
                    if (str.charAt(x) == 'c') {
                        idx_list.add(x);
                        dfs(x + 1, frog + "c", 1);
                    } else {
                        dfs(x+1,frog,nums);
                    }
                    break;
                case 1:
                    if (str.charAt(x) == 'r') {
                        idx_list.add(x);
                        dfs(x + 1, frog + "r", 2);
                    }else {
                        dfs(x+1,frog,nums);
                    }
                    break;
                case 2:
                    if (str.charAt(x) == 'o') {
                        idx_list.add(x);
                        dfs(x + 1, frog + "o", 3);
                    }else{
                        dfs(x+1,frog,nums);
                    }
                    break;
                case 3:
                    if (str.charAt(x) == 'a') {
                        idx_list.add(x);
                        dfs(x + 1, frog + "a", 4);
                    }else {
                        dfs(x+1,frog,nums);
                    }
                    break;
                default:
                    if (str.charAt(x) == 'k') {
                        idx_list.add(x);
                        dfs(x + 1, frog + "k", 0);
                    }else{
                        dfs(x+1,frog,nums);
                    }
                    break;
            }
        }else{
            dfs(x+1,frog,nums);
        }
    }
}
