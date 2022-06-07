class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m+1][n+1];
        //memo[0][0]=0;
        /*for(int j=1; j<m; j++)
        {
            memo[0][j] = m;
        }
        for(int i=1; i<n; i++)
        {
            memo[i][0] = n;
        }
        */
        for(int i=0; i<m+1; i++)
        {
            for(int j=0; j<n+1; j++)
            {
                memo[i][j] = -1;
            }
        }
        return minDis(word1, word2, m, n, memo);
    }
    int minDis(String s1, String s2, int m, int n, int[][] memo)
    {
        if(memo[m][n]!= -1)
        {
            return memo[m][n];
        }
        if(m==0)
        {
            //return n;
            memo[0][n] = n;
        }
        else if(n==0)
        {
            //return m;
            memo[m][0] = m;
        }
        else
        {
            if(s1.charAt(m-1)==s2.charAt(n-1))
            {
                //return minDis(s1, s2, m-1, n-1);
                memo[m][n] = minDis(s1, s2, m-1, n-1, memo);
            }
            else
            {
                //return 1+ Math.min(minDis(s1, s2, m, n-1),minDis(s1, s2, m-1, n),minDis(s1, s2, m-1, n-1));
                int s = Math.min(minDis(s1, s2, m, n-1, memo),minDis(s1, s2, m-1, n, memo));
                s = Math.min(s, minDis(s1, s2, m-1, n-1, memo));
                //return 1+s;
                memo[m][n] = 1+s;
            }
        }
        return memo[m][n];
    }
}
// we generally traverse from the end...for easy solution
// the prob is kind of similar to LCS but with some variation
// there when finding similar character we add 1 and call for characters of both strings next to that similar character from the end
// and if character mismatch then we make two calls...1 call reducing the length of 1st string by 1 and leaving 2nd as it is
// 2nd call reducing the length of second string by 1 and leaving the 1st as it is...like this if any length becomes 0 we return 0
// as for 0 length string the LCS can only be 0
// here what we do if we get a same character we leave it as it is and call for both strings by reducing their length by 1...
// in LCS we used to do same thing but by adding 1 to it as we needed LCS hence if one character matched then LCS min must be 1
// but here if we find something matching it means we dont have to do anyting...any operations on it so we just move ahead
// we do something when we find mismatching char...as then we have three options insert delete or replace ...hence we make three calls by adding 1
// as any of these opearations done hence we have to add 1..to make it count
// and finally we will take min of all three operations that is in which of these opeartions min steps were invloved...automatically that will be considered in our final result
// now in insertion we wil insert the last char of second string where mismatch happend to the first string...
// hence now the call will be of reducing length of the 2nd string by 1 and as it is for 1st string...as one extra character was inserted in 1st string to match with 2nd string's mismatched character
// so now they matched ...so call will be for 1 less than length for both strings as thats what we do when match happens...
// but as 1st string was increased by 1 length bczz of insertion of extra char so during call the length of 1st will remain as it is but 2nd will be reduced by 1
// now in deletion the call will be like 1st's length will be reduced by 1 ..2nd's will remain as it is
// as we are deleting one char from 1st string and doing nothing on 2nd
// now in replace as we will replace mismatching char of 1st string with 2nd string's char...hence now after replacing they will match
// so when match what we do we just call for length less than 1 for both strings as matched so we skip those char and call for remaining
// hence in replace call will be for 1 less than length of both the strings
// so what we do overall we do some operation reduce the length of string and make recursive calls
// now base case will be as we are reducing the length of both strings...so if 1st becomes zero then we need to return length of 2nd string
// as when 1st empty then to make it similar to 2nd the min no of operations is to insert all the char of 2nd to 1st hence no of insert operations = length of 2nd string
// now if 2nd becomes 0...then to make 1st similar to 2nd...we will have to delete all char of 1st...that's the min no of opeartions possible way
// so in that case return length of 1st string as we have to delete all char of 1st so no of opeartions = length of 1st...as that many no of deletions..each char deletion

// now to further optimize solution we will apply DP..memorization method...so again as usual initialize all elements of array as -1
// and we have 2d array as two parameters changing in each function call i.e the length of both strings m and n..
// nd we just store the result in memo array instead of just returning it directly that's all and as earlier we were returning when m=0 and n=0 
// so automatically the function used to stop there so it would not go below like for checking if(s1.charAt(m-1)==s2.charAt(n-1)) this line
// but now as we are not returning and storing it so if we will put it in if or else if then call will go in this statement also after checking for m= 0 or n= 0
// and it will give array index out of bound error as m =0 or n= 0 so m-1 , n-1 cant be accessed hence to overcome it we will have to put all these 
// in another else condition to those m=0 n= 0 if else flow and inside that else condition normal if else can be implemented 
// like we used to earlier without the external else that we just added...so just these are the little variations to take care of when converting normal recursion soluton to DP