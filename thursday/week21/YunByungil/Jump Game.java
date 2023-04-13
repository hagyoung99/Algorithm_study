package 리트코드.JumpGame_55;

public class ReMain {
    public static int[] nums = {3, 2, 1, 0, 4};

    public static void main(String[] args) {

    }

    public static boolean canJump() {
        int goal = nums.length - 1;
        int maxIdx = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            maxIdx = Math.max(maxIdx, i + nums[i]); // idx + nums[idx]가 점프해야하는 위치값
            System.out.println("maxIdx = " + maxIdx);
            if(maxIdx <= i){    // maxIdx의 값이 대상 위치 인덱스보다 작을 경우 더이상 진행이 불가능하다.
                return false;
            }else if(maxIdx >= goal) {   // maxIdx의 값이 루프가 돌기전에 이미 마지막 값을 넘겼다면 통과
                return true;
            }
        }
        return false;
    }
}
