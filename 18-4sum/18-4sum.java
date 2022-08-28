class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> ls = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums==null || nums.length==0)
        {
            return ls;
        }
        for(int i=0; i<nums.length; i++)
        {
            long target1=target-nums[i];
            for(int j=i+1; j<nums.length; j++)
            {
                long target2 = target1 - ( nums[j]);
                
                int front = j+1;
                int rear = nums.length - 1;
                
                while(front<rear)
                {
                    long sum = nums[front]+nums[rear];
                    
                    if(sum<target2)
                    {
                        front++;
                    }
                    else if(sum>target2)
                    {
                        rear--;
                    }
                    else if(sum-target2==0)
                    {
                        List<Integer> ans = new ArrayList<Integer>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[front]);
                        ans.add(nums[rear]);
                        ls.add(ans);
                        
                        while(front<rear && nums[front] == nums[front+1])
                        {
                            ++front;
                        }
                        while(front<rear && nums[rear] == nums[rear-1])
                        {
                            --rear;
                        }
                        front++;
                        rear--;
                    }
                }
                while(j+1<nums.length && nums[j+1]==nums[j])
                {
                    ++j;
                }
            }
            while(i+1<nums.length && nums[i+1]==nums[i])
            {
                ++i;
            }
        }
        return ls;
    }
}