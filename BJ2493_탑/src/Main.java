import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		/******************************
         * ������ �̿��Ͽ� ���� ������ �� Ŭ ���
         * ���� ��� �ε����� �����Ѵ�. ���� ����
         * ���þ��� �������� ���ʷ� ���ϸ鼭
         * ���ŵǴ� ������ �ε����� ã�´�. 
         *******************************/
		int[] bu = new int[n]; 
		int[] rcv = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			bu[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		rcv[0] = -1;
		for(int i = 1; i < n; i++) {
			if(bu[i-1]>=bu[i]) {
				rcv[i] = i-1;
				stack.push(i-1);
			}else {
					while(!stack.isEmpty()&&(bu[stack.peek()] <= bu[i])) {
						stack.pop();
					}
					if(stack.empty()) {
						rcv[i] = -1;
					}else {
						rcv[i] = stack.peek();
					}
					stack.add(i);
				}
			}
		
		Arrays.stream(rcv).forEach(ele->{
			System.out.print((ele<0?0:ele+1)+" ");
		});
	}
}
/*public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] bu = new int[n]; 
		int[] rcv = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			bu[i] = Integer.parseInt(st.nextToken());
		}
		int high = 0;
		rcv[0] = -1;
		for(int i = 1; i < n; i ++) {
			if(bu[i-1] >= bu[i]) {
				rcv[i] = i-1;
				high = i-1;
			}else {
				rcv[i] = high;
				if(bu[high] < bu[i]) {
					while(true) {
						high = rcv[high];
						if(high == -1||bu[high]>=bu[i]) break;
					}
					rcv[i] = high;
					high = i;
				}
			}
			
		}
		Arrays.stream(rcv).forEach(ele->{
			System.out.print((ele<0?0:ele+1)+" ");
		});
	}
}
*/