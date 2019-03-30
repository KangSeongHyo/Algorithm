import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sol(arr);
	}
	public static void sol(int arr[]) {
		int[] temp = new int[arr.length];// ����������Ǵ�
		int[] result = new int[arr.length];// �Ǵ�
		int len = 0;
		/******************************
		 * DP�� �̿��� LIS �˰������� (NlogN)
		 * �ִ� ������ ����������� ���ϰ�
		 * �� ���� �ϳ��� �ڽ��� ���� �� �ִ� �ִ� ����
		 *******************************/
		
		temp[len] = 0;
		Arrays.fill(result, -1);
		for(int i = 1; i < arr.length; i++) {
			if(arr[temp[len]] < arr[i]) {
				temp[++len] = i;
				result[i] = temp[len-1];
			}else {
				idx = 0;
				lowBound(arr,temp, 0, len, arr[i]);
				if(idx > len) idx = len;
				temp[idx] = i;
				
				if(idx != 0)
					result[i] = temp[idx-1];
			}
		}
		System.out.println(len+1);
		
	}
	static int idx;
	public static void lowBound(int[] arr,int[] temp,int start, int end, int target) {
		//System.out.println(start+" "+end);
		if(start>end) {
			idx = start+1;
			return;
		}else if(start == end) {
			idx = start;
			return;
		}
		int mid = (start + end) / 2;
		
		if(arr[temp[mid]] < target) {
			lowBound(arr, temp, mid+1, end, target);
		}else{
			lowBound(arr,temp, start, mid, target);
		}
	}
}
