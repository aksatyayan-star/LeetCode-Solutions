class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> column = new ArrayList<Integer>();
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j]==0)
                {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for(int i=0; i<row.size(); i++)
        {
        System.out.println(row.get(i));
        }
        for(int i=0; i<column.size(); i++)
        {
        System.out.println(column.get(i));
        }
        for(int i=0; i<row.size(); i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                matrix[row.get(i)][j]=0;
            }
        }
        for(int i=0; i<column.size(); i++)
        {
            for(int j=0; j<matrix.length; j++)
            {
                matrix[j][column.get(i)]=0;
            }
        }
    }
}