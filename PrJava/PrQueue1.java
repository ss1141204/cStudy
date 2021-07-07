import java.util.NoSuchElementException;

//ť �����ϱ�
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
			
			if(last != null) {	//������ ���� ��, ť �ȿ� �̹� � ���� �����ϰ� �ִ� ���
				last.next = t;	//������ �����Ϳ� t����
			}
			last = t;
			
			if(first == null) {	//ť�� ����ִ� ���
				first = last;	//���� ���� �Ҵ����ش�.
			}
		}
		
		public T remove() {
			if(first == null) {
				throw new NoSuchElementException();
			}
			
			T data = first.data;	//������ �ӽ� ����
			first = first.next;	//first�� ���� �����ͷ�
			
			if (first == null) {	//first�� null�� �Ǿ��� ���
				last = null;	//last�� null�� ��!
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
