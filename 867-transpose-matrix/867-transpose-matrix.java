class Solution {
    public int[][] transpose(int[][] matrix) {
        
        int a=matrix.length;
		int b=matrix[0].length;

		int[][] trans= new int[b][a];

		for(int i=0;i<a;i++){
			 for(int j=0;j<b;j++){
					trans[j][i]=matrix[i][j];
			 }
		}
		return trans;
    }
}

// for all matrices this above approach is best    
        
        
        /*
        int n = matrix.length;
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<matrix[i].length; j++)
            {
                swap(matrix,i,j);
            }
        }
        return matrix;
    }
    public void swap(int[][] matrix, int m, int n)
    {
        int temp = matrix[m][n];
        matrix[m][n] = matrix[n][m];
        matrix[n][m] = temp;
        */

// for square matrix
// here an efficient approach will be in place swapping in one traversal only without the need of any temp arr to be formed
// so the concept is like in transpose the diagonal elements remain the same at their position
// so what we need to do is that swap along diagonal...like in 1st row...1st element will be the diagonal element...
// so go to upper element to diagonal i.e 4 and -1 and swap them with lower element to diagonal i.e -10 and 18 respectively
// same in 2nd traversal i.e 2nd row diagonal elemnt is 5 so we start from upper element to it which is 11 and swap it with lower i.e -7 
// and our whole matrix transpose is done...
// for getting upper element to diagonal element we start our 2nd loop from index 1 greater than current row index