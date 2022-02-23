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
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    int findSum(int arr[], int n) {
        // code here
        int sum = 0;
        HashSet<Integer> s = new HashSet<>();
        for(int i=0; i<arr.length; i++)
        {
            s.add(arr[i]);
        }
        Iterator<Integer> it = s.iterator();
        while (it.hasNext()) {
            sum = sum+it.next(); 
        }
        return sum;
    }
}

// HashSet<Integer> s = new HashSet<>(Arrays.aslist(arr));
// we can directly create hashset using array as above way also...like without using for loop to iterate through whole array and adding each element in hashset one by one

//here its just a basic use case of hashset
// we iterate the array and we add every elemnt to hashset and the hashset dont contain dupliacte elements
// so automatically if an element is already there in hashset then it wont be inserted again if encountered during array traversing
// so we will have all the distinct elements in the hashset at the end of array traversal
// then just make a iterator it and using it iterate through each element of hashset and add it to the sum
