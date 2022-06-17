// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{
	    int[] dp = new int[V+1];
	    dp[0] = 0;
	    for(int i=1; i<V+1; i++)
	    {
	        dp[i] = Integer.MAX_VALUE;
	        for(int j=0; j<M; j++)
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
	    if(dp[V]==Integer.MAX_VALUE)
	    {
	        return -1;
	    }
	    return dp[V];
    }
}

// here we have converted the same recursion code into tabulation based solution...here i i.e index of dp array
// represents the amount ...and dp[i] represents the min no of coins req to make up that amount...and i moves till V
// hence we initialize dp[0] = 0 as to make amount 0 we need 0 coins then for further i's first we initialize the dp[i] value as infinite
// then we run loop for traversing coin array and check for if coin value[j]<= amount..then we make sub_res
// as dp[i-coins[j]] value i.e we subtract value of current coin from the amount..to get the value of dp[i] where i is the value which we got 
// after subtracting coin[j] from our amount...basically it means the let's say i have amount = 20 and coins 1, 2,3
// so when say calculating for amount 3 (i=3)...we will get 3-1 ..ie 2 amount during 1st loop so for getting value for amount 2
// we will directly access dp[2] hence dp[3-1] i.e dp[amount(i)-coin[j]]...this is same what is happening here
// so after getting that value in sub_res...see we could even directly add 1 in sub_res value as whatever we get for dp[2] ..now 
// 1 more addition to it as dp[3] we need..so that will be dp[2] + one more coin..coin[j] as after subtracting that only we got call for dp[2]
// hence one more coin ...coin[j] needed to make up the amount so count +1...but here prob is maybe for dp[2] we could have got infinite as result
// as maybe dp[2] was not possible as we might not have 1 and 2 ruppees coin to make up dp[2] then in that case also we could have added 1
// and updated the value of d[3] as infinite+1 value which is wrong...so first we check if sub_res we got is not infinte
// then we update it with min of earlier dp[i] and sub_res+1..here counting 1 in sub_res
// nd finally if dp[v]..i,e dp last element is infinite it means that amount not possible with given set of coins...so return -1
// else return dp[v]...ie last element of dp array as that only will be our min no of coins req to make up given amount
// as dp[i] represents min no of coins to make up amount i and i moves in range 1 to given amount hence the last index is given amount ...so last index's value is our answer