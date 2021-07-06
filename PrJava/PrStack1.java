//Stack 기본 예시 코드
import java.util.EmptyStackException;
class Stack<T> {	//스택 클래스 (객체 만들 때 데이터 타입을 명시하도록)
	@SuppressWarnings("hiding")
	class Node<T> {	//node.data & node.next 구성
		private T data;	//데이터
		private Node<T> next;	//다음 노드
	
		public Node(T data) {
			
			this.data = data;			
		}
	}
	
	private Node<T> top;	//스택은 맨 위만 알면 됨
	
	public T pop() {	//가장 맨 위 노드 가져옴 && 제거
		if(top == null) {
			throw new EmptyStackException();
		}
		
		T item = top.data;	//맨 위 데이터 빼놓고
		top = top.next;
		return item;	//맨 위에 있던 데이터 반환
	}
	
	public void push(T item) {
		Node<T> t = new Node<T>(item);	//들어온 item 데이터를 t노드로 생성
		
		t.next = top;
		top = t;
	}
	
	public T peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}

public class PrStack1 {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	}
}
