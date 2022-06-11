class Solution {
    public String truncateSentence(String s, int k) {
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==' ')
            {
                count++;
            }
            if(count==k)
            {
            return s.substring(0,i);
            }
        }
        return s;
    }
}

//its a simple string problem...where we have to return first k words of a given sentence consisisting of many words separated by spaces
// so what we do we run a loop and check for spaces once we find space characters we update a count var
// nd inside that for loop only after increasing count we also check if that count became equal to given k value
// if yes then simply return the substring of whole s string from start i.e 0 to that i at which the count became equal to k
// as till then only we will have the req first k words of the whole sring ...else return the whole string...if the whole for loop completed and still count!=k
// as then the k must have been greater than no of words so in that condition whole sentence with all words should be returned so return s