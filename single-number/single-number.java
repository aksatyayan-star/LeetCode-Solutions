class Solution {
    public int singleNumber(int[] nums) {
        int n =0;
        for(int i=0;i<nums.length;i++)
        {
            n = n ^ nums[i];
        }
        return n;
    }
}

// what im doing here is bitwise operation
// its a very easy question so to make it a little bit challenging i used some diff concept of bitwise operations
// im using xor it takes two values and returns true if they are different; otherwise returns false. In binary, the true is represented by 1 and false is represented by 0