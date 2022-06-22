// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String firstRepChar(String s) 
    { 
        // code here
        int[] rIndex = new int[26];
        StringBuilder s1 = new StringBuilder();
        Integer num = -1;
        String s2 = num.toString();

        Arrays.fill(rIndex,-1);
        int res = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++)
        {
            int ri = rIndex[s.charAt(i)-'a'];
            if(ri==-1)
            {
                rIndex[s.charAt(i)-'a'] = i;
            }
            else
            {
                return s1.append(s.charAt(i)).toString();
            }
        }
        return s2;
    }
}

//here the same logic as in Repeated Characters prob...just with some modification..when we find second occurence
// then there we used to update it with min value...here for the first second occurence of any char..simply return that char
// as that is the req char