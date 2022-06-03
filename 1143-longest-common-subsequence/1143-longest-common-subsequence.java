class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int x = text1.length();
        int y = text2.length();
        int memo[][] = new int[x+1][y+1];
        for(int i=0; i<x+1; i++)
        {
            for(int j=0; j<y+1; j++)
            {
                memo[i][j]=-1;
            }
        }
        //Arrays.fill(memo, -1);
        return lcsdp(x,y,text1,text2,memo);
    }
    int lcsdp(int x, int y, String s1, String s2, int memo[][])
    {
        if(memo[x][y]!= -1)
        {
            return memo[x][y];
        }
        if(x==0 || y==0)
        {
            //return 0;
            memo[x][y]=0;
        }
        else
        {
            if(s1.charAt(x-1)==s2.charAt(y-1))
            {
                //return 1+lcs(x-1,y-1,s1,s2);
                memo[x][y] = 1+lcsdp(x-1,y-1,s1,s2,memo);
            }
            else
            {
                //return Math.max(lcs(x-1,y,s1,s2),lcs(x,y-1,s1,s2));
                memo[x][y] = Math.max(lcsdp(x-1,y,s1,s2,memo),lcsdp(x,y-1,s1,s2,memo));
            }
        }
        return memo[x][y];
    }
}

// the length of string = n ...possible 2^n subsequences...
// subsequence is picking 0 or more characters which may not be contagious but their order must be same as they appear in the input string
//this is a simple recursive solution what we have here...with base case as if length of any of string becomes 0 then return 0
// as even if any one is 0 the longest common subsequence will be of 0 length...else we start comparing letters from the end..we can even do it from start
// so if we find same letters then consider that and recursively call for rest of the letters hence 1(considering the common letter)+ recursive call for rest of letters
// by reducing the length of both strings by 1...x-1 and y-1
// nd if the letters not same then two conditions ...call recursively for 1 length less than s1's length and whole of s2's length
// and whole of s1's length and 1 length less than s2's actual length at the time of that function call...and finally taking the max of both
// so likewise in all conditions these recursive calls will check for each condition and will give the result
// now this solution has overlapping recursive calls for sub problems...hence we can optimize it using DP
// lets use memorization concept...for this ques the array is gonna be 2d array as 2 parameters changing in recursive call..ie x and y
// and initialize that array with some value which can't be a possible LCS...ie any -ve value...say -1
// now some modifications needed we will add extra condition to check if memo[x][y]!=1 that means some value there 
// that means we already have value stored there for this x and y value recursive call
// so directly return that else go to the calculation part to find it and then store it in memo array of index x and y
// earlier if we were finding we were just returning it but now we need to store it in memo array so that we can use that stored value for further repetitive recursive calls
// nd finally return memo[x][y] thats our answer the LCS