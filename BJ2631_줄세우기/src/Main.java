import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] temp = new int[n];
		int[] arr = new int[n];
		/***************************
		 * LIS를 이용해 최대 길이를 구하고
		 * 총 아이들에서 이값을 빼주어
		 * 결과값을 출력한다.
		 ***************************/
		int len = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		temp[0]=len;
		for(int i = 1; i < n ; i++) {
			if(arr[temp[len]] > arr[i]) {
				int idx = lowBound(0, len, arr[i], arr, temp);
				temp[idx] = i;
			}else {
				temp[++len] = i;
			}
		}
		System.out.println(n-(len+1));
	}
	private static int lowBound(int start, int end, int target,int[] arr, int[] temp) {
		if(start >= end)
			return start;
		
		int mid = (start + end)/2;
		
		if(arr[temp[mid]] < target) {
			return lowBound(mid+1, end, target,arr,temp);
		}else {
			return lowBound(start, mid, target,arr,temp);
		}
	}
}
