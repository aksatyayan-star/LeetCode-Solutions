class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        /*for(int i=0 ; i<size ; i++)
        {
            if(size==0)
            {
                return 0;
            }
            if(size==1)
            {
                if(nums[size-1]==0)
                {
                    return 1;
                }
                return 0;
            }
            if(i==size-1)
            {
                if(nums[i]!=nums[i-1]+1)
                {
                    return nums[i-1]+1;
                }
            }
            else if(nums[i+1]!=nums[i]+1)
            {
                return nums[i]+1;
            }
            if(nums[size-1]==size-1)
            {
                return nums[size-1]+1;
            }
        }
        return -1;
        */
        for(int i=0; i<size; i++)
        {
            if(i!=nums[i])
            {
                return i;
            }
            else if(nums[size-1]==size-1)
            {
                return size;
            }
        }
        return -1;
    }
}

// simply sort the array first...then run a loop and check if each succeeding element is 1 greater that preceeding element then fine
// else where we get succeeding element not equal to 1 more than preceeding element...that means that item...preceeding element + 1 is missing
// so return preceeding element+1
// extra condition for last index as i+1 will get out of bounds

// or just a simple trick after sorting if i = nums[i] then fine else that element is missing so return i...