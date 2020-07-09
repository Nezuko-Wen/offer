/**
 * 从n长度包含1-n数字的数组中找出任一重复数
 */
public class Question_1 {
    private static int repeatNum = 0;
    public static void main(String[] args) {
        int[] nums = new int[10];
        if (searchRepeatNum(nums)){
            System.out.println(repeatNum);
        }
    }

    public static boolean searchRepeatNum(int[] nums){
        boolean result = false;
        if (nums == null || nums.length <= 0){
            return result;
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i){
                if (nums[nums[i]] == nums[i]){
                    repeatNum = nums[i];
                    return true;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = nums[i];
            }
        }
        return result;
    }
}
