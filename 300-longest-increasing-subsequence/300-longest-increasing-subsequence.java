class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //return LIS(nums, n, n-1);
        int[] lis = new int[n];
        lis[0] = 1;
        for(int i=0; i<n; i++)
        {
            lis[i] =1;
            for(int j=0; j<i; j++)
            {
                if(nums[j]<nums[i])
                {
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int res = 0;
        for(int k=0; k<n; k++)
        {
            res = Math.max(res,lis[k]);
        }
        return res;
    }
    /*
    int LIS(int[] nums, int n, int s)
    {
        if(s==0 && n-1!=s)
        {
            //return 0;
            return LIS(nums, n-1, s+1);
        }
        if(s==0 && n-1==s)
        {
            return 0;
        }
        if(n==0)
        {
            return 0;
        }
        if(nums[n-1]>nums[s-1])
        {
            return 1+LIS(nums, n-1, s-1);
        }
        else
        {
            return Math.max(LIS(nums,n, s-1),LIS(nums,n-1,s-1));
        }
        */
}

// here the conecpt is that we maintain a lis array where we store the length of longest increasing subsequence ending with element at that index of the nums array
// hence we initialize lis[0] as 1 as its the corresponding length of Longest Increasing Subsequence ending with 0th index i.e 1st element of nums array...as that is the only element...no element before it
// and then for corresponding elements..first we make its LIS as 1 as min it will be 1..ie the element itself will be its LIS which is of length 1 so 1
// hence inside 1st for loop we first initialize LIS corresponding to that index element in lis array as 1 so lis[i] =1
// lis array element of index i corresponds to lis of element at i th index of nums array...ie by the index we can relate nums array elements and lis array elements
// then inside the 2nd loop we check that the now element ...i.e ..the element we currently at by traversing for all the previous elements before 
// and storing their lis in lis array corresponding to their indexes of nums array....now we have reached some element i for which we have to find lis
// so we will check if that i element greater than j elements j will be traversing all the elements before it(i.e i element)...as then only we can decide its increasing or not
// if i greater than for some j element then we can append this i element with j element and it will be no prob and will form an increasing subsequence
// and now the new length of this increasing subsequence will increase by 1 whatever it was earlier for that j element...hence lis[j]+1
// and this for a particular i...can happen for many j elements ...as many elements in the range of 0 to i-1 can be smaller than current i element
// but as we need longest LIS so we need to take the max of them...i.e for a particular i th element appending it to which of the j elements will give the max lis 
// that we will append and again this max will finally get stored in lis[i] location corresponding to the index of that element of nums array which was i...
// so that for next iteration for element next and next and next to i and so on we can always get the max lis for previous elements 
// and can append it or not depending on the condition and like this getting max of it and storing it to get max lis again
// like this we will store for all the elements their lis in lis array corresponding to their indexes of nums array
// nd finally return the max from this lis array...as that will be the lis for whole array...i.e the max among the lis of each elements of that array 
// will be the max or lis of array as a whole...as array made up of those elements..