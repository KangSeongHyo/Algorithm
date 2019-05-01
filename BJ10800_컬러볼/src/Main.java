import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int colorSum[] = new int[n];
		int res[] = new int[n];
		List<Ball> blist = new ArrayList<>();
		int total = 0;
		/************************
		 * �÷����� ������ ũ��� �����Ѵ�.
		 * ������ ��� �����հ� �÷��� 
		 * �������� �����صд�. ���ĵ�
		 * �÷����� ������������ Ž���Ͽ�
		 * �������� ���ִ� ���·� ���� ���Ѵ�.
		 ************************/
		for(int i = 0; i < n; i++) {
			int color = sc.nextInt()-1;
			int size = sc.nextInt();
			colorSum[color]+=size;
			total+= size;
			blist.add(new Ball(i, size, color));
		}
		Collections.sort(blist, Ball::compare);
		for(int i = n-1; i >=0; i--) {
			Ball top = blist.get(i); // ū��
			for(int j = i-1; j>=0; j--) {
				Ball next = blist.get(j); // ���� ��
				if(next.size < top.size) break;
				if(next.color != top.color) 
					res[top.idx] -= next.size;
				//������ �ٸ� ��� �����տ��� �����ؾ��Ѵ�.
			}
			
			res[top.idx] += (total - colorSum[top.color]);
			total -= top.size;
			colorSum[top.color] -= top.size;
		}
		Arrays.stream(res).mapToObj(i->i).forEach(System.out::println);
	}
	static class Ball{
		int idx,size,color;
		public Ball(int idx, int size, int color) {
			super();
			this.idx = idx;
			this.size = size;
			this.color = color;
		}
		
		private static int compare(Ball o1, Ball o2) {
			if(o1.size != o2.size) {
				return Integer.compare(o1.size, o2.size);
			}else {
				return Integer.compare(o1.color, o2.color);
			}
		}
	}
}
