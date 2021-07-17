//�ڵ��׽�Ʈ����_�ؽ�_��ȭ��ȣ ���    -> ȿ����(������ for�� �߿�)
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
        	phone.put(p, answer);	//<��ȭ��ȣ, true>
        }
        
        for(String p : phone_book) {
        	for(int i = 1; i < p.length(); i++) {	//p�� (������ ����-1)������!!! �ݺ�
        		if(phone.containsKey(p.substring(0,i))) {	//�ش� �κ� ���ڿ��� �����ϴ� map���� Ž��
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