class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        while(k>n)
        {
            k=k-n;
        }
        int d = n-k;
        int[] temp = new int[d];
        for(int i=0; i<d; i++)
        {
            temp[i]=nums[i];
        }
        for(int i=d; i<n ;i++)
        {
            nums[i-d]= nums[i];
        }
        for(int i=0; i<d; i++)
        {
            nums[n-d+i] = temp[i];
        }
    }
}

//as we can see that in right rotating, the no of elements that gets pushed back to the end is equal to length - k(steps by which we have to right rotate the array) no of elements from the startng of the array
// ex [1,2,3,4,5,6,7]..k= 3 given...no of elemnts that get pushed back to end = length-k = 4
// so what i'm doing is that i'm storing those elements in another temp array first..i.e the first 4 elements...temp[]= [1,2,3,4]
// then i'm moving the remaining elements in the main array to the start in same order...nums[]=[5,6,7,4,5,6,7]...so 5,6,7 moved to starting of array..ignore rest elements for now
// now copy that temp array elemnts to main array from the index after 7...thats why n-d+i..it gives us that index...so finally nums[] = [5,6,7,1,2,3,4]
// by this way we can also left rotate an array just the difference is that here length-k no of elements are pushed back to end...but in left rotate first k elements itself get pushed back to end
// so in that case no need to find length-k...k will do the work...rest all things are same
// now that k>n condition is there for when we encounter some case where no of rotation is greater than length 
// so in that condition simply d = n-k will give us negative result..so till we get k<n...we keep on subtracting k = k-n as if length = 3 and no of rotations = 4 then it is equivalent to k-n i.e 1 rotation
// as length is 3 then after 3 rotations the array will come back to its original form then we have to make 1 rotation again on original array to get our result...so in other words it got equivalent to 1 rotation on original array