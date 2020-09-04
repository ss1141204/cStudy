//2020 KAKAO BLIND RECRUITMENT ���ڿ� ����
public class Pr200904 {

	public static void main(String[] args) {
		String s = "abcabcabcabcdededededede"; // ���� ����
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		int min = 9999;

		int[] cnt;
		int[] rslt = new int[s.length()];

		for (int i = 1; i <= s.length(); i++) { // ���ڿ� : length(); �迭 : length;��������!
			int j = 0;
			int k = 0;
			String ans = "";
			cnt = new int[s.length()]; // �ܾ ���� ������������ ����

			while ((j + i + i) <= s.length()) { // ���� ������ ���� ������ �ܾ� ��
				if (s.substring(j, j + i).equals(s.substring(j + i, j + i + i))) {	// �յ� ���� �ܾ ���� ���ٸ� : +1
					cnt[k]++; 
				} else { 
					if ((cnt[k] + 1) != 1) { // ���ݱ��� ���� ������ 2�� �̻��̾��ٸ�
						ans += (cnt[k] + 1); // ������� �� ���ڸ� �����ش�.
					}
					
					ans += s.substring(j, j + i); // �ش� ������ �ܾ �����ش�.
					k++; // ���� ����(cnt[])�� �Ѿ�� ����
				}

				j += i; // i�� �����̹Ƿ� ���� ������ �̵�
			}
			// ������ �������� �˻��� �� ������ ������ �ܾ ������� �����ش�.
			if ((cnt[k] + 1) != 1) { // ���� ����
				ans += (cnt[k] + 1);
			}
			ans += s.substring(j, s.length());

			rslt[i - 1] = ans.length(); // i�� ������ �߶� ������ ���� ����
		}

		for (int a : rslt) { // �ּڰ� ���ϱ�
			if (min > a) {
				min = a;
			}
		}
		answer = min;

		return answer;
	}
}
