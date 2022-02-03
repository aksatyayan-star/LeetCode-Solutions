class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        int[] arr = new int[2];
        while(low<high)
        {
            if(numbers[low]+numbers[high]==target)
            {
                arr[0]=low+1;
                arr[1]=high+1;
                return arr;
            }
            if(numbers[low]+numbers[high]>target)
            {
                high--;
            }
            if(numbers[low]+numbers[high]<target)
            {
                low++;
            }
        }
        arr[0] = -1;
        return arr;
    }
}

// for a sorted array we use two pointer approach...we initialize two pointers...1st element and last element
// run loop till low<high as as low becomes = to high it means no two elements are there whose sum= target
// so if sum of elements at low and high is greater than target then we reduce high as it's sorted araay so max element in right side
// we have to reduce the high and come to a lesser max elemnt than current one
// and if sum of elements at low and high is less than target then we increase low as we want more greater sum
// so increase low..ie move low pointer to right to go to a little big element than the current one
// by this way adjusting both lows and highs we finally get our required elements