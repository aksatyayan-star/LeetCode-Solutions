class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid]) return mid;  // founded 
            if(nums[left]<=nums[mid]){  // i.e if arrays left half sorted
                if(nums[left]<=target && target<nums[mid]){  // inside this region
                    right=mid-1;
                }
                else left=mid+1;
            }else{                     // i.e if arrays right half sorted
                if(nums[mid]<target && target<=nums[right]){  // inside this region
                    left=mid+1;
                }
                else right=mid-1;
            }
        }
        return -1;
    }
}

// its kind of binary search but modified...like as we have rotated sorted array...so either one of the half left or right must be sorted 
// so first we calculate mid and if target = mid then just return it
// else we check which half is sorted by comapring mid with 1st element i.e left 
// and in else part(its not req to write condn so i havent written) but we are comparing mid with last elemnt ..i.e right
// so depending on which half sorted we go inside sorted half and check if our target lies in that sorted half..
// if yes then we discard other half else we go to other non sorted half for finding the target 
// this keeps on running in loop till left<=right


