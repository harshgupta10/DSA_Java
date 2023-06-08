class Pair{
   public int a;
   public int b;
   Pair(int a,int b){
       this.a=a;
       this.b=b;
   }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Pair> al = new ArrayList<Pair>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    Pair temp=new Pair(i,j);
                    al.add(temp);
                }
            }
        }

        for(int k=0;k<al.size();k++){
             Pair temp=al.get(k);
             int r=temp.a;
             for(int i=0;i<matrix[0].length;i++){
                 matrix[r][i]=0;
             }
             int c=temp.b;
             for(int i=0;i<matrix.length;i++){
                 matrix[i][c]=0;
             }
        }

    }
}