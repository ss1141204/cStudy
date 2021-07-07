import java.util.NoSuchElementException;

//큐 구현하기
class Queue<T> {
	
	@SuppressWarnings("hiding")
	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		
		private Node<T> first;
		private Node<T> last;
		
		public void add(T item) {
			Node<T> t = new Node<T>(item);
			
			if(last != null) {	//데이터 삽입 시, 큐 안에 이미 어떤 값이 존재하고 있는 경우
				last.next = t;	//마지막 데이터에 t연결
			}
			last = t;
			
			if(first == null) {	//큐가 비어있는 경우
				first = last;	//같은 값을 할당해준다.
			}
		}
		
		public T remove() {
			if(first == null) {
				throw new NoSuchElementException();
			}
			
			T data = first.data;	//데이터 임시 저장
			first = first.next;	//first는 다음 데이터로
			
			if (first == null) {	//first가 null이 되었을 경우
				last = null;	//last도 null이 됨!
			}
			
			return data;
		}
		
		public T peek() {
			if(first == null) {
				throw new NoSuchElementException();
			}
			
			return first.data;
		}
		
		public boolean isEmpty() {
			return first == null;
		}
	}

}

public class PrQueue1 {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();

	}

}
