import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Sides;

public class Main {
	static int x;
	static int y;
	static int[][] arr;
	static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		visited = new boolean[y][x];
		dist = new int[y][x];
		/******************************
         * DFS와 비트연산을 활용해서 벽이 있을경우
         * 탐색하는 방식으로 크기와 갯수를 
         * 구할 수 있다. 3번도 벽을 제거하고
         * 탐색해서 넓이를 구해 최댓값을 찾는 
         * 방식으로 구할 수 있다.
         *******************************/
		
		for(int i = 0; i < y ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		
		for(int i = 0; i < y ; i++) {
			for(int j = 0; j < x; j++) {
				
				if(!visited[i][j]) {
					breath = 0;
					dfs(i, j, arr[i][j]);
					high = Math.max(breath, high);
					count++;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(high);
		
		int[] bit = {8,4,2,1}; // 남 동 북 서
		
		for(Integer in : bit) {
			for(int i = 0; i < y ; i++) {
				for(int j = 0; j < x; j++) {
					if((in & arr[i][j]) == in) {
						visited = new boolean[y][x];
						arr[i][j] = arr[i][j] - in;
						breath = 0;
						dfs(i, j, arr[i][j]);
						high = Math.max(breath, high);
						arr[i][j] = arr[i][j] + in;
				    }
				}
			}
			
		}
		
		System.out.println(high);
	}
	
	static int max = Integer.MIN_VALUE;
	static int dist[][];
	static int breath = 0;
	static int high = 0;
	
	public static void dfs(int i,int j, int wall) {
		visited[i][j] = true;
		int bit[] = new int[4];
		int binary = 16;
		breath++;
		
		for(int k = 0; k < 4 ; k++) {
			binary = binary/2;
			bit[k] = wall & binary;
		}
		
		if(i+1<y && bit[0] != 8 && !visited[i+1][j]) {
			dfs(i+1, j, arr[i+1][j]);
		}
		if(j+1<x &&  bit[1] != 4 && !visited[i][j+1]) {
			dfs(i, j+1, arr[i][j+1]);
		}
		if(i-1>=0 && bit[2] != 2 && !visited[i-1][j]) {
			dfs(i-1, j, arr[i-1][j]);
		}
		if(j-1>=0 && bit[3] != 1 && !visited[i][j-1]) {
			dfs(i, j-1, arr[i][j-1]);
		}
	}
	
}

class Pair{
	int x ;
	int y ;
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
