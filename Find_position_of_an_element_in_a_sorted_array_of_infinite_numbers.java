//User function Template for Java

class FindPos {
    int search(int arr[], int x)
    {
        if(arr[0]==x)
        {
            return 0;
        }
        int i=1;
        while(arr[i]<x)
        {
            i=i*2;
        }
        if(arr[i]==x)
        {
            return i;
        }
        else
        {
            return binarySearch(arr, x , i/2 + 1, i-1);
        }
    }
    
    int binarySearch(int arr[], int x, int low, int high) 
    {
        while (low <= high) 
        {
        int mid = (low + high) / 2;

        if (array[mid] == element)
            return mid;

        if (array[mid] < element)
            low = mid + 1;

        else
            high = mid - 1;
        }
    return -1;
  }
}


// so what we are doing is that we dont know the max i.e high so we keep on moving in i=i*2...that is to move fast we move by doubling i..
// till we find arr[i] which is greater than or equal to x...we come out of while loop there and check if that is equal to x...if equal then return i
// else apply binary search for low = i/2 + 1 as we are doubling i in each loop so to go to just previous i to current i , we have to divide current i by 2
// and also add 1 as we already checked for that i in previous iteration and that was not equal to or greater than given x thats why we moved on to next iteration
// hence make low = i/2 + 1 and for high its i - 1 as again we checked for i and its not equal to x so our range is from i/2 + 1 to i - 1 
 
