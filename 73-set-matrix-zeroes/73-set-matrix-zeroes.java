class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> column = new ArrayList<Integer>();
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++)
                if(matrix[i][j]==0)
                {
                    row.add(i);
                    column.add(j);
                }

        for(int i=0; i<row.size(); i++)
            for(int j=0; j<matrix[0].length; j++)
                matrix[row.get(i)][j]=0;
        for(int i=0; i<column.size(); i++)
            for(int j=0; j<matrix.length; j++)
                matrix[j][column.get(i)]=0;
    }
}

// the approach is simple...find elements which are 0...store their row index and column index in row and column arraylist respectively
// then once all 0 elements found and their repsective row and column index we stored in respective arraylist
// then pick each element from row list and vary j i.e column index from 0 to matrix's column's length and make each element 0
/// this way we set the entire row 0
// then pick each element from column list and vary j i.e row index from 0 to matrix's row's length and make each element 0
/// this way we set the entire column 0