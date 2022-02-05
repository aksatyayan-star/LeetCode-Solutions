class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<matrix[i].length; j++)
            {
                swap(matrix,i,j);
            }
        }
        for(int i=0; i<n; i++)
        {
            int low =0;
            int high= n-1;
            while(low<high)
            {
                swap(matrix,low,high,i);
                low++;
                high--;
            }
        }
    }
    public void swap(int[][] matrix, int m, int n)
    {
        int temp = matrix[m][n];
        matrix[m][n] = matrix[n][m];
        matrix[n][m] = temp;
    }
    public void swap(int[][] matrix, int low, int high, int i)
    {
        int temp = matrix[i][low];
        matrix[i][low] = matrix[i][high];
        matrix[i][high] = temp;
    }
}

// as we have to do in place rotation, and not allocate another 2D matrix to do rotation
// so we have to take help from transpose of matrix as for square matrix, the transpose of matrix can be found without using any extra 2D matrix...
// the concept can be found in detail in transpose of matrix ques
// now once we got transpose, then the diff is that we just have to reverse each elements of row then we can get our required matrix...
// for clockwise 90 deg rotation...reverse elements of row
// for anticlockwise 90 deg rotataion...reverse elements of column
// for reversing again use swap function ...keeping i constant i.e row index in each iteration and varying low and high i.e column index