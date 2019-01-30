import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Solution {
	
	public String solution(String[] participant, String[] completion) {
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		/******************************
         * 한명만 완주를 못한 것이기 때문에
         * 정렬을 해서 동등비교를 한다
         * 이때 중복일 경우는 매치가 되지 않기 때문에
         * 첫번째 매치가 되지 않는 경우가 답이된다.
         * 매치가 되지않는 경우가 없는 경우는
         * 제일 마지막번째가 답이된다. 
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
