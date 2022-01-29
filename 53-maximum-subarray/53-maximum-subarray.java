class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxEnding = nums[0];
        for(int i = 1; i<nums.length; i++)
        {
            maxEnding = Math.max(maxEnding+nums[i], nums[i]);
            sum = Math.max(maxEnding , sum);
        }
        return sum;
    }
}



// so here like for solving max subarray problems kadene's algo is the most popular and preferred method
// in kadene's what we do is first assume 1st element as sum and max ending
// then we traverse starting from 2nd element, and assuming that , that elemnt is the ending element of that subarray...
//likewise we consider further particular element in coming iterations as the ending elemnt of that subarray 
//and we check that how we get max sum for that subarray by adding the previous element(or prev maxEnding or you can say max sum upto that element) to that element or by just taking that particular element individually...whichever max is the next maxEnding
// and if that is greater than the sum then we update sum also..else we move on to next iteration