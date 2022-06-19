class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][] dp = new int[amount+1][n+1];
        for(int i=0; i<n+1; i++)
        {
            dp[0][i] = 1;
        }
        for(int j=1; j<amount+1; j++)
        {
            dp[j][0] = 0;
        }
        for(int i=1; i<amount+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                dp[i][j] = dp[i][j-1];
                if(coins[j-1]<=i)
                {
                    dp[i][j] = dp[i][j]+dp[i-coins[j-1]][j];
                }
            }
        }
        return dp[amount][n];
    }
}

//here its dp tabulation method solution of this problem...our goal is to find the no of possible ways ..like diff no of combinations of coins to get a given amount of sum