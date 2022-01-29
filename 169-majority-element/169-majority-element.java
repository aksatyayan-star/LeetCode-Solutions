class Solution {
    public int majorityElement(int[] nums) {
        // 1st phase
        int res = 0;
        int count = 1;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[res]==nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
            if(count == 0)
            {
                res = i;
                count = 1;
            }
        }
        // 2nd phase
        count = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[res]==nums[i])
            {
                count++;
            }
        }
        if(count<=nums.length/2)
        {
            res = -1;
        }
        return nums[res];
    }
}




// for majority element question, the most famous nad preferred method is Boyer-Moore Majority Voting Algorithm
// it works in two phase , 1st phase - finding candidate...i.e if there is a majority element in the array then this candidate is the one
// in 2nd phase it checks that candidate found in 1st phase is actually a majority as there could be conditions when there is no majority elemnt in the array
// now here in this ques ...You may assume that the majority element always exists in the array..is written ...so no need of 2nd phase
// now coming to the working...we initialize 1st element as the majority(here its index res is set to 0 initiality which means the same) and initialize its count =1 ...
// now we traverse from 2nd element and check if this is same as majority element we selected ....if yes then we increase the count...else decrease the count
// if count becomes 0 , we reset the count to 1 and majority i.e res to that particular i where count became 0
// finally return element at res index