class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int i=1;
        int max = nums[nums.length-1];
        for(int j=nums.length-1;j>0;j--){
            if(nums[j]!=nums[j-1])
                i++;
            if(i==3)
                max=nums[j-1];
        }
        return max;
    }
}