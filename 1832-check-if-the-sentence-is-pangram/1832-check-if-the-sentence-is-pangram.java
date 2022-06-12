class Solution {
    public boolean checkIfPangram(String sentence) {
        
        HashSet<Character> letters = new HashSet<>(26);
        
        for(int i = 0; i < sentence.length(); i++) 
        {
            letters.add(sentence.charAt(i));
        }
        if(letters.size()==26)
        {
            return true;
        }
        return false;
        //return letters.size() >= 26;
    }
}

// the concept is simple...as we all know we have 26 alphabets in english lang
// so what we do is use hashset...as hashset stores only distinct elements in it and as our condition is that each alphabet should appear at least once
// so if appeared multiple times hashset will ignore that...and after whole traversion if hashset contains 26 elements it means they must be diff 
// and that is possible only if that sentence would have consisted of all the 26 alphabets of english lang