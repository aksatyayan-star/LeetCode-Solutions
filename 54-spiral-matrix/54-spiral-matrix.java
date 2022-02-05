class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int left=0;
        int bottom = matrix.length-1;
        int right=matrix[0].length-1;
        List<Integer> res = new ArrayList<Integer>();
        while(top<=bottom && left<=right)
        {
            for(int i=left; i<=right; i++)
            {
                res.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++)
            {
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom)
            {
                for(int i=right; i>=left; i--)
                {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right)
            {
                for(int i=bottom; i>=top; i--)
                {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}

// we are initializing four variables to keep track of rows and columns
// for rows top and bottom are used and for columns left and right are used
// now we first add 1st row elemnts from left to right and then increase top as we printed 1st row
// then we add last column from top to bottom and we already incremented top by 1 so no repetition of right top corner element...
// again as last column added increase right by 1
// then we add last row from right to left and again as we incremented right by 1 so no repetition of bottom right corner element when adding last row
// again after adding bottom row..increase bottom by 1
// then we add left column from top to bottom and as top and bottom already incremented so no repetition will happen again
// and after adding increase left by 1
// so this was whole first iteration in which we printed the 1st outer boundary layer of matrix
// so like this we will keep moving to inner layers and add in the same way...we will move to inner layers with no repetition as 
// after whole 1st iteration the value of all 4 var would have been incremented by 1 so automatically we will access the elments of inner layer to current layer of matrix without any repetition