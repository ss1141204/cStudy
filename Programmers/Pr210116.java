//프로그래머스_코딩테스트 연습_동적계획법(Dynamic Programming) > 정수 삼각형				//-> 처음 조건만큼 배열크기 생성해주도록!
import java.util.Scanner;

public class Pr210116 {

	public static void main(String[] args) {
		int[][] triangle = new int[5][5];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < triangle.length; i++) { 
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = sc.nextInt();
			}
		}
		
		System.out.print(solution(triangle));
		
		sc.close();
	}

	
	public static int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i = 0; i < triangle.length; i++) {
			for (int j = 0; j <= i; j++) {
				if(i == 0) { continue;}	//start지점
				else if(j == 0) {	
					triangle[i][j] += triangle[i-1][j];		
				}	//맨 왼쪽 줄
				else if(i == j) {	
					triangle[i][j] += triangle[i-1][j-1];
				}	//맨 오른쪽 줄
				else {
					triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];	//더 큰 값 추출
				}
				
                answer = Math.max(answer, triangle[i][j]);
			}
        }
        
        return answer;
    }

}
