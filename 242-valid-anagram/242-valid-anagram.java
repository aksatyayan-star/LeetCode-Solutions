class Solution {
    static final int CHAR = 256;
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        int[] count = new int[CHAR];
        //int[] tcount = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            //count[s.charAt(i)-'a']++;
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        for(int j=0; j<CHAR; j++)
        {
            if(count[j]!=0)
            {
                return false;
            }
        }
        return true;
    }
}

// its a tricky logic here...we use the same concept of counting the occurences of each char in the string
// but here with a little bit of change...first here we are considering the case of both uppercase and lowercase letters..hence size 256 array
// and here we are not doing it i - a type conversion of 97 to 122 to 0 to 26...but instead simply storing count of each char at its ascii value index
// here s.charAt(i) or t.charAt(i) will give us char but when used as an index of array it automatically gives the ascii value of that char 
// and value at that ascii value index of count array will be incremented for each encounter in s string and decremented for each encounter in t string
// so likewise this if both strings are anagram then finally whole count array's each index's value will be 0 
// as both incremention and decremention will balance out each other or nullify each other if anagram so if any index's value of count array not 0 then return false