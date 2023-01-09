class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        TreeSet<Integer> pq = new TreeSet<Integer>((r1,r2) -> -Integer.compare(r1,r2));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pq.add(grid[i][j]);
                if (pq.size() > 3) {
                    pq.pollLast();
                }
            }
        }
        int k = 1;
        while (k < n) {
            for (int i = k; i < n - k; i++) {
                for (int j = k; j < m - k; j++) {
                    pq.add(getSum(grid, i, j, k));
                    if (pq.size() > 3) {
                        pq.pollLast();
                    }
                }
            }
            k++;
        }
        int[] res = new int[Math.min(pq.size(), 3)];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.pollFirst();
        }
        return res;
    }
    
    int getSum(int[][] grid, int i, int j, int k) {
        int sum = 0;
        
        int row = i;
        int col = j - k;
        while (row > i - k && col < j) {
            sum += grid[row][col];
            row--;
            col++;
        }
        while (row < i && col < j + k) {
            sum += grid[row][col];
            row++;
            col++;
        }
                while (row < i + k && col > j) {
            sum += grid[row][col];
            row++;
            col--;
        }
        while (row > i && col > j - k) {
            sum += grid[row][col];
            row--;
            col--;
        }
        return sum;
    }
}