// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int start = 0;
        int end = n-1;
        if(firstoccurence(arr, start, end, x)==-1)
        {
            return 0;
        }
        else
        {
            return (lastoccurence(arr, start, end, x)-firstoccurence(arr, start, end, x)+1);
        }
    }
    
    int firstoccurence(int[] arr, int start, int end, int x)
    {
        if(start>end)
        {
            return -1;
        }
        int mid = (start+end)/2;
        if(x>arr[mid])
        {
            return firstoccurence(arr, mid+1, end, x);
        }
        else if(x<arr[mid])
        {
            return firstoccurence(arr, start, mid-1, x);
        }
        else
        {
            if(mid==0 || arr[mid-1]!=arr[mid])
            {
                return mid;
            }
            else
            {
                return firstoccurence(arr, start, mid-1, x);
            }
        }
    }
    
    int lastoccurence(int[] arr, int start, int end, int x)
    {
        if(start>end)
        {
            return -1;
        }
        int mid = (start+end)/2;
        if(x>arr[mid])
        {
            return lastoccurence(arr, mid+1, end, x);
        }
        else if(x<arr[mid])
        {
            return lastoccurence(arr, start, mid-1, x);
        }
        else
        {
            if(mid==arr.length-1 || arr[mid+1]!=arr[mid])
            {
                return mid;
            }
            else
            {
                return lastoccurence(arr, mid+1, end, x);
            }
        }
    }
}

// we are finding first occurence and last occurence of the element given for which we have to find number of occurences
// finally for no of occurences we subtract firstoccurence+1 from last occurence and get the no of occurences for that element