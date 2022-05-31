class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length*2];
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=nums[i];
            arr[i+nums.length]=nums[i];
        }
    return arr;
    }
}


// its a simple solution...just make an array double the size of given array
// and in that insert elements like the given condition in ques that ans[i] == nums[i] and ans[i + n] == nums[i]...that's it
// nd we will get our req array