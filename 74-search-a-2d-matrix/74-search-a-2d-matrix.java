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

// same approach as in the Search a 2D Matrix || ques