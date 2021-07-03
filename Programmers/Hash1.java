//���α׷��ӽ� - �ؽ� - �������� ���� ����
import java.util.*;

public class Hash1 {
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> player = new HashMap<>();	//���� map
        
        for(String p : participant) {
        	player.put(p, player.getOrDefault(p, 0) + 1);	//<������, 0 Ȥ�� value++>
        }
        
        for(String c : completion) {
        	player.put(c, player.getOrDefault(c, 0) - 1);	//<������, 0 Ȥ�� value-->
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
