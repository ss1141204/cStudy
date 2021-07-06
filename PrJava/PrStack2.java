//������ �̿��� ���� �˰���
public class PrStack2 {

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<>();
		
		s1.push(3);
		s1.push(5);
		s1.push(1);
		s1.push(6);
		
		sort(s1);
		
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
	}

	public static void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		
		while(!s1.isEmpty()) {//�������� ����
			int tmp = s1.pop();
			
			while(!s2.isEmpty() && s2.peek() > tmp) {	//s2�� �� �� �� > tmp �� ���, s2�� �� ����� ������ �ݺ�
				s1.push(s2.pop());
			}
			s2.push(tmp);	//tmp�� s2�� ��� ���Ҹ� ũ�� ���ؾ� ���ĵǱ� ������ while�� �ۿ��� tmp ����
		}
		
		while(!s2.isEmpty()) {	//s2������ ��� ���� s1���� �ű�鼭 �������� ���� 
			s1.push(s2.pop());
		}
	}
}
