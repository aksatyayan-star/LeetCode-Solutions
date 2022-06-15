// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       /*if(n<0)
       {
           return -1;
       }
       if(n==0)
       {
           return 0;
       }
       
       int a = Math.max(maximizeCuts(n-x,x,y,z), maximizeCuts(n-y,x,y,z));
       int res = Math.max(a, maximizeCuts(n-z,x,y,z));
       
       if (res==-1)
       {
           return -1;
       }
       else
       {
           return res+1;
       }
       */
       int[] dp = new int[n+1];
       dp[0] = 0;
       for(int i=1; i<n+1; i++)
       {
           dp[i] = -1;
           if(i-x>=0)
           {
               dp[i] = Math.max(dp[i],dp[i-x]);
           }
           if(i-y>=0)
           {
               dp[i] = Math.max(dp[i],dp[i-y]);
           }
           if(i-z>=0)
           {
               dp[i] = Math.max(dp[i],dp[i-z]);
           }
           if(dp[i]!=-1)
           {
               dp[i]++;
           }
       }
       if (dp[n] == -1) {
            dp[n] = 0;
        }
       return dp[n];
    }
}

// so here in the normal recursive solution what we are doing is that...we are just making three recursive calls
// reducing n by value of the respective cuts in each recursive calls..ie...n-x, n-y nd n-z
// and then taking max of it as we req max cut segments...now here we are not directly doing 1+max(function calls)
// as in this condition..when we will get from all these function calls -1 i.e the cuts not possible..when n becomes -ve
// then in that condition also the parent function call will make it 1 + (-1) = 0 and maybe in further calls 
// it will keep making it 1 + 0 and so on..so in that condition even for cases where cut not possible we will get some valid value as ans
// so to avoid that..first we are checking if max of all those is -1 then we simply return -1 else we add 1 to it
// as then only its a possible cut and hence 1 added..to increase the count of cut as this cut is considered and added in ans
// its a possible cut.. we get to know when n becomes 0..then we return 0 nd hence lets say max of 0 or -1 or -1 will be 0
// so we will not fall in res=-1 case and so 1+0 will be returned which is right as this cut is valid and hence should be counted
// like this we will get our final res value...the max no of cuts possible

// now coming to dp based solution as we have only one parameter changing i.e n...so our array will be 1d only and of size n+1
// and its a tabulation method so we have to fill the array for base cases first and then using it we can proceed further
// hence base case when n=0 then return 0 so dp[0] = 0...then in for loop starting from 1...1st we initialize the item at that index i to -1
// then what we do we make all three possible cuts...nd for each we check first if making that cut feasible...then only we make a cut
// by checking the condition i - a or b or c greater than 0...if yes it means cut possible so we make the cuts 
// and upadte the dp[i] by max of earlier dp[i]s and dp[i-a or b or c]  i.e dp after making the cuts ...this way
// it will get us max of three cuts as we upate dp[i] after making a cut and then for next cut again we comapre dp[i] bczz of earlier cut and after this cut 
// ...whichever max we upadte dp[i] with that...so in the end we will get max of dp[i] and if no cut possible for a or b or c 
// then we wont even make the cut as we previous only check for i-a or b or c is greater than 0 then only make the cut so in that case dp[i] will remain as it is -1 
// which we had initialized in the start of the loop...so in that case simply we will have dp[i] as -1
// hence we check when dp[i] after making all the possible three cuts and taking max of all those ..even afer that if dp[i] not -1..it means a possible cut is there
// hence update dp[i] by 1...i.e dp[i]++ ...by this till the end of the loop we will get our max no of possible cuts as the last element of the dp array
// here i is the length of our rod ..which keeps on changing in each iteration till n...ie the length given in ques
// so for each sub lengths of rod we check that for that sub length how many no of cuts can we make of given three values
// using the earlier value...like if we at i= 2 i.e our rod length = 2..then can we make cut of values a= 1, b=2 , c=3
// nd we already have dp[1] as 1 as there i was 1 i.e rod of length 1 ...so we can obviously make cut of a length on that sub length of rod
// nd only one cut would be possible of length a =1..hence dp[1] already we have 1 now for i= 2 we can make (a) length cut as i-a > 0 so we will update dp[2] to dp[i-a]
// as max(dp[i],dp[i-a]) ..dp[i] initialized to -1 at the start of every loop and as i-a>0 fulfilled so go inside nd dp[i-a] is dp[1] which was 1
// so dp[2] updated to 1...now i-b also possible as 2-2 = 0 hence go inside and again we chcek max of earlier dp[i] and dp[i-b]
// now dp[i] already got updated to 1 bczz of (a) cut and dp[i-b] i.e dp[0] is 0 so max will be 1 only and c cut not possible
// so in the end dp[2] = 1 hence dp[2]!=-1 so go inside and finally dp[2] will be updated to 2..and it is true as for a length of rod 2
// and value a = 1 , b=2, c=3...the max no of cuts possible is 2...i.e 2 cuts of a=1 length each
// hence by this way using the value for sub lengths of rod...we can get at the end max value for the whole rod when i becomes n
