class Solution {
    int count = 0;
    public int numberOfSteps(int num) {
        if(num == 0)
        {
            return count;
        }
        else if(num%2==0)
        {
            num = num/2;
            count++;
            return numberOfSteps(num);
        }
        else
        {
            num = num-1;
            count++;
            return numberOfSteps(num);
        }
    }
}

// the solution is simple and using recusrsion can easily be solved...for even and odd acc to conditions given perform the operation
// and increase count as each operation considered as one step...then recursively call for that num after operation
// as we have to keep calling recursively till that num = 0...when num = 0 simply return count