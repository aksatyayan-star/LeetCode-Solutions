// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} // } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        int tail[] = new int[size];
        tail[0] = a[0];
        int len=1;
        for(int i=0; i<size; i++)
        {
            if(a[i]>tail[len-1])
            {
                tail[len]=a[i];
                len++;
            }
            else
            {
                int c = ceilIdx(tail,0,len-1,a[i]);
                tail[c] = a[i];
            }
        }
        return len;
    }
    static int ceilIdx(int[] tail,int s, int e, int x)
    {
        while(e>s)
        {
            int m = s+(e-s)/2;
            if(tail[m]>=x)
            {
                e = m;
            }
            else
            {
                s = m+1;
            }
        }
        return e;
    }
} 

// here we use the concept of binary search to solve this prob...we use a tail array which stores the min possible 
// tail value for LIS of some lengths...like the value at i index of tail array will store the min possible tail value of LIS of length i+1
// so the concept is we push 1st elemnt to tail array as at 0 index of tail array it will store min possible tail value of LIS of length i+1 i.e...of 1 length
// nd it will be 1st element of array only...then for next elements if that element greater than last pushed value in tail array..then append it next
// as obviously if greater than last element it means we can consider this also as part of LIS...then if some element smaller than last pushed element in tail array
// then that would not increase length of LIS...we got till now as its smaller...so in smaller cases what we do..we find its ceil in the tail array elements
// and like the index of its ceil in tail array and then at that index of tail array we replace prev element with this smaller element...as min possible tail value of LIS 
// of that length corresponding to i+1 value will be this smaller element...nd to find the ceil we use binary search....nd this process continues till we reach last element of main array
// nd finally whatever the length of our tail array that is the lenth of our LIS for that main array...this method gives O(nlogn) time complexity ...better than DP 

// in the ceil binary search function we pass tail array, the start index, the end index and the element to be searched as parameters
// then the index that we get from this function we replace the element at this index of tail array with our current element
// here we can apply binary search as tail array is sorted...we are inserting elements in such way in this array that it is sorted