class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);
        
        fast = nums[0];
        while(slow!=fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

// here this is a cycle in linked list converted approach...in first loop we move slow pointer one at a time and fast pointer two at a time
// this does what it forms cycle and the starting point of the cycle is the duplicate number...as then only it will be connected twice 
// bczz we got directed towards it twice hence it formed a cycle and hence it is the duplicate element
// so once slow becomes equal to fast...stop the upper loop and leave slow as it as at its position where both met...but move fast to starting position
// and again start the second loop but this time move both slow and fast the same way i.e one position at a time...and the second time..where they meet will be the duplicate element


// we also have approaches like multiply each element by -1   or   make an array and initialize it to 0 and as you encounter elements in nums array the corresponding index in our taken array make it as 1...
// so if repeated we will encounter 1 in our taken array instead of 0 when we will encounter that element for the second time as at the first encounter we made the element 1
// so that will be our duplicate element