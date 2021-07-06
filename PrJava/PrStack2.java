//스택을 이용한 정렬 알고리즘
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
		
		while(!s1.isEmpty()) {//내림차순 정렬
			int tmp = s1.pop();
			
			while(!s2.isEmpty() && s2.peek() > tmp) {	//s2의 맨 위 값 > tmp 인 경우, s2가 다 비워질 때까지 반복
				s1.push(s2.pop());
			}
			s2.push(tmp);	//tmp와 s2의 모든 원소를 크기 비교해야 정렬되기 때문에 while문 밖에서 tmp 삽입
		}
		
		while(!s2.isEmpty()) {	//s2스택의 모든 값을 s1으로 옮기면서 오름차순 정렬 
			s1.push(s2.pop());
		}
	}
}
