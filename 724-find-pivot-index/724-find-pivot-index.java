class Solution {
    public int pivotIndex(int[] nums) {
        int rsum=0;
        int lsum=0;
        for(int i=0; i<nums.length; i++)
        {
            rsum = rsum+nums[i];
        }
        for(int j=0; j<nums.length; j++)
        {
            rsum = rsum-nums[j];
            if(lsum==rsum)
            {
                return j;
            }
            else{
                lsum = lsum+nums[j];
            }
        }
        return -1;
    }
}