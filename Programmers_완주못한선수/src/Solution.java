import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Solution {
	
	public String solution(String[] participant, String[] completion) {
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		/******************************
         * �Ѹ� ���ָ� ���� ���̱� ������
         * ������ �ؼ� ����񱳸� �Ѵ�
         * �̶� �ߺ��� ���� ��ġ�� ���� �ʱ� ������
         * ù��° ��ġ�� ���� �ʴ� ��찡 ���̵ȴ�.
         * ��ġ�� �����ʴ� ��찡 ���� ����
         * ���� ��������°�� ���̵ȴ�. 
         *******************************/
		Optional<String> res=IntStream.range(0, completion.length)
				.filter(i->!completion[i].equals(participant[i]))
				.mapToObj(i->participant[i])
				.findFirst();
		
		if(!res.isPresent()) {
			return participant[participant.length-1];
		}
		return res.get();
    }
	
}
