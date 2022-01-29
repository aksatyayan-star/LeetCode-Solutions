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
