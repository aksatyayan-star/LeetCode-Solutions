// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.snakePattern(matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        // code here
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<matrix.length; i++)
        {
            if(count%2==0)
            {
                for(int j=0; j<matrix[i].length; j++)
                {
                    ans.add(matrix[i][j]);
                }
                count++;
            }
            else
            {
                for(int k=matrix[i].length-1; k>=0; k--)
                {
                    ans.add(matrix[i][k]);
                }
                count++;
            }
        }
        return ans;
    }
}

// here i have used count to check if current row is even or odd
// but we can even directly take i i.e row no and check if its odd or even and print accordingly without even using count
