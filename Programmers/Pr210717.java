//코딩테스트연습_해시_전화번호 목록    -> 효율성(마지막 for문 중요)
import java.util.HashMap;
import java.util.Map;

public class Pr210717 {
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        if(phone_book.length < 2) {
        	return answer;
        }
        
        Map<String, Boolean> phone = new HashMap<String, Boolean>();
        
        for(String p : phone_book) {
        	phone.put(p, answer);	//<전화번호, true>
        }
        
        for(String p : phone_book) {
        	for(int i = 1; i < p.length(); i++) {	//p의 (마지막 문자-1)까지만!!! 반복
        		if(phone.containsKey(p.substring(0,i))) {	//해당 부분 문자열을 포함하는 map원소 탐색
        			return false;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] phone_book = {"119", "1235", "1197525"};
		
		System.out.println(solution(phone_book));
	}
}