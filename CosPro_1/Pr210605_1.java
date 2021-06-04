//COS PRO 1급 JAVA 1차  [1차] 문제4) 타임머신 - JAVA
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

        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
