package com.fosuchao.enterprise.bytedance.enterprise;


/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 200. 岛屿数量
 */

public class Num200 {

    int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int r, c;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        r = grid.length;
        c = grid[0].length;
        int landCount = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    landCount++;
                }
            }
        }
        return landCount;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int [] d : directions) {
            dfs(i + d[0], j + d[1], grid);
        }
    }
}
