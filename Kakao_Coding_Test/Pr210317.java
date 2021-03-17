//2019 īī�� ������ �ܿ� ���Ͻ�_ũ���� �����̱� ����[list ����ϴ� ����� ����!]
import java.util.Scanner;

public class Pr210317 {
    static int answer = 0;

	public static void main(String[] args) {
		int board[][] = new int [5][5];
		int moves[] = new int [8];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		System.out.println("moves �Է�");
		for(int i = 0; i < moves.length; i++) {
			moves[i] = sc.nextInt();
		}
		
		System.out.println("moves:"); //1 5 3 5 1 2 1 4
		for(int i = 0; i < moves.length; i++) {
			System.out.print(moves[i] + ", ");
		}
		System.out.println();
		
		System.out.println(solution(board, moves));
		
		sc.close();
	}

	public static int solution(int[][] board, int[] moves) {
        int size = (int) Math.pow(board.length, 2);
        int pop = 0;
        
        int basket[] = new int[size];
        
        for(int m = 0; m < moves.length; m++) { //1 5 3 5 1 2 1 4
        	for(int j = 0; j < board.length; j++) {        		
        		int doll = board[j][moves[m] - 1];
        		
        		if(doll != 0) {	//������ ���� ���
        			board[j][moves[m] - 1] = 0;	//ũ���ο� ���� ����.
        			pop = pop(basket);
        			
        			if(pop != -1 && pop == doll) {	//basket�� ������� ���� & �ֱ� basket�� ������ ��ġ�� ���
        				rmBasket(basket); //���� ���� + result �߰�
        			}
        			//pop(basket) = -1�� ��� -> ���� basket�� ����ִ� ���
        			else {
        				put(basket, doll);
        			}

            		break;
        		}
        	}
        }
        
        return answer;
    }
	
	public static int pop(int[] basket) { //return -1 : ������� , > -1: �� ������� & ���� �ֱٰ� ��ȯ
		int b = 0;
		
		for(b = 0; b < basket.length; b++) {
			if(basket[b] == 0) {	//b���� ���� ����.
				break;
			}
		}
		
		if(b > 0) {	//basket�� ������ 1�� �̻� �����ϴ� ���
			return basket[b - 1];
		}
		return -1;	//basket ����ִ� ���
	}
	
	public static void rmBasket(int[] basket) {
		int b = 0;
		
		for(b = 0; b < basket.length; b++) {
			if(basket[b] == 0) {
				break;
			}
		}
		
		if(b > 0) {	//basket�� ������ 1�� �̻� �����ϴ� ���
			basket[b - 1] = 0;	//���� �ֱ� ���� ����
			
			answer += 2;
		}
	}
	
	public static void put(int[] basket, int doll) {
		int b = 0;
		
		for(b = 0; b < basket.length; b++) {
			if(basket[b] == 0) {
				break;
			}
		}
		
		basket[b] = doll;
	}
	
}
