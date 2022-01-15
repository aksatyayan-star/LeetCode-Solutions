class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)
        {
            return 0;
        }
        int buy = prices[0];
        int max = prices[1]-buy;
        for(int i=1; i<prices.length; i++)
        {
            int profit = prices[i]-buy;
            max = Math.max(max, profit);
            buy = Math.min(prices[i],buy);
        }
        if(max<=0)
        {
            return 0;
        }
        else 
        {
            return max;
        }
    }
}

// this is kind of same to the maximum-difference-between-increasing-elements problem
// we initialize buy with 1st element ...ie. aassume that we buy the stock the very 1st day
// and sell the next day and assume we got max profit..so initialize max with the value of diff bw them
// now assuming these two conditions we iterate the whole loop and keep track of max profit and min buy value
// just like in the maximum-difference-between-increasing-elements problem
// nd if max profit is negative then we return 0 else return the max value