class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int len = nums.length - 1;
        for(int i=0; i< len; i++)
        {
            if(nums[i+1]!=nums[i])
            {
                nums[count]=nums[i+1];
                count++;
            }
        }
        return count;
    }
}


// so here what we are doing is that we have to remove duplicates and remove extra spaces that those duplicates are occupying and also keeping the order of elements same
// hence what we do is that we initialize count to 1 as there will be min one unique element in the array
// and the count also helps us in keeping track of the index at which next distinct element can be inserted so that extra spaces could be removed
// so that distinct elements be in the consecutive manner in the same order
// hence whenever we encounter an distinct element 
// we insert that element at count index and increase the count further by 1
// so by this way count is also keeping track of total number of the distinct elements in the array till then and also telling us the index at which we can insert the next distinct element
// hence final value of count will tell us the size of the new array after removing all the duplicates.