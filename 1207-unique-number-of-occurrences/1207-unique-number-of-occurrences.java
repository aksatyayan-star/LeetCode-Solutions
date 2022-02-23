class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> h = new HashMap<>();
        HashSet<Integer> s = new HashSet<>();
        for(int x: arr)
        {
            h.put(x,h.getOrDefault(x,0)+1);
            // here we are giving key as x and for value checking if there's a prev freq of x if yes then take it and add 1 else take 0 and add 1
            // here put function just not only updates value when the same element is encountered again and again but actually replaces the whole key value pair with the latest pair with updated value...key will be obviously same
        }
        // for traversing through hashmap
        // and adding each value in hashset...so that if duplicates present wont be added in hashset
        for(Map.Entry<Integer, Integer> e: h.entrySet())
        {
            s.add(e.getValue());
        }
        // then we check if there were no duplicate values then size must be same else size not same
        if(h.size()==s.size())
        {
            return true;
        }
        else {
            return false;
        }
    }
}