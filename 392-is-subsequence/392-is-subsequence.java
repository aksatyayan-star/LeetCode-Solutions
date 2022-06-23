class Solution {
    //boolean z = false;
    public boolean isSubsequence(String s, String t) {
        int x = s.length();
        int y = t.length();
        boolean z = true;
        int res = checker(s,x,t,y,z);
        if(res==s.length())
        {
            return true;
        }
        return false;
        //return checker(s,x,t,y,z);
    }
    int checker(String s, int x, String t, int y, boolean z)
    {
        if(x==0 || y==0)
        {
            //return z;
            return 0;
        }
        else
        {
            if(s.charAt(x-1)==t.charAt(y-1))
            {
                //z = true;
                return 1+checker(s,x-1,t,y-1,z);
            }
            else
            {
                //z = false;
                return checker(s,x,t,y-1,z);
            }
            
            //return z;
        }
        //return z;
    }
}

// here the logic is first i tried to do with with some boolean value ..but couldn't get the result
// so i modified it a liitle bit to incorporate the logic of finding the length of subsequence in checker function
// in checker function what we do we traverse both strings from last and check if char matches if yes we return 1+recursive call with one length reduced of both string
// this way we keep count of how many char matched and then we call for rest of chars of both strings by skipping matched char by reducing length
// now if char doesnt match what we do is that we keep x as it is as that's the length of smaller string which we have to check is a subsequence of larger string or not
// so we keep x as it is but reduce y's value i.e larger string's length so that to check maybe next char of larger string matches with curr char of smaller string
// in this case we dont even do 1+recursive call as char's didnt match so we can't count it...we just do recursive call without adding 1
// we dont reduce length of smaller string till it doesnt matches with larger string's some char
// nd if any of the string's length becomes 0 we return 0
// hence finally if that smaller string is a subsequence then for sure the value that checker function will return by adding 1+recursive calls should be equal to smaller string's length
// as checker was counting how many chars match as for each match it was calling 1+recursive call..hence was incrementing 1 for each match
// so finally if it equals smaller's string length then return true..else false