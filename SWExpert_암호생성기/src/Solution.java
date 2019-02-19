import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
       /******************************
        * 주어진 조건 대로 앞에 1 ~ 5 줄이고
        * 다시 추가하는 것을 반복하여 0이 될때
        * 출력한다.
        *******************************/
        for (int t = 0; t < 10; t++) {
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> list = new LinkedList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            IntStream.range(0,8).forEach(i-> list.add(Integer.parseInt(st.nextToken())));

            int sub = 1;

            while(true){

                int k = list.pollFirst();
                int res = k - sub;
                if(res <= 0 ){
                    list.add(0);
                    break;
                }
                list.add(res);
                if(sub == 5) sub = 1;
                else sub++;
            }

            sb.append("#"+(t+1)+" ");
            list.stream().forEach(str->sb.append(str+" "));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
