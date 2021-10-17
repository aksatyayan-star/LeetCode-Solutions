import java.util.*;
class Solution {
    public boolean isPalindrome(String str) {
        int start = 0;
        str = str.toLowerCase();
        str = str.replaceAll("\\p{Punct}","");
        str = str.replaceAll("\\s", "");
        int end = str.length()-1;
        return isPalin(str, start, end);
    }
    public boolean isPalin(String str, int start, int end) {
        if(start >= end)
        {
            return true;
        }
        return (str.charAt(start) == str.charAt(end) && isPalin(str, start+1, end-1));
    }
}

// so the code goes like we check for char at start and end of the string...
//if it matches then we go for recursive call for start+1 and end-1...ie we move one char in forward direction from start and one char in backward direction from end 
//then again compare them if matches so again make a recursive call 
// (Notice that && symbol in return statment, it works like shortcircuit i.e first it matches the char at start and end if that holds true then only it will make recursive call for start +1 and end-1 else it will terminate then and there and start>= end condition won't satisfy and we will get the result as false) 
// and it goes on till we come to limiting condition 
// i.e if it's an odd length string then start=end condition will come when we will reach at the middle char of string...so if we reached till there it means given string is palindrome
// now in case of even length string there will be no such middle char so in that condition we must have checked all characters and at the limiting condition we must have moved forward such that start value will pass end i.e start > end...so in that case also string is palindrome
// now there are some modifications we had to do on the given input string like convert all characters to lowercase then removing all punctuations then removing all the spaces and then we calculate the length of this final modified string and pass the req values to isPalin function