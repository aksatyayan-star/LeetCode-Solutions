class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> gpairs = new HashMap<>();
        int pairs = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(gpairs.containsKey(nums[i]))
            {
                int val = gpairs.get(nums[i]);
                pairs = pairs+val;
                gpairs.put(nums[i],val+1);
            }
            else
            {
                gpairs.put(nums[i],1);
            }
        }
        return pairs;
    }
}

//the concept is simple ... we create a hashmap where key is the element itself and value is the count of it
// so what we do we traverse the array and if we find some repeating element i.e element already present in hashmap then we get its value
// i.e its count stored in hashmap and we update our pairs by adding that count as we found one same element so bczz of this a new good pair is possible
// hence update pair count by that value...then again put this element as key and its value updated by 1 in hashmap
// else if new element encountered then simply put it in hashmap with value as 1 ..as 1st time encountered so count will be 1
// nd no updation in pairs as this element is single so no same value pairs possible with it
// at the end ...just return the pairs