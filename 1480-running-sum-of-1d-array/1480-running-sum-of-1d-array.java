class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum = sum+nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}

//its a simple situation..just find the moving sum and keep updating the nums array alongwith that sum value