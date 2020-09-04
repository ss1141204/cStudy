//2020 KAKAO BLIND RECRUITMENT 문자열 압축
public class Pr200904 {

	public static void main(String[] args) {
		String s = "abcabcabcabcdededededede"; // 예시 문제
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		int min = 9999;

		int[] cnt;
		int[] rslt = new int[s.length()];

		for (int i = 1; i <= s.length(); i++) { // 문자열 : length(); 배열 : length;주의하자!
			int j = 0;
			int k = 0;
			String ans = "";
			cnt = new int[s.length()]; // 단어가 같은 단위끼리들의 총합

			while ((j + i + i) <= s.length()) { // 현재 단위와 다음 단위의 단어 비교
				if (s.substring(j, j + i).equals(s.substring(j + i, j + i + i))) {	// 앞뒤 단위 단어가 서로 같다면 : +1
					cnt[k]++; 
				} else { 
					if ((cnt[k] + 1) != 1) { // 지금까지 같은 단위가 2개 이상이었다면
						ans += (cnt[k] + 1); // 결과값에 그 숫자를 적어준다.
					}
					
					ans += s.substring(j, j + i); // 해당 단위의 단어를 적어준다.
					k++; // 다음 단위(cnt[])로 넘어가기 위함
				}

				j += i; // i개 단위이므로 다음 단위로 이동
			}
			// 마지막 단위까지 검사한 후 마지막 단위의 단어를 결과값에 적어준다.
			if ((cnt[k] + 1) != 1) { // 위와 같음
				ans += (cnt[k] + 1);
			}
			ans += s.substring(j, s.length());

			rslt[i - 1] = ans.length(); // i개 단위로 잘라 압축한 길이 저장
		}

		for (int a : rslt) { // 최솟값 구하기
			if (min > a) {
				min = a;
			}
		}
		answer = min;

		return answer;
	}
}
