//COS PRO 1�� JAVA 1��  [1��] ����4) Ÿ�Ӹӽ� - JAVA
public class Pr210605_1 {
	public long solution(long num) {				
		String nums = "";
    do {
				num += 1;
				nums = Long.toString(num);
			} while(nums.contains("0"));
				
    return num;
}

	public static void main(String[] args) {
		Pr210605_1 sol = new Pr210605_1();
        long num = 9949999;
        long ret = sol.solution(num);

        System.out.println("solution �޼ҵ��� ��ȯ ���� " + ret + " �Դϴ�.");
    }
}
