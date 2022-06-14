class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m+1][n+1];
        for(int i=0; i<m+1; i++)
        {
            for(int j=0; j<n+1; j++)
            {
                memo[i][j] = -1;
            }
        }
        int LCS = LCS(word1, word2, m , n, memo);
        int a = m-LCS;
        int b = n-LCS;
        return a+b;
    }
    int lcs = 0;
    int LCS(String word1, String word2, int m , int n, int[][] memo)
    {
        if(memo[m][n]!=-1)
        {
            return memo[m][n];
        }
        if(m==0 || n==0)
        {
            //return 0;
            memo[m][n] = 0;
        }
        else
        {
            if(word1.charAt(m-1)==word2.charAt(n-1))
            {
                //lcs++;
                //return 1+LCS(word1, word2, m-1, n-1, memo);
                memo[m][n] = 1+LCS(word1, word2, m-1, n-1, memo);
            }
            else
            {
                //return Math.max(LCS(word1, word2, m-1, n, memo), LCS(word1, word2, m , n-1, memo));
                memo[m][n] = Math.max(LCS(word1, word2, m-1, n, memo), LCS(word1, word2, m , n-1, memo));
            }
        }
        //return lcs;
        return memo[m][n];
    }
}

// its a problem based on longest common subsequence...what we have to do is just find the LCS...nd then remove the rest of the characters from both the strings
// and that will be the min no of operations req to make the strings same...ie no of elements in both strings remaining after LCS are the no of steps 
// req to make strings same...so find LCS and subtract it from length of both strings...then add those two values of both strings remaining after subtracting LCS from each of those
// that will be our ans....the minimum number of steps required to make word1 and word2 the same.