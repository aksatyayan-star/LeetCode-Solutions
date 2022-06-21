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