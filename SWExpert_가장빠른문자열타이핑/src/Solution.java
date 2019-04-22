import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t =1; t <=test; t++) {
			/***************************
			 * �����͸� �̿��Ͽ� Ÿ������ ���ڿ���
			 * ���Ҹ� �ϳ��� üũ�ؼ� Ÿ���� ����
			 * ���Ѵ�.
			 ***************************/
			String[] str = br.readLine().split(" ");
			char[] arr = str[0].toCharArray();
			int idx = 0;
			int count = 0;
			for(char cr : arr) {
				if(cr==str[1].charAt(idx)) {
					idx ++;
					if(idx == str[1].length()) {
						idx = 0;
						count-=(str[1].length()-1);
					}
				}else if(cr==str[1].charAt(0)) {
					idx = 1;
				}else {
					idx = 0;
				}
				count++;
				//System.out.println(cr+" "+count+" "+idx);
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
