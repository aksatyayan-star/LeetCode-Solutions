// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++)
        {
            dp[i][0] = i;
        }
        for(int j=0; j<n+1; j++)
        {
            dp[0][j] = j;
        }
        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    int x = Math.min(dp[i-1][j],dp[i][j-1]);
                    x = Math.min(x,dp[i-1][j-1]);
                    dp[i][j] = 1+x;
                }
            }
        }
        return dp[m][n];
    }
}

// this is just a tabulation method solution of the memorization recursion solution i implemented in the same question on leetcode
// here for filling the base condition i.e the first row and column same logic is used that is if one empty then return the length of other
// thats what i am doing by filling array equal to i or j as for those iterations at that time the length of other string will be equal to i or j
// as i and j in 2d array represents the length of respective strings only...so using that once 1st row and 1st column filled
// thn we use the same recursion logic to fill the rest of elements using the base case filled elements..nd finally return last cell