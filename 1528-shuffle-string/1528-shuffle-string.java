class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<indices.length; i++)
        {
            int a = indices[i];
            char b = s.charAt(i);
            sb.setCharAt(a,b);
        }
        return sb.toString();
        /*char temp[] = new char[indices.length];
		for (int i = 0; i < indices.length; i++) 
        {
			temp[indices[i]] = s.charAt(i);
		}
		return new String(temp);
        */
    }
}

// an easy way is to use StringBuilder class initialized with given string s...nd traverse the indices array for getting the position and s string to get the char
//and then using both setchar in stringbuilder class string sb..at those positions with those char..nd finally convert it to string and return

// a second way is to use char array and at its indices which we fetch from indices arrays elements put chars from string s
// and finally convert that char array to string and return it