//20200910 2020 KAKAO BLIND RECRUITMENT 괄호 변환 
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
                
        if(w.length == 0) {	return "";	}	//빈 문자열 일 경우 그대로 반환

		for(String i : w) {	//u, v 분리
        	if(i.equals("(")) {	l++; }
        	else { r++; }
    		u += i;

        	if(l == r) { //u의 균형잡인 괄호 문자열(같은 개수) 완성
    		    for(int j = u.length(); j < w.length; j++) {	//나머지 v문자열 완성
        			v += w[j];
        		}
        		break;
        	}
        }
		
		List<String> u1 = new ArrayList<>(Arrays.asList(u.split("")));
		String[] s = u.split("");
		
		if(u.length() > 0) {
			String[] v1 = v.split("");
			if((checkStr(s)) && u1.get(0).equals("(")) {		//u 올바른 문자열(짝이 맞음)
				u += sepStr(v1);	//v로 다시 처음부터 재귀 수행
				rslt = u;
			}
			else {	//u는 올바른 문자열 아님
				String word = "(";
				
				String s1 = sepStr(v1);
				
				word += s1;
				word += ")";
				if(u1.size() > 0) {	u1.remove(0);	}//arrayList
				if(u1.size() > 0) {	u1.remove(u1.size() - 1);	}
				
				for(int k = 0; k < u1.size(); k++) {	//괄호 뒤집기
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
	
	public static boolean checkStr(String[] s) {	//u가 올바른 문자열인지 체크
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
        
        if(p.equals("")) {	return "";	}	//빈 문자열 일 경우 그대로 반환
        
        String[] w = p.split("");      
        answer += sepStr(w);	//u 생성
        
        return answer;
    }
}