class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0;
        int max = 0;
        for(int i=0; i<gain.length; i++)
        {
            if(alt+gain[i]>max)
            {
                max = alt+gain[i];
            }
            alt = alt+gain[i];
        }
        return max;
    }
}
