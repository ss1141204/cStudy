//20200910 2020 KAKAO BLIND RECRUITMENT ��ȣ ��ȯ 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pr200910 {
	
	public static void main(String[] args) {
		String p = "(())()";
		System.out.println("answer : " + solution(p));
	}
	
	public static String sepStr(String[] w) {
		String rslt = "";
		String u = "";
        String v = "";
		int l = 0;
        int r = 0;
                
        if(w.length == 0) {	return "";	}	//�� ���ڿ� �� ��� �״�� ��ȯ

		for(String i : w) {	//u, v �и�
        	if(i.equals("(")) {	l++; }
        	else { r++; }
    		u += i;

        	if(l == r) { //u�� �������� ��ȣ ���ڿ�(���� ����) �ϼ�
    		    for(int j = u.length(); j < w.length; j++) {	//������ v���ڿ� �ϼ�
        			v += w[j];
        		}
        		break;
        	}
        }
		
		List<String> u1 = new ArrayList<>(Arrays.asList(u.split("")));
		String[] s = u.split("");
		
		if(u.length() > 0) {
			String[] v1 = v.split("");
			if((checkStr(s)) && u1.get(0).equals("(")) {		//u �ùٸ� ���ڿ�(¦�� ����)
				u += sepStr(v1);	//v�� �ٽ� ó������ ��� ����
				rslt = u;
			}
			else {	//u�� �ùٸ� ���ڿ� �ƴ�
				String word = "(";
				
				String s1 = sepStr(v1);
				
				word += s1;
				word += ")";
				if(u1.size() > 0) {	u1.remove(0);	}//arrayList
				if(u1.size() > 0) {	u1.remove(u1.size() - 1);	}
				
				for(int k = 0; k < u1.size(); k++) {	//��ȣ ������
					if(u1.get(k).equals("(")) { u1.set(k, ")");	}
					else if(u1.get(k).equals(")")){	u1.set(k, "(");	}
				}
				
				for(String str : u1) {
					word += str;
				}
				rslt = word;
			}
		}
		return rslt;
	}
	
	public static boolean checkStr(String[] s) {	//u�� �ùٸ� ���ڿ����� üũ
		int right = 0;
		
		for(String str : s) {
			if(str.equals("(")) {	right++;	}
			else	{	right--;	}
		}

		if(right == 0) { return true;	}
		return false;
	}

	public static String solution(String p) {
        String answer = "";
        
        if(p.equals("")) {	return "";	}	//�� ���ڿ� �� ��� �״�� ��ȯ
        
        String[] w = p.split("");      
        answer += sepStr(w);	//u ����
        
        return answer;
    }
}