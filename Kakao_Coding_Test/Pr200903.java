//2019 KAKAO BLIND RECRUITMENT ����ä�ù�
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pr200903 {

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		solution(record);
	}

	public static String[] solution(String[] record) {
		String[] answer = {};
		ArrayList<String> result = new ArrayList<>();
		Map<String, String> rec = new HashMap<>();

		for (int i = 0; i < record.length; i++) {
			if (record[i].split(" ")[0].equals("Enter") || record[i].split(" ")[0].equals("Change")) {
				rec.put(record[i].split(" ")[1], record[i].split(" ")[2]); // id, nickName ����
			}
		}

		for (String s : record) {
			switch (s.split(" ")[0]) {
			case "Enter":
				result.add(rec.get(s.split(" ")[1]) + "���� ���Խ��ϴ�.");
				break;
			case "Leave":
				result.add(rec.get(s.split(" ")[1]) + "���� �������ϴ�.");
				break;
			}
		}
		answer = result.toArray(new String[result.size()]); // ����Ʈ�� �迭�� ��ȯ

		for(String a : answer)
			System.out.println(a);
		
		return answer;
	}

}