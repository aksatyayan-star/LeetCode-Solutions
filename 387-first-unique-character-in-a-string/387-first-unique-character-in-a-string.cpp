class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<int,int>mp;
        for(char &c:s){
            mp[c]++;
        }
        int i=0;
        for(char &c:s){
            if(mp[c]==1)
                return i;
            i++;
        }
        return -1;
    }
};