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
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int curr_sum=0;
        for(int i=0; i<K; i++)
        {
            curr_sum+=Arr.get(i);
        }
        int max_sum = curr_sum;
        for(int i=K; i<N; i++)
        {
            curr_sum+=(Arr.get(i)-Arr.get(i-K));
            max_sum = Math.max(max_sum,curr_sum);
        }
        return max_sum;
    }
}


// its a sliding window problem...here we have to move window size of length K in each iteration by one unit
// and find max sum of that particular window...then store it in curr_sum
// now we have to slide that window by one unit..so for that..the concept is like
// subtract the 1st element(i-K) and add the next element..
//i.e element next to 1st window's last element(k)..(as window size was k so next element to last element of 1st window will be kth element) to curr_sum
// this will give sum of next window..like this we will keep subtracting 1st element of the previous window
//and keep adding element next to last elemnt of the previous window and it will give us sum of the current window
// we will keep updating max sum for the max value...and finally return it


//the same can be modified for like question will be 
//Subarray of size k with given sum
//Given an array arr[], an integer K and a Sum. The task is to check if there exists any subarray with K elements whose sum is equal to the given sum. 
//If any of the subarray with size K has the sum equal to the given sum then print YES otherwise print NO.


//for this what we have to do is that same approach and code like upper will be followed with some modifications like

/* 
static boolean checkSubarraySum(int[] arr, int n,
                    int k, int sum)
{
    // Check for first window
    int curr_sum = 0;
    for (int i=0; i<k; i++)
    curr_sum += arr[i];
    if (curr_sum == sum)
        return true;
 
    // Consider remaining blocks ending with j
    for (int j = k; j < n; j++) {
        curr_sum = curr_sum + arr[j] - arr[j-k];
        if (curr_sum == sum)
            return true;    
    }
    return false;
}
*/
