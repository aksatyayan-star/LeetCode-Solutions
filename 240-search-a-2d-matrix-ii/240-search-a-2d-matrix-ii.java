class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int column = n-1;
        while(row<m && column>=0)
        {
        if(matrix[row][column]==target)
        {
            return true;
        }
        else if(matrix[row][column]>target)
        {
            column--;
        }
        else
        {
            row++;
        }
        }
      return false; 
    }
}

// so here the logic is that we start from top right element of the matrix..i.e row = 0 and column = matrix[0].length - 1
// and as long as row < no of rows and columns > 0 we remain in while loop
// when we encounter our matrix[row][column] = target , we return true that means the target is present
// else as rows and columns are sorted in increasing order from left to right and from top to bottom respectively
// so if we encounter element > target we move left as if that element greater..then for sure the elements down to it in that column will be even more greater...
// so we move one column to left..again check and if that element < target then we move down in that column as there is possibility we can find our target down in that column
// as sorted increasing from top to bottom...again in mid way moving down we emcounter element greater than our target
// then again we change our column and move left..and like this we keep on changing rows and columns

// we can also do this approach using bottom left element..just there will be a little change in approach...
// like if element > target we will move up i.e row-- and when element < target we move right i.e column++
