class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        
        int a=0; 
        int b=0;
        int c1=0;
        int c2=0;
        
        for(int i=0; i<nums.length; i++)
        {
            if(a==nums[i])
            {
                c1++;
            }
            else if(b==nums[i])
            {
                c2++;
            }
            else if(c1==0)
            {
                a=nums[i];
                c1++;
            }
            else if(c2==0)
            {
                b=nums[i];
                c2++;
            }
            else
            {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int j=0; j<nums.length; j++)
        {
            if(nums[j]==a)
            {
                c1++;
            }
            else if(nums[j]==b)
            {
                c2++;
            }
        }
        if(c1>nums.length/3)
        {
            ans.add(a);
        }
        if(c2>nums.length/3)
        {
            ans.add(b);
        }
        return ans;
    }
}

// the concept is extended version of majority element 1 problem...as there..there was only one majority element...nd here there can be atmost 2 majority elements > n/3 times
// so we are doing almost the same thing...we have a = 0 and b = 0 initialized and its count c1 and c2 also initialized to 0
// then we run loop and as we encounter a = nums[i] and b = nums[i] we increase respective counts...
// else if we have both counts = 0...then we make that a and b as that particular element i.e nums[i] and also increase both counts by 1 respectively after that
// if not any of these cases then simply decrement both counts by 1

// then we have got a and b which are elements having maximum occurences but we also have to check that these occurences are greater than n/3 times or not
// so we again reinitialize both count to 0 and then run the loop and check if nums[j] = a and num[j] = b then increase both counts respectively
// and finally after the end of loop check that if both counts greater than n/3 times then respectively add those elements in the arraylist..nd finally return it