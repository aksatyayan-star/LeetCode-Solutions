// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}// } Driver Code Ends




class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        char convertedChar = ' ';
        int res = 0;
        int[] count = new int[26];
        for(int i=0; i<line.length(); i++)
        {
            count[line.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++)
        {
            if(count[i]>res)
            {
                res = count[i];
                int asciiValue = 97 + i;
                convertedChar = (char)asciiValue;
            }
        }
        return convertedChar;
    }
}

// so its a simple solution...what the logic in string questions are that to count the occurences of characters
// we dont need hash map or tree map like in array questions...here using their ascii values we can store their occurences easily
// so we know small a has value 97 and we have 26 characters...so to store their count in a simple array
// we define array of size 26..and then we traverse string..and we store each char's count at that char-a value
// i.e that char's ascii value when subtracted from a..i.e base value we will get in range of 0 to 26
// i.e a will correspond to 0..b to 1 likewise in our count array so we converted 97 to 122...in 0 to 26 format
// by subtracting each with a's ascii value i.e 97...so its that simple
// and as we need to find char with max no of occurences...so we traverse the count array and as we find some count[i] greater than res..
// which we intialized to 0 and keep updating it(res) with count[i] as we find some count[i] > res..nd we also keep updating asciiValue..
// which gives us the ascii value of char whose count is there at count[i] index...it will be 97(ascii value of a)+ i(index of that count value)
// nd then we get char of this asciivalue using conversion...nd finally return it...and as the count stores the count of each char in lexicographically sorted order only
// and i have given condition to update res only when greater than prev value and not when both greater than or equal to...hence even if some lexicographically larger char
// has same max no of occurences as its lexicographically smaller char...then also the res will not get updated as we will encounter that lexicographically larger char
// after the smaller one bczz of which res already got updated to so it wont get updated again till we find some value greater than res