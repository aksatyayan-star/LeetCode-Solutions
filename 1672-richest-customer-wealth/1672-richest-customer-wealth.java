class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int sum=0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                sum = sum + accounts[i][j];
            }
            ans.add(sum);
            sum=0;
        }
        return Collections.max(ans);
    }
}