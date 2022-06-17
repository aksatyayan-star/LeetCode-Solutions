class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        int[] memo = new int[amount+1];
        for(int i=0; i<amount+1; i++)
        {
            memo[i] = Integer.MAX_VALUE;
        }
        int x = minCoins(coins,amount,memo);
        if(x==Integer.MAX_VALUE)
        {
            return -1;
        }
        return x;
        */
        int[] dp = new int[amount+1];
	    dp[0] = 0;
	    for(int i=1; i<amount+1; i++)
	    {
	        dp[i] = Integer.MAX_VALUE;
	        for(int j=0; j<coins.length; j++)
	        {
	            if(coins[j]<=i)
	            {
	                int sub_res = dp[i-coins[j]];
	                if(sub_res!=Integer.MAX_VALUE)
	                {
	                     dp[i] = Math.min(dp[i],sub_res+1);
	                }
	            }
	        }
	    }
	    if(dp[amount]==Integer.MAX_VALUE)
	    {
	        return -1;
	    }
	    return dp[amount];
    }
        /*
        int minCoins(int[] coins, int amount, int[] memo)
        {
            if(memo[amount]!=Integer.MAX_VALUE)
            {
                return memo[amount];
            }
            if(amount==0)
            {
                //return 0;
                memo[amount] = 0;
            }
            else
            {
                //int res = Integer.MAX_VALUE;
                for(int i=0; i<coins.length; i++)
                {
                    if(coins[i]<=amount)
                    {
                        int sub_res = minCoins(coins,amount-coins[i],memo);
                        if(sub_res!=Integer.MAX_VALUE)
                        {
                            //res = Math.min(res,sub_res+1);
                            memo[amount] = Math.min(memo[amount],sub_res+1);
                        }
                    }
                }
            }
            return memo[amount];
        }
        */
}

// a simple greedy approach to solve this problem...just sort and traverse the coin array from last to get the max value coin first
// if the value of that coin greater than our amount
// then divide it by amount will get us how many no of that coins we need..add it to res...which stores the count of coins
// and subtract the value from our amount...keep doing it until amount becomes 0
// i.e we got our req no of coins so return res..else return -1
// but this approach wont work here...as like fractional knapsack prob we cant take fractional part of some coin at the end here to make up our amount
// hence a recursive solution will work here along with DP...i have used memorization here..nd tabulation based solution in gfg prob Number of Coins
// so here what we do first initialize the memo array with infinite value and as we will be getting some possible values we will keep updating it
// as amount is changing in each call..so only one parameter changing hence 1d array of that size i.e amount's size
// if amount=0 it means no coins to pick..hence return 0..this is the base condition i.e when after multiple calls when amount becomes 0..it means we made up our amount
// so no more picking of coins hence return 0...now for each call what we do..we first make res = infinite i.e initially infinite then we run a loop on coins array
// nd if that coin[i] < = amount then we recursively call for rem amount with same coin array as we have unlimited supply of those coins so coin array will remain as it as
// only amount will change..like this it will keep on recursively calling till we get amount = 0 in that case at last call 0 will be returned...else even if till last call amount didn't become 0 and even no coins left <= amount then res will remain infinite only
// and so last call will make res = infinite in that case...hence when backtracking of all calls start we check that if that last call returned infinite..then nothing happens
//else what we do we update res value with min of infinite and current sub_res value..(if its last call 's backtracking then it must have been 0) +1 as we considered it a step..so that coin must be counted hence +1....in last call case(0+1)..so min of infinite and 1 will be 1 hence that coin counted and it should be as it made amount =0 so we should count it
// like wise bczz of math.min at the end we will get min number of coins and if that amount not possible with given array of coins then we will get res as infinite as it will remain as it as that we initialised and no change will happen to it
// so in that case we check if at last we are getting infinite then we return -1 as req by question to do

// but as here memorization technique is not working and giving TLE...so i used tabulation method here also