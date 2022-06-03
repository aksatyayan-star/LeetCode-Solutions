class Solution {
    public int fib(int n) {
        int[] memo = new int[n+1];
        for(int i=0; i<n+1; i++)
        {
            memo[i]=-1;
        }
        return findFib(n,memo);
    }
    public int findFib(int n, int[] memo)
    {
        if(memo[n]==-1)
        {
            int res;
            if(n==0||n==1)
            {
                res = n;
            }
            else
            {
                res = findFib(n-1, memo)+findFib(n-2, memo);
            }
            memo[n]=res;
        }
        return memo[n];
    }
}

// this is an optimized recursive solution of fibonaaci number using dynamic programming's memorization concept
// here what we do is that first create an array of size 1 more than given number...then initialize it by -1 we can do it with any negative number
// as fibonacci number cannot be negative for any number....so when traversing this array for some number if w eget value an that index. as -1 
// we will know that value for that number has not been calculated yet else we will return the value at that index
// so in the other function we pass n and that memo array ...we check if element at index n of memo is -1 it means that it's the recursive call for this number n
// hence there is no entry corresponding to it in memo array and its still -1 so we calculate the fibonacci for this n and store it in res
// and finally store this res at n index of memo so that further when we will need value for this n we dont need to do all the calculation step again
// we can just fetch the value from memo array's index n...as we have return memo[n] as last line which will work if memo[n] for some n is not =-1 
// that menas it didnt get into if condition and we already have its value stored in memo so directly fetch it...that's all...
// this way we optimized recursion and prevented many extra calculations for the n which we might have already calculated earlier