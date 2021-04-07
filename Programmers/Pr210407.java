//찾아라 프로그래밍 마에스터_폰켓몬

import java.util.HashSet;

public class Pr210407 {
	static int max = -999;
	
	public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        
        solution(nums);
	}
	
	public static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); //중복 제거
        
        int length = nums.length;
        int pocketmon = length/2;   //나올 수 있는 최대치
        
        for (int i=0; i<length; i++){
            set.add(nums[i]);
        }

        int size = set.size();
        if(size > pocketmon){   //(중복 제거한 종류 수 > 최대치)일 경우, 무조건 answer = 최대치.
            return pocketmon;
        }
        
        return size;
    }
}
