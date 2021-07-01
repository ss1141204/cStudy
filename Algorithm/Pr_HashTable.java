//HashTable ���� �ڵ�
import java.util.LinkedList;

class HashTable {
	class Node {
			String key;	//�˻��� Ű
			String value;	//�˻� ���
			
			public Node(String key, String value) {	//key & value �޾� ��ü�� �Ҵ�
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
	
	LinkedList<Node>[] data;	//data�� ������ linkedList "data" ����, data ����Ʈ�� [] �迭��.
	
	@SuppressWarnings("unchecked")
	HashTable(int size) {	//�ؽ� ���̺� �����ϴ� ���� �ؽ� ���̺� ũ�� ����. �� �޼ҵ� ����Ǵ� ���� ũ�� ������
		this.data = new LinkedList[size];	//�̸� �迭�� ����
	}	//������?
	
	//***�ٽ��Լ�1 - key �޾Ƽ� �ؽ��ڵ� ��ȯ
	int getHashCode(String key) {
		int hashcode = 0;	//�ʱ�ȭ
		for(char c : key.toCharArray()) {
			hashcode += c;	//�� ���ں� �ƽ�Ű�ڵ� ��
		}
		return hashcode;		
	}
	
	//***�ٽ��Լ�2 - �ؽ��ڵ带 �޾� �ε����� ��ȯ
	int convertToIndex(int hashcode) {
		return hashcode % data.length;
	}
	
	//***�ٽ��Լ�3 - list������ key ã�� �ش� ��� ��ȯ
	Node searchKey(LinkedList<Node> list, String key) {
		if (list == null) return null;	//����Ʈ�� ����ִ� ���
		
		for(Node node : list) {	//����Ʈ Ž��
			if(node.key.equals(key)) {	//ã�� key�� ���� ��� Ž��
				return node;	//������ �ش� ��� ��ȯ
			}
		}
		return null;	//ã�� ��� ������ null ��ȯ
	}
	
	//***�ٽ��Լ�4 - key,value ����
	void put(String key, String value) {	//������ key, value ����
		int hashcode = getHashCode(key);	//�ؽ��ڵ� ����
		int index = convertToIndex(hashcode);	//�ε��� ����
		
		LinkedList<Node> list = data[index];//�ش� �ε����� ��ũ�帮��Ʈ �������� Ȯ�� ����   *LinkedList ������ �� �ƴ�!
		if(list == null) {	//�� �����Ͱ� ����ִٸ�? = �ش� �ε����� �����Ͱ� ���ٸ�
			list = new LinkedList<Node>();	//*LinkedList �����Ѵ�.
			data[index] = list;	//�ش��ε����� ����
		}
		
		//�ش� Ű�� �̹� ��尡 �����ϴ� �� Ȯ��
		Node node = searchKey(list, key);	//�ش� ����Ʈ(data[index])���� key Ž��
		
		//Ű �ߺ� x - ���� �߰�
		if(node == null) {
			list.addLast(new Node(key, value));
		}
		else {	//Ű �ߺ� - ��ü(�ߺ�Ű ó��)
			node.setValue(value);
		}
	}
	
	//***�ٽ��Լ�5 - key�� �ش� ��� ��������
	String get(String key) {
		int hashcode = getHashCode(key);
		int index = convertToIndex(hashcode);
		
		LinkedList<Node> list = data[index];	//index��° ���Ḯ��Ʈ
		Node node = searchKey(list, key);	//�ش� ���Ḯ��Ʈ ������ key�����ִ� ��� ã��
		
		return node == null ? "Not Found" : node.getValue();
	}
}

public class Pr_HashTable {
	
	public static void main(String[] args) {
		HashTable tab = new HashTable(3);	//ũ�� 3 ����.
		
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
