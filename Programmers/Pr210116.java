//���α׷��ӽ�_�ڵ��׽�Ʈ ����_������ȹ��(Dynamic Programming) > ���� �ﰢ��				//-> ó�� ���Ǹ�ŭ �迭ũ�� �������ֵ���!
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
				if(i == 0) { continue;}	//start����
				else if(j == 0) {	
					triangle[i][j] += triangle[i-1][j];		
				}	//�� ���� ��
				else if(i == j) {	
					triangle[i][j] += triangle[i-1][j-1];
				}	//�� ������ ��
				else {
					triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];	//�� ū �� ����
				}
				
                answer = Math.max(answer, triangle[i][j]);
			}
        }
        
        return answer;
    }

}
