//ã�ƶ� ���α׷��� ��������_���ϸ�

import java.util.HashSet;

public class Pr210407 {
	static int max = -999;
	
	public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        
        solution(nums);
	}
	
	public static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); //�ߺ� ����
        
        int length = nums.length;
        int pocketmon = length/2;   //���� �� �ִ� �ִ�ġ
        
        for (int i=0; i<length; i++){
            set.add(nums[i]);
        }

        int size = set.size();
        if(size > pocketmon){   //(�ߺ� ������ ���� �� > �ִ�ġ)�� ���, ������ answer = �ִ�ġ.
            return pocketmon;
        }
        
        return size;
    }
}
