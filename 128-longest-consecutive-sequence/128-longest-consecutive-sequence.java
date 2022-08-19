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

// as we have to find the solution in O(n)...so we gonna use hashset to store all the elements first
// then traverse the array and check if an element less 1 not present in hashset...then it means it is the least element
// and we can start counting from that element for elements more 1...so initialize count =1 and that element as curr_element
// then start counting till element+1 presnt in hashset..once element+1 not presemt in hashset update max with max of earlier max and current count value
// this way we will get the max count...so finally return max