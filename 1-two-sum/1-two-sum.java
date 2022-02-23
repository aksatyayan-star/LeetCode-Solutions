class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            if(s.contains(sum-nums[i]))
            {
                return true;
            }
            s.add(nums[i]);
        }
        */
        // the above code for just checking if a pair is present or not
        // we traverse array and check if sum-that particular element is present in hashset if yes then true
        // else we insert that elemnt in hashset and do next iteration
        // it means we start from empty hashset...and we keep adding elemnts if sum-that elemnt is not in hashset
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int arr[] = new int[2];
        for(int i = 0 ;i<nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
              arr[0] = i;
              arr[1] = map.get(target - nums[i]); 
            }
            map.put(nums[i],i);
        }
        return arr;
    }
}

// here also kind of same concept is being followed...just we make that element as key and its index as value
// we check if target - that element(x) = y present as key then make arr[0] as x's index which will be i
// as at i we encountered x and extract y's index from map...as we stored it as its value its index
// if not then insert element as key and its index as its value