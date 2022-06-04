// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        int tab[][] = new int[x+1][y+1];
        for(int i=0; i<=x; i++)
        {
            tab[i][0]=0;
        }
            
        for(int j=0; j<=y; j++)
        {
            tab[0][j]=0;
        }
    
        //Arrays.fill(memo, -1);
        return lcsdp(x,y,s1,s2,tab);
        
    }
    static int lcsdp(int x, int y, String s1, String s2, int tab[][])
    {
        // your code here
        for(int i=1; i<=x; i++)
        {
            for(int j=1; j<=y; j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                //return 1+lcs(x-1,y-1,s1,s2);
                    tab[i][j] = 1+tab[i-1][j-1];
                }
                else
                {
                //return Math.max(lcs(x-1,y,s1,s2),lcs(x,y-1,s1,s2));
                    tab[i][j] = Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        return tab[x][y];
    }
}

// here in tabulation solution we are going to fill the 2d array in bottom up manner...so to get the value of substring
// of length 1 and 1 ...we need solutions of 0&0 , 0&1, 1&0..nd hence we need extra 1 row nd column...i.e size of array as x+1 and y+1 to accomodate these
// now 1st row and 1st column is always going to be zero as that represents either one of the string empty s1 or s2..nd hence even if one zero the LCS zero
// rest of the entries we fill in the same way as we did it in memorization concept...here just instead of recursive call for those values...
// we run a for loop starting from 1..i.e 2nd row nd column for both rows and columns as 1st row and 1st column already filled with 0 and
// we directly fetch it from 2d array as we had already stored there as its a bottom up approach...the last cell will always have the result..ie tab[x][y] will give us LCS value


