class Solution {
    public void nextPermutation(int[] nums) {
        int brk=0;
        int next = 0;
        boolean per = false;
        if(nums.length==1)
        {
            return;
        }
        /*if(nums.length==2)
        {
            if(nums[0]<nums[1])
            {
                swap(nums,0,1);
            }
            else
            {
                return;
            }
        }
        */
        for(int i=nums.length-1; i>=1; i--)
        {
            if(nums[i]>nums[i-1])
            {
                brk = i-1;
                //swap(nums[i],nums[i-1]);
                per = true;
                for(int j=nums.length-1; j>brk; j--)
                {
                    if(nums[j]>nums[brk])
                    {
                        next = j;
                        break;
                    }
                }
                swap(nums, next, brk);
                break;
            }
        }
        if(per==true)
        {
            Arrays.sort(nums, brk+1, nums.length);
        }
        else
        {
            Arrays.sort(nums);
        }
    }
    
    void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

// the solution is tricky little bit what we doing is that we find a element from end side of array if we encounter an element greater than its previous element from the end side
// then we swap those 