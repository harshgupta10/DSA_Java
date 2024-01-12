class Solution {
	public class Pair implements Comparable<Pair>{
		int ele;
		int r;
		int c;
		
		public Pair(int ele, int r, int c) {
			this.ele = ele;
			this.r = r;
			this.c = c;
		}
		
		public int compareTo(Pair o) {
			return this.ele - o.ele;
		}
	}
    
	int[] rows;
	int[] cols;
	int[] par;
	int[] rank;
	
    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        rows = new int[n];
        cols = new int[m];
        par = new int[n * m];
        rank = new int[n * m];
        Pair[] arr = new Pair[n * m];
        int count = 0;
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		arr[count] = new Pair(matrix[i][j], i, j);
        		count++;
        	}
        }
        Arrays.sort(arr);
        List<Pair> ls = new ArrayList<>();
        int last = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i].ele != last) {
        		process(ls, matrix);
        		last = arr[i].ele;
        		ls = new ArrayList<>();
        	}
        	ls.add(arr[i]);
        }
        
        process(ls, matrix);
        return matrix;
    }
    
    public int findp(int x, int[] par) {
    	if(par[x] < 0)
    		return x;
    	int temp = findp(par[x], par);
    	par[x] = temp;
    	return temp;
    }
    
    public void process(List<Pair> ls, int[][] matrix) {
    	int n = matrix.length;
    	int m = matrix[0].length;
    	int[] par = new int[n + m];
    	for(int i = 0; i < par.length; i++)
            par[i] = -1;
    	
    	for(Pair p : ls) {
    		int i = p.r;
    		int j = p.c;
    		
    		int p1 = findp(i, par);
    		int p2 = findp(n + j, par);
    		
    		if(p1 != p2) {
    			int maxrank = Math.min(par[p1], 
                                       Math.min(par[p2], -Math.max(rows[i], cols[j]) - 1));
    			par[p2] = maxrank;
    			par[p1] = p2;
    		}
    	}
    	
    	for(Pair p : ls) {
            int i = p.r;
    		int j = p.c;
            
    		int parp = findp(p.r, par);
    		matrix[i][j] = -par[parp];
            
            rows[i] = matrix[i][j];
            cols[j] = matrix[i][j];
    	}
    }
}