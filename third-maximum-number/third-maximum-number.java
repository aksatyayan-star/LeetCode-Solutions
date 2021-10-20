class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int i=1;
        int max = nums[nums.length-1];
        for(int j=nums.length-1;j>0;j--){
            if(nums[j]!=nums[j-1])
                i++;
            if(i==3)
                max=nums[j-1];
        }
        return max;
    }
}

// Here the concept is pretty much simple
// first you sort the array
// then run a loop in the reverse direction so that we can start with the max number
// so everytime when we will encounter an element different from the previous element 
// we increase var i by one unit....i.e we increase the count
// so as we need third largest , hence whenever our that i count equals three
// it means we have encountered three elements till now which are distinct
// and as we started from the reverse direction i.e from the largest element as sorted array
// hence encountring 3rd distinct element means we have encountered 3rd largest element
