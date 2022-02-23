class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int sum =0;
        for(int x: nums)
        {
            h.put(x,h.getOrDefault(x,0)+1);
        }
        for(Map.Entry<Integer, Integer> e: h.entrySet())
        {
            if(e.getValue()==1)
            {
                sum = sum + e.getKey();
            }
        }
        return sum;
    }
}

// here we are first traversing through array and storing each key value pairs in hashmap
// then we traverse through hashmap and check for if value = 1..i.e unique element then add key corresponding to it to the sum and leave the rest