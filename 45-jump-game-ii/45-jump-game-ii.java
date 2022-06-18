class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1; i<n; i++)
        {
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j<i; j++)
            {
                if(nums[j]+j>=i)
                {
                    if(dp[j]!= Integer.MAX_VALUE)
                    {
                        dp[i] = Math.min(dp[i],dp[j]+1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}


// so we are applying the same logic of recursion in form of tabulation solution...here as only one parameter was changing i.e the length of array so 1d array
// nd each dp[i] represents the no of min jumps req to reach index i in the given array...like assuming array of length i+1 only and so reaching last index i.e i
// hence dp[0] = 0 as no jumps are req to reach index 0 of array as that's the only element...
// then for next elements we first initialize dp[i] as infinite and then we run second loop to traverse nums array nd we check
// the same thing i.e element's position(j) + element's value(dp[j]) if greater than i...as here i only represents the last index of array...
// then again we check if dp[j] not infinite then only we update dp[i] with min of earlier dp[i] and current dp[j] +1 ....
// +1 is for counting the jump...as this element is considerd as we didnt get dp[j]= infinite then only we got into this if condition...
// this not infinite checker is for same reason that the element which is taking to last element...for that taker element even we dont have way to reach ...
// as may be 0 elements in bw as we discussed in memo solution in gfg practice solution
// and finally we return last value of array as there i equal to length of given array so that is the ans for array of our given size

// like the concept is inside j for loop we check if we can reach i from jth element..
// and inside that loop's if(dp[j]!=integre.maxvalue) condition we check that can we reach that jth element from beginning through which we are reaching i...
// if yes then we update it with min jumps value..else we ignore it and do nothing..nd like wise next iteration runs