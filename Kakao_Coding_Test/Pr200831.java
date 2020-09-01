//īī�� ���Ͻ� - Ű�е� ������
class Pr200831 {
public static void main(String[] args) {
	int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
	String hand = "right";
	
	solution(numbers, hand);
}
public static int distCompare(int number, int loc) {	//�Ÿ� ���ϱ�
		if(number == 0) {number = 11;}  //0 -> 11 �� ����
		if(loc == 0){ loc = 11; }       //0 -> 11 �� ����

		//��ǥ ����
		int numX = (number - 1) / 3;
		int numY = (number - 1) % 3;
		int locX = (loc - 1) / 3;
		int locY = (loc - 1) % 3;

		return Math.abs(numX - locX) + Math.abs(numY - locY); //�Ÿ� ���ϱ�(����)
}

public static String solution(int[] numbers, String hand) {
	String answer = "";
	int left = 10, right = 12;  // * -> 10, # -> 12 �� ���� 
	int distLToNum, distRToNum;    //�� ���� [���� �����ǰ� ���� ������ ���� �Ÿ� ��]
	
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
	    	distLToNum = distCompare(numbers[i], left);  //left - num �Ÿ�
	    	distRToNum = distCompare(numbers[i], right); //right - num �Ÿ�
	    	
	    	if(distLToNum < distRToNum) {  
	    		answer += "L";  
	    		left = numbers[i];
	    	}
        else if(distLToNum > distRToNum) {  
        	answer += "R"; 
        	right = numbers[i];
        }
        else {  //�Ÿ��� ���� ���
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