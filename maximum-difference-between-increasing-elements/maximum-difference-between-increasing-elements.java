class Solution {
    public int maximumDifference(int[] nums) {
        if(nums.length==1)
        {
            return -1;
        }
        int result = nums[1]-nums[0];
        int min = nums[0];
        for(int j=1; j<nums.length; j++)
        {
           result = Math.max(result, nums[j]-min);
           min = Math.min(min, nums[j]);
        }
        if(result <= 0)
        {
            return -1;
        }
        else
        {
            return result;
        }
    }
}

// here the logic is like if there is a single element in array then simply return -1
// if not then as we have to subtract j element from j+1 element...so first such pair will be subtracting 0th element from 1st element...so initialize result with that value
// and also assume min value as 0th element in the starting...as we will move forward and encounter more values we will keep updating it accordingly
// so what we do is that for every element we encounter , we subtract it from min and then check if this result is greater that previous result, if yes then we update result with this value
// and we also check that the element that we just encountered , is it also smaller than the elements we had encountered earlier, if yes then we also update min with this value
// so by this way for every element encountered we keep track of result..i.e(max diff) and min value