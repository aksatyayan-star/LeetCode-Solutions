class Solution {
    public int findTheWinner(int n, int k) {
        if(n==1)
        {
            return 1;
        }
        else
        {
            return (findTheWinner(n - 1, k) + k - 1) % n + 1 ;
        }
    }
}

// lets see for n=4 , k=2
// here for n= 4  , we have elements starting from 1 to 4 i.e 1 , 2 , 3 , 4
// so findTheWinner(4,2) will call (findTheWinner(3,2)+1)%4 + 1
// findTheWinner(3,2) will call (findTheWinner(2,2)+1)%3 + 1
// findTheWinner(2,2) will call (findTheWinner(1,2)+1)%2 + 1
// findTheWinner(1,2) will return 1;
// so findTheWinner(2,2) will be (1+1)%2 + 1 = 1
// findTheWinner(3,2) will be (1+1)%3 + 1 = 3
// findTheWinner(4,2) will be (3+1)%4 + 1 = 1

// if it starts from 0...i.e the friends numbers...then the recursive call would have been
// findTheWinner((n-1,k) + k) % n....and whatever ans we get from this...if we will add 1 to the final result then we will get ans for our this ques...
/// nd one change more for base case...it should return 0...when numbers start from 0..