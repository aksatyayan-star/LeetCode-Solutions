class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int a=0,b=0,c1=0,c2=0;
        vector<int>v;
        for(int i=0;i<nums.size();i++){
            int c=nums[i];
            if(a==c)
                c1++;
            else if(b==c)
                c2++;
            else if(c1==0){
                a=c;
                c1++;
            }
            else if(c2==0){
                b=c;
                c2++;
            }
            else{
                c1--;c2--;
            }
        }
         c1=0;c2=0;
        for(auto &c:nums){
            if(a==c)
                c1++;
            else if(b==c)
                c2++;
        }
        if(c1>nums.size()/3)
            v.push_back(a);
        if(c2>nums.size()/3)
            v.push_back(b);
        return v;
    }
};