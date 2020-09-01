//2019 KAKAO BLIND RECRUITMENT - ������(7, 9, 13���̽����� �ڲ� Ʋ�� ������ �� ã�ƺ��� �� ����)
import java.util.Arrays;
import java.util.Comparator;

class StageRate {
	int stage;
	double rate;

	public StageRate(int stage, double rate) {
		this.stage = stage;
		this.rate = rate;
	}
}

public class Pr200901 {

	public static void main(String[] args) {
		int n = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		solution(n, stages);
	}

	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double fail;
        double success;
        double rate;
        
        StageRate[] stageRate = new StageRate[N];
        
        for(int j = 0; j < N; j++) {	//5
        	fail = 0.0;
        	success = 0.0;
        	for(int i = 0; i < stages.length; i++) {	//8
        		if(stages[i] == (j + 1)) {	fail++;	}
        		if(stages[i] >= (j + 1)) {	success++;	}
        	}
        	
        	try {
        		rate = fail / success;
        		stageRate[j] = new StageRate(j + 1, rate);	//�� �ܰ躰 ������ �迭 ����
        	} catch (ArithmeticException e) {
        		stageRate[j].rate = 0.0;
        	}
        }
        
        for(int i = 0; i < stageRate.length; i++) {
        	System.out.println(stageRate[i].rate);
        }

        Arrays.sort(stageRate, new Comparator<StageRate>()	//�������� ����
        {
            @Override
            public int compare(StageRate s1, StageRate s2){
                if(s1.rate == s2.rate)
                    return 0;
                else if(s1.rate > s2.rate)
                    return -1;
                else
                    return 1;
            }
        });

        System.out.println("������");
        for(int i = 0; i < stageRate.length; i++) {
        	System.out.println(stageRate[i].rate);
        }
        System.out.println();
        
        for(int i = 0; i < stageRate.length; i++) {
        	answer[i] = stageRate[i].stage;
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
}