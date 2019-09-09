import java.util.Arrays;
import java.util.Scanner;
public class Solution
{
    private static final int H = 0;
    private static final int M = 1;
    private static final int S = 2;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] current = sc.next().split(":");
            String[] target = sc.next().split(":");
            int hour = Integer.parseInt(target[H])-Integer.parseInt(current[H]);
            int min = Integer.parseInt(target[M])-Integer.parseInt(current[M]);
            int sec = Integer.parseInt(target[S])-Integer.parseInt(current[S]);

            if(sec < 0){
                sec = sec+60;
                min = min-1;
            }
            if(min < 0){
                min = min+60;
                hour = hour-1;
            }
            if(hour < 0){
                hour = hour + 24;
            }
            String res = "";
            if(hour<10) {
                res = res +"0"+hour;
            }else{
                res = res + hour;
            }
            res+=":";
            if(min<10) {
                res = res +"0"+min;
            }else{
                res = res + min;
            }
            res+=":";
            if(sec<10) {
                res = res +"0"+sec;
            }else{
                res = res + sec;
            }
            System.out.println("#"+test_case+" "+res);
        }
    }
}