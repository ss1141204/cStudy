//2018 KAKAO BLIND RECRUITMENT [1차] 다트 게임
public class Pr200902 {

	public static void main(String[] args) {
		String dartResult = "1D2S3T*"; // 예시 문제

		System.out.println("결과 : " + solution(dartResult));
	}

	public static int solution(String dartResult) {
		String dart[] = dartResult.split(""); // String -> 배열
		int answer = 0;
		int[] ans = new int[3];
		int num = 0;
		int cnt = 0;
		int j = 0;

		for (int i = 0; i < dart.length; i++) {
			if (dart[i].equals("S")) {
				answer += num;
				ans[j] = num;
				j++;
				cnt = 0;
			} else if (dart[i].equals("D")) {
				num = (int) Math.pow(num, 2);
				answer += num;

				ans[j] = num;
				j++;
				cnt = 0;
			} else if (dart[i].equals("T")) {
				num = (int) Math.pow(num, 3);
				answer += num;
				ans[j] = num;
				j++;
				cnt = 0;
			} else if (!dart[i].equals("*") && !dart[i].equals("#")) { // 숫자일 경우
				if (cnt > 0) { // 한자리 수가 아닐 경우
					num *= 10;
					cnt = 0;
				} else { // 첫 숫자
					num = Integer.parseInt(dart[i].toString());
					cnt++;
				}
			} else if (dart[i].equals("*")) {
				answer = 0;
				ans[j - 1] *= 2;
				if (j > 1) {
					ans[j - 2] *= 2;
				}
				for (int a : ans) {
					answer += a;
				}
				cnt = 0;
			} else { // dart[i].equals('#')
				answer = 0;
				ans[j - 1] *= -1;
				for (int a : ans) {
					answer += a;
				}
				cnt = 0;
			}
		}

		return answer;
	}
}
