class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s = new HashSet<Integer>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0; i<nums1.length; i++)
        {
            s.add(nums1[i]);
        }
        int res=0;
        for(int j=0; j<nums2.length; j++)
        {
            if(s.contains(nums2[j]))
            {
                res++;
                a.add(nums2[j]);
                s.remove(nums2[j]);
            }
        }
        int[] arr = a.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}

//here we are iterating through 1st array and storing each distinct element in hashset
// then we iterate through 2nd array and check if the element we encountered is present in hashset
// if yes then we add that element to an arraylist and then remove it from hashset 
// so that if we encounter that element again in 2nd array i.e its repeated value then we don't add it again in arraylist
// so to avoid that after adding to arraylist we remove it from hashset
// then finally convert arraylist to int array and return it