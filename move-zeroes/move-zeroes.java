class Solution {
    public void moveZeroes(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++)
        {
            if (nums[i]!=0)
            {
                swap(nums, i , count);
                count++;
            }
        }
    }
    public void swap(int[] nums, int i, int count)
    {
       	int temp = nums[i];
  	    nums[i] = nums[count];
  	    nums[count] = temp;
    }
}

//so here what we are doing is that whenever we are encountering a non zero number we are swapping it with the position of 1st occurence of zero in the array.
// And we are making sure of the position of 1st occurence of zero by the help of count...(which is initially 0) as whenever we encouter a non zero number we swap it and increase count...so that tells us the position of 1st occurence of zero in next iteration and so on. 
// like here we have [0,1,0,3,12], so if we encounter zero we have nothing to do with it
// so 1st non zero no we encounter is 1 at i=1 and at that time..count = 0 as it was initialized to 0..so now we will swap number at i with number at count index i.e number at 1st index will be swapped with number at 0th index...and count = 1
// now array is [1,0,0,3,12]...and count = 1
// the next non zero number encountered is 3 at index i = 3...so now again swap number at i with number at count index i.e number at 3rd index will be swapped with number at 1st index as now count was 1...and after swapping count = 2.
// now array is [1,3,0,0,12] and count = 2 so again we will have same operation and we can clear observe that the count is actually storing the index of 1st occurence of zero after each swapping and in each iteration.