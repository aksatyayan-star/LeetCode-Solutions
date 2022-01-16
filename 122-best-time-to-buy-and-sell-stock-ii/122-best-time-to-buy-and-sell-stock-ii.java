class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i]>prices[i-1])
            {
                profit+=(prices[i]-prices[i-1]);
            }
        }
        return profit;
    }
}


//here it may look like that its a complex question to do...bczz of multiple buys and sells
// but when you divide it into parts then its simple like dont go for finding min value then max value and subtracting directly
// else look for every element if i>j and value of j > value of i then find the diff add it to profit...
// so this way you will get cummulative max profit at the end

//ex in [1,2,3,4,5] instead of subracting directly 1 from 5 at once...move in parts 
// like subtract 1 from 2 ...add it to profit...again subtract 2 from 3 add it to profit...
//likewise keep adding to profit till 5 nd you will get the same result as subracting directly 1 from 5 at once