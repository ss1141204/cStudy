//카카오_컬러링북
public class Pr210408 {
	static boolean visited[][] = new boolean[100][100];	//false
	static int size;
	static int max = 0;
    
	public static void main(String[] args) {
		int[][] picture = {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0}, {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};
		solution(13, 16, picture);
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;        
        
        for(int i = 0; i < picture.length; i++) {
        	for(int j = 0; j < picture[i].length; j++) {
        		if(picture[i][j] != 0 && !visited[i][j]) {	//영역이 존재하고, 방문하지 않은 경우
        			System.out.println("pic[" + i + "][" + j + "]: " + picture[i][j]);
        			visited[i][j] = true;
        			
        			if(i-1 >= 0) {
        				if(picture[i-1][j] != picture[i][j]) {
        					//newArea()
        				}
        			}
        			if((picture[i-1][j] != picture[i][j] && (i-1) >= 0) ||	//상
        				(picture[i+1][j] != picture[i][j] && (i+1) < picture.length) ||	//하
        				(picture[i][j-1] != picture[i][j] && (j-1) >= 0) ||	//좌
						(picture[i][j+1] != picture[i][j] && (i+1) < picture[i].length))	//우     
        			{	//다른 영역인지 확인
        				answer[0]++;
            			size = 1;
            			System.out.println("ans[0]: " + answer[0]);
        			}
        			
        			if((i+1) < picture.length) {
        				findArea(i + 1, j, picture, picture[i][j]);
        			}
        			if((j + 1) < picture[i].length) {
        				findArea(i, j + 1, picture, picture[i][j]);
        			}
        			if(max < size) {
        				max = size;
        			}
        		}
        	}
        }
        answer[1] = max;
        
        System.out.println(answer[0] + ", " + answer[1]);
        
        return answer;
    }
	
	public static void findArea(int i, int j, int[][] picture, int start) {
		if(!visited[i][j]) {
			if(picture[i][j] == start) {
    			System.out.print("pic[" + i + "][" + j + "]: " + picture[i][j] + ", ");
    			System.out.println("start: " + start);
    			
				visited[i][j] = true;
				size++;

				if((i+1) < picture.length) {
    				findArea(i + 1, j, picture, picture[i][j]);
    			}
    			if((j + 1) < picture[i].length) {
    				findArea(i, j + 1, picture, picture[i][j]);
    			}
			}
		}
	}
}