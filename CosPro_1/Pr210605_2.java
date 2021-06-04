// COS PRO 1급 JAVA 1차 [1차] 문제5) 소용돌이 수 - JAVA

public class Pr210605_2 {
	public int solution(int n) {
        int answer = 1;
				int cnt = 0;
				int plus = (n - 1) * 2;
				int num = answer;
			
				for(int i = 0; i < n - 1; i++) {
					if(cnt == 2) {
						cnt = 0;
						plus /= 2;
					}
					
					num += plus;	
					answer += num;
					cnt++;
				}
			
        return answer;
    }
	
	public static void main(String[] args) {
		Pr210605_2 sol = new Pr210605_2();
        int n1 = 3;
        int ret1 = sol.solution(n1);

        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int ret2 = sol.solution(n2);

        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
