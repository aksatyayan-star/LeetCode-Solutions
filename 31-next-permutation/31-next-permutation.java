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
// then we swap that previous element i.e i-1 brk point element with again the element we again search from end till this element that we got and the first element that we encounter greater than this 
// we store its index in next...nd we call swap function for these two indices brk and next...and do the req swapping...once that swapping done
// along with that we also maintain a bool var...which we set true if there is some element greater than its previous element from the end side
// else bool false...so if bool true and after swapping done we will sort rest elements of array from one element next to brk point i.e brk+1 till last of array
// else if bool false...then just simply sort the whole array as that means there were no elements greater than its previous element from the end side of array...nums = [3,2,1]...this case