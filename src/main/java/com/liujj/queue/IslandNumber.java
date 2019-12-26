package com.liujj.queue;

/**
 * @program: leetcode-learn
 * @description:
 * @author 刘俊杰
 * @create: 2019-12-26 09:36
 **/
public class IslandNumber {
  public static int numIslandsDFS(char[][] grid) {
        if (grid.length == 0){
          return -1;
        }
        int islandCount = 0;
        for (int i = 0 ; i < grid.length;i++){
          for (int j = 0; j < grid[i].length; j++){
               if (grid[i][j] == '1'){
                 islandCount++;
                 dfs(i,j,grid);
               }
          }
        }
        return islandCount;
  }

  private static void dfs(int i, int j, char[][] grid) {
            if (i < 0 || j < 0  || i >= grid.length || j >= grid[i].length || grid[i][j] == '0'){
              return;
            }
            grid[i][j] = '0';
            dfs(i - 1, j, grid);
            dfs(i + 1, j, grid);
            dfs(i  , j -1, grid);
            dfs(i , j + 1, grid);
  }
  public static void main(String[] args){
      char[][] grid = {{'1','0','0','0'},{'1','1','0','1'},{'1','0','1','0'},{'1','0','0','0'}};
      int count = numIslandsDFS(grid);
      System.out.println(count);
  }
}
