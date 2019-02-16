import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        path = 0;
        int[][] arr =new int[2*n][n];
        /******************************
         * 시뮬레이션 문제로 경사로가 놓일 수 있는경우
         * 없는경우를 판단하여 경사로의 갯수를 찾는다.
         *******************************/
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i+n][j] = arr[j][i]; // 배열의 세로를 가로로 이어붙인다.
            }
        }

        for(int i = 0; i < 2*n ; i++){
            int cnt = 1; // 경사로를 놓을 수 있는지 없는지 판단변수
            int j = 0;
            for(j = 0; j < n-1 ;j++){
                if(arr[i][j] == arr[i][j+1])
                    cnt++;
                else if(arr[i][j]+1 == arr[i][j+1] && cnt >= L)
                    cnt = 1; // 앞에 있는 벽이 더 클 경우 쌓아온 cnt가 경사로 
                			//  길이보다 같거나 크면 경사로를 놓을 수 있음
                else if(arr[i][j]-1 == arr[i][j+1] && cnt >=0)
                    cnt = 1 - L; // 앞에 있는 벽이 더 작을 경우 길이만큼 음수로 만든다
                				 // 이때 cnt >=0 하는 이유는 2 1 2 일때 경사로가
                				//길거나 짧아도 놓을 수 없음 
                else break;
            }
            if(j == n-1 && cnt >= 0) path++;
        }
        System.out.println(path);

    }
}
