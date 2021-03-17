//2019 카카오 개발자 겨울 인턴십 - 크레인 인형뽑기 게임       -    list 사용하는 방법도 존재!
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

		System.out.println("moves 입력");
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
        		
        		if(doll != 0) {	//인형이 뽑힌 경우
        			board[j][moves[m] - 1] = 0;	//크레인에 인형 뽑힘.
        			pop = pop(basket);
        			
        			if(pop != -1 && pop == doll) {	//basket이 비어있지 않음 & 최근 basket과 인형이 일치할 경우
        				rmBasket(basket); //인형 제거 + result 추가
        			}
        			//pop(basket) = -1인 경우 -> 아직 basket이 비어있는 경우
        			else {
        				put(basket, doll);
        			}

            		break;
        		}
        	}
        }
        
        return answer;
    }
	
	public static int pop(int[] basket) { //return -1 : 비어있음 , > -1: 안 비어있음 & 가장 최근값 반환
		int b = 0;
		
		for(b = 0; b < basket.length; b++) {
			if(basket[b] == 0) {	//b부터 인형 없음.
				break;
			}
		}
		
		if(b > 0) {	//basket에 인형이 1개 이상 존재하는 경우
			return basket[b - 1];
		}
		return -1;	//basket 비어있는 경우
	}
	
	public static void rmBasket(int[] basket) {
		int b = 0;
		
		for(b = 0; b < basket.length; b++) {
			if(basket[b] == 0) {
				break;
			}
		}
		
		if(b > 0) {	//basket에 인형이 1개 이상 존재하는 경우
			basket[b - 1] = 0;	//가장 최근 인형 제거
			
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
