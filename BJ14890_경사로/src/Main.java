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
         * �ùķ��̼� ������ ���ΰ� ���� �� �ִ°��
         * ���°�츦 �Ǵ��Ͽ� ������ ������ ã�´�.
         *******************************/
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i+n][j] = arr[j][i]; // �迭�� ���θ� ���η� �̾���δ�.
            }
        }

        for(int i = 0; i < 2*n ; i++){
            int cnt = 1; // ���θ� ���� �� �ִ��� ������ �Ǵܺ���
            int j = 0;
            for(j = 0; j < n-1 ;j++){
                if(arr[i][j] == arr[i][j+1])
                    cnt++;
                else if(arr[i][j]+1 == arr[i][j+1] && cnt >= L)
                    cnt = 1; // �տ� �ִ� ���� �� Ŭ ��� �׾ƿ� cnt�� ���� 
                			//  ���̺��� ���ų� ũ�� ���θ� ���� �� ����
                else if(arr[i][j]-1 == arr[i][j+1] && cnt >=0)
                    cnt = 1 - L; // �տ� �ִ� ���� �� ���� ��� ���̸�ŭ ������ �����
                				 // �̶� cnt >=0 �ϴ� ������ 2 1 2 �϶� ���ΰ�
                				//��ų� ª�Ƶ� ���� �� ���� 
                else break;
            }
            if(j == n-1 && cnt >= 0) path++;
        }
        System.out.println(path);

    }
}
