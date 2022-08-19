class Solution {
    public int longestConsecutive(int[] nums) {
        /*int count=1;
        int max = 1;
        if(nums.length==0)
        {
            return 0;
        }
        Set<Integer> ts = new TreeSet<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            ts.add(nums[i]);
        }
        
        int n = ts.size(); 
        Integer arr[] = new Integer[n]; 
        arr = ts.toArray(arr);
        
        for(int i=0; i<arr.length-1; i++)
        {
            if(arr[i+1]-arr[i]==1)
            {
                count++;
                //max = Math.max(max,count);
                
            }
            else
            {
                count = 1;
            }
            max = Math.max(max,count);
        }
        return max;
        */
        int max = 1;
        if(nums.length==0)
        {
            return 0;
        }
        Set<Integer> hs = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            hs.add(nums[i]);
        }
        for(int i=0; i<nums.length; i++)
        {
            if(!hs.contains(nums[i]-1))
            {
                int curr_num = nums[i];
                int count = 1;
                while(hs.contains(curr_num+1))
                {
                    curr_num++;
                    count++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}

//as we have to find the solution in O(n)