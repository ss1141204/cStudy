// COS PRO 1�� JAVA 1�� [1��] ����5) �ҿ뵹�� �� - JAVA

public class Pr210605_2 {
	public int solution(int n) {
        int answer = 1;
				int cnt = 0;
				int plus = (n - 1) * 2; //�ҿ뵹�� �� �� ���� ����
				int num = answer;
			
				for(int i = 0; i < n - 1; i++) {
					if(cnt == 2) {
						cnt = 0;
						plus /= 2;	//�ҿ뵹�� ���� 2ȸ������ �������� �پ��.
					}
					
					num += plus;	//�ҿ뵹�� �� ��
					answer += num;
					cnt++;
				}
			
        return answer;
    }
	
	public static void main(String[] args) {
		Pr210605_2 sol = new Pr210605_2();
        int n1 = 3;
        int ret1 = sol.solution(n1);

        System.out.println("solution �޼ҵ��� ��ȯ ���� " + ret1 + " �Դϴ�.");

        int n2 = 2;
        int ret2 = sol.solution(n2);

        System.out.println("solution �޼ҵ��� ��ȯ ���� " + ret2 + " �Դϴ�.");
    }
}
