//HashTable 예시 코드
import java.util.LinkedList;

class HashTable {
	class Node {
			String key;	//검색할 키
			String value;	//검색 결과
			
			public Node(String key, String value) {	//key & value 받아 객체에 할당
				this.key = key;
				this.value = value;
			}
			
			String getValue() {	//getter
				return value;
			}
			
			void setValue(String value) {	//setter
				this.value = value;
			}
	}
	
	LinkedList<Node>[] data;	//data를 저장할 linkedList "data" 선언, data 리스트는 [] 배열임.
	
	@SuppressWarnings("unchecked")
	HashTable(int size) {	//해시 테이블 선언하는 순간 해시 테이블 크기 선언. 이 메소드 선언되는 순간 크기 지정됨
		this.data = new LinkedList[size];	//미리 배열방 생성
	}	//생성자?
	
	//***핵심함수1 - key 받아서 해시코드 반환
	int getHashCode(String key) {
		int hashcode = 0;	//초기화
		for(char c : key.toCharArray()) {
			hashcode += c;	//각 문자별 아스키코드 합
		}
		return hashcode;		
	}
	
	//***핵심함수2 - 해시코드를 받아 인덱스로 변환
	int convertToIndex(int hashcode) {
		return hashcode % data.length;
	}
	
	//***핵심함수3 - list내에서 key 찾아 해당 노드 반환
	Node searchKey(LinkedList<Node> list, String key) {
		if (list == null) return null;	//리스트가 비어있는 경우
		
		for(Node node : list) {	//리스트 탐색
			if(node.key.equals(key)) {	//찾는 key와 같은 노드 탐색
				return node;	//있으면 해당 노드 반환
			}
		}
		return null;	//찾는 노드 없으면 null 반환
	}
	
	//***핵심함수4 - key,value 삽입
	void put(String key, String value) {	//저장할 key, value 인자
		int hashcode = getHashCode(key);	//해시코드 생성
		int index = convertToIndex(hashcode);	//인덱스 생성
		
		LinkedList<Node> list = data[index];//해당 인덱스에 링크드리스트 존재유무 확인 위함   *LinkedList 생성한 것 아님!
		if(list == null) {	//그 데이터가 비어있다면? = 해당 인덱스에 데이터가 없다면
			list = new LinkedList<Node>();	//*LinkedList 생성한다.
			data[index] = list;	//해당인덱스에 생성
		}
		
		//해당 키로 이미 노드가 존재하는 지 확인
		Node node = searchKey(list, key);	//해당 리스트(data[index])에서 key 탐색
		
		//키 중복 x - 새로 추가
		if(node == null) {
			list.addLast(new Node(key, value));
		}
		else {	//키 중복 - 대체(중복키 처리)
			node.setValue(value);
		}
	}
	
	//***핵심함수5 - key로 해당 노드 가져오기
	String get(String key) {
		int hashcode = getHashCode(key);
		int index = convertToIndex(hashcode);
		
		LinkedList<Node> list = data[index];	//index번째 연결리스트
		Node node = searchKey(list, key);	//해당 연결리스트 내에서 key갖고있는 노드 찾기
		
		return node == null ? "Not Found" : node.getValue();
	}
}

public class Pr_HashTable {
	
	public static void main(String[] args) {
		HashTable tab = new HashTable(3);	//크기 3 설정.
		
		tab.put("sung", "She is pretty");
		tab.put("jin", "she is a model");
		tab.put("hee", "She is an angel");
		tab.put("min", "She is a cute");
		System.out.println(tab.get("sung"));
		System.out.println(tab.get("jin"));
		System.out.println(tab.get("hee"));
		System.out.println(tab.get("min"));
	}

}
