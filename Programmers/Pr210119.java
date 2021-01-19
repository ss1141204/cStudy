//코딩테스트 연습 - 깊이/너비 우선 탐색(DFS/BFS) - 네트워크   >> 나중에 다시 풀어보기

import java.util.Scanner;

public class Pr210119 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.print("n 입력: ");
		int n = sc.nextInt();
		
		System.out.println("배열 입력: ");

		int[][] computers = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				computers[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(solution(n, computers));
		
		sc.close();
	}

	public static int solution(int n, int[][] computers) {
        int answer = 0;
        int half = n / 2;
        
        if(n % 2 != 0) {
        	half += 1;
        }
        
        int[] conn = new int[n];
        
        for(int i = 0; i < half; i++) {
			for(int j = 0; j < n; j++) {
				if((i != j) && computers[i][j] == computers[j][i] && computers[i][j] == 1) {
					if(conn[i] == 0 && conn[j] == 0) {	//i, j 모두 기록이 없다면						
						answer++;	//네트워크 생성
						conn[i] = 1;
						conn[j] = 1;
                    }
					else if(conn[i] == 0){ // i 기록 없으면
						conn[i] = 1;
					}
					else {	//j 기록 없으면
						conn[j] = 1;
					}
				}
			}
		}
        
        for(int k = 0; k < conn.length; k++) {
        	if(conn[k] == 0) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
}
