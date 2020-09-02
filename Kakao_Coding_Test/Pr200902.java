//2018 KAKAO BLIND RECRUITMENT [1��] ��Ʈ ����
public class Pr200902 {

	public static void main(String[] args) {
		String dartResult = "1D2S3T*"; // ���� ����

		System.out.println("��� : " + solution(dartResult));
	}

	public static int solution(String dartResult) {
		String dart[] = dartResult.split(""); // String -> �迭
		int answer = 0;
		int[] ans = new int[3];
		int num = 0;
		int cnt = 0;
		int j = 0;

		for (int i = 0; i < dart.length; i++) {
			if (dart[i].equals("S")) {
				answer += num;
				ans[j] = num;	//���� �迭�� �߰�
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
			} else if (!dart[i].equals("*") && !dart[i].equals("#")) { // ������ ���
				if (cnt > 0) { // ���ڸ� ���� �ƴ� ���
					num *= 10;
					cnt = 0;
				} else { // ù ����
					num = Integer.parseInt(dart[i].toString());
					cnt++;
				}
			} else if (dart[i].equals("*")) {
				answer = 0;
				ans[j - 1] *= 2;	//ù ���� �ڿ� ���� ���
				if (j > 1) {		//2 / 3 ��° ���� �ڿ� ���� ���
					ans[j - 2] *= 2;
				}
				for (int a : ans) {
					answer += a;
				}
				cnt = 0;
			} else { // dart[i].equals("#")
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
