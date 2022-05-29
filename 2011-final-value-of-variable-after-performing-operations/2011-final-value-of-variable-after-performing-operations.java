class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].charAt(1) == '+')
            {
                x++;  
            }
            else
            {
                x--;
            } 
        }
        return x; 
    }
}

// a simple solution for this..we have to run loop till the length of array..and for each string element inside the array just check for element at 1st index of each string element
// as whether its pre or post opeartion the + or - will always be there at 1st index so checking 1st index of each string element only 
// will give us the idea that we have to increase the x value or decrease the x value..that's all at the end just return x