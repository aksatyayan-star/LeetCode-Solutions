class Solution {
    public int trap(int[] height) {
        int quant = 0;
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        
        lmax[0] = height[0];
        for(int i=1;i<height.length;i++)
        {
            lmax[i] = Math.max(height[i], lmax[i-1]);
        }
        
        rmax[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            rmax[i] = Math.max(height[i], rmax[i+1]);
        }
        
        for(int i=1;i<n-1;i++)
        {
            quant = quant + (Math.min(lmax[i],rmax[i])-height[i]);
        }
        return quant;
    }
}

// here also the approach is same as in naive solution below but here we are precalculating the lmax and rmax for each bar and storing it in arrays lmax and rmax respectively
// for lmax we are traversing from left and checking for max to the left of each bar
// for rmax we are traversing from right and checking for max to the right of each bar
// and storing both in their respective arrays...so that during calculating final result ...we can directly fetch the values of lmax and rmax for each bar from these arrays
// and subtract the height of bar from min of both of them and keep adding it to final result ..to get the final quant value.


/* public int trap(int[] height) {
        int quant = 0;
        for(int i=1;i<height.length-1;i++)
        {
            int lmax = height[i];
            for(int j=0;j<i;j++)
            {
                lmax = Math.max(lmax,height[j]);
            }
            int rmax = height[i];
            for(int j=i+1;j<height.length;j++)
            {
                rmax = Math.max(rmax,height[j]);
            }
            quant = quant + (Math.min(lmax,rmax)-height[i]);
        }
        return quant;
    }
*/
// here the naive solution is that excluding 1st and last bar which cannot store water, we have to find for every other bars, the left and right max of them
// the water stored will be till the min of both lmax and rmax...so we find which is min for that particular bar...lmax or rmax
// once getting that we subtract the height of that bar itself from the min of both of them...whether it be lmax or rmax
// this way we keep finding for each bar and adding the result in quant.
// for the bars which itself is lmax or rmax or both...we will get lmax or rmax or both as the height of bar itself
// so in that condition when we subtract height of bar from min of lmax or rmax then we will get result as zero which stands true.