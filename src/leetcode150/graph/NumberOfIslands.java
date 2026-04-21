package leetcode150.graph;

public class NumberOfIslands {

    public int islands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if(i<0 || i >= grid.length || j<0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        //Mark cell as visited
        grid[i][j] = 0;

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

    }

    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        System.out.println("Number of Island(s): "+islands.islands(grid));
    }
}
