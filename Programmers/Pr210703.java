//프로그래머스 - 해시 - 완주하지 못한 선수
import java.util.*;

public class Pr210703 {
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> player = new HashMap<>();	//선수 map
        
        for(String p : participant) {
        	player.put(p, player.getOrDefault(p, 0) + 1);	//<선수명, 0 혹은 value++>
        }
        
        for(String c : completion) {
        	player.put(c, player.getOrDefault(c, 0) - 1);	//<선수명, 0 혹은 value-->
        }
        
        for(String p : player.keySet()) {
        	if(player.get(p) != 0) {
        		return p;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki","eden", "leo"};
		String[] completion = {"eden", "kiki", "leo"};
		
		System.out.println(solution(participant, completion));
		
	}

}
