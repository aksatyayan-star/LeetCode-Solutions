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
            int m = sc.nextInt();
            
            int matrix[][] = new int[n][m];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(matrix, n, m);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(n==1)
        {
           for(int i=0; i<m; i++)
           {
               ans.add(matrix[n-1][i]);
           }
        }
        else if(m==1)
        {
            for(int j=0; j<n; j++)
           {
               ans.add(matrix[j][m-1]);
           }
        }
        else
        {
            for(int k=0; k<m; k++)
            {
                ans.add(matrix[0][k]);
            }
            for(int k=1; k<n; k++)
            {
                ans.add(matrix[k][m-1]);
            }
            for(int k=m-2; k>=0; k--)
            {
                ans.add(matrix[n-1][k]);
            }
            for(int k=n-2; k>=1; k--)
            {
                ans.add(matrix[k][0]);
            }
        }
        return ans;
    }
}


// in n==1 and m==1 we are taking care of corner cases when there is only row and column matrix respectively
// then as we know n amd m so we are just running 4 for loops to print all the boundary elements in clockwise manner
