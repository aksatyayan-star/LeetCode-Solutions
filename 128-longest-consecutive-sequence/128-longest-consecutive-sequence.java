class Solution {
    public int longestConsecutive(int[] nums) {
        int count=1;
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
                max = Math.max(max,count);
                
            }
            else
            {
                max = Math.max(max,count);
                count = 1;
            }
        }
        return max;
    }
}