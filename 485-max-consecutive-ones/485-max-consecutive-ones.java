class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==0)
            {
                count=0;
            }
            else
            {
                count++;
                res = Math.max(res, count);
            }
        }
        return res;
    }
}

// here what we are doing is that whenever we encounter 0 we reset count as 0...
// else we keep increasing count and keep updating res with max of both res and count
//so that value of consecutive 1s can be stored in res....and now we can again count for next consecutive nos of 1 and update that in count
// and will update res only if count > res now
