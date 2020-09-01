//카카오 인턴쉽 - 키패드 누르기
class Pr200831 {
public static void main(String[] args) {
	int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
	String hand = "right";
	
	solution(numbers, hand);
}
public static int distCompare(int number, int loc) {	//거리 구하기
		if(number == 0) {number = 11;}  //0 -> 11 로 가정
		if(loc == 0){ loc = 11; }       //0 -> 11 로 가정

		//좌표 공식
		int numX = (number - 1) / 3;
		int numY = (number - 1) % 3;
		int locX = (loc - 1) / 3;
		int locY = (loc - 1) % 3;

		return Math.abs(numX - locX) + Math.abs(numY - locY); //거리 구하기(절댓값)
}

public static String solution(int[] numbers, String hand) {
	String answer = "";
	int left = 10, right = 12;  // * -> 10, # -> 12 로 가정 
	int distLToNum, distRToNum;    //각 손의 [현재 숫자판과 이전 숫자판 과의 거리 차]
	
	for(int i = 0; i < numbers.length; i++) {
	     if(numbers[i] ==1 || numbers[i] == 4 || numbers[i] == 7) {
	        answer += "L";
	        left = numbers[i];
	    }
	    else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
	        answer += "R";
	        right = numbers[i];
	    }
	    else {
	    	distLToNum = distCompare(numbers[i], left);  //left - num 거리
	    	distRToNum = distCompare(numbers[i], right); //right - num 거리
	    	
	    	if(distLToNum < distRToNum) {  
	    		answer += "L";  
	    		left = numbers[i];
	    	}
        else if(distLToNum > distRToNum) {  
        	answer += "R"; 
        	right = numbers[i];
        }
        else {  //거리가 같을 경우
          if(hand.equals("left")) {  
       	answer += "L";  
    		left = numbers[i];
    	}
      else {  
        answer += "R"; 
       	right = numbers[i];
      }
    }
}
}
System.out.println(answer);
return answer;
	}
}