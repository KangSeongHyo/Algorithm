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
		 * 컬러볼을 사이즈 크기로 정렬한다.
		 * 이전에 모든 누적합과 컬러별 
		 * 누적합을 저장해둔다. 정렬된
		 * 컬러볼을 오름차순으로 탐색하여
		 * 누적에서 빼주는 형태로 값을 구한다.
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
			Ball top = blist.get(i); // 큰값
			for(int j = i-1; j>=0; j--) {
				Ball next = blist.get(j); // 작은 값
				if(next.size < top.size) break;
				if(next.color != top.color) 
					res[top.idx] -= next.size;
				//색깔이 다를 경우 누적합에서 제외해야한다.
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
