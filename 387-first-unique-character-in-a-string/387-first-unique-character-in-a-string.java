class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            count[s.charAt(i)-'a']++;
        }
        for(int j=0; j<s.length(); j++)
        {
            if(count[s.charAt(j)-'a']==1)
            {
                return j;
            }
        }
        return -1;
    }
}

// the logic is simple...we use that occurrences count logic..to first store the count of each char in count array corresponding to its converted ascii value in range 0 to 26 as index
// then again we traverse the string and check for its char that index corresponding to that char value in count array has count equal to 1
// if equal to 1...we simply return that index instantly...it means at first encounter of some char for which count is 1 we return that
// it means we returned the first unique character...as for the 1st char for which we found count 1 we directly returned that char's index