package com.liujj.queue;

import java.util.LinkedList;

/**
 * @author 刘俊杰
 * @program: leetcode-learn
 * @description:
 * @create: 2019-12-26 09:36
 **/
public class IslandNumber {

  public static int numIslandsDFS(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int islandCount = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          islandCount++;
          dfs(i, j, grid);
        }
      }
    }
    return islandCount;
  }

  private static void dfs(int i, int j, char[][] grid) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    dfs(i - 1, j, grid);
    dfs(i + 1, j, grid);
    dfs(i, j - 1, grid);
    dfs(i, j + 1, grid);
  }

  public static int numIslandsBFS(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int islandCount = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          LinkedList<Integer> queue = new LinkedList<>();
          islandCount++;
          queue.add(i * n + j);
          grid[i][j] = '0';
          while (!queue.isEmpty()) {
            int root = queue.remove();
            int x = root / n;
            int y = root % n;
            if (x < m -1 && grid[x + 1][y] == '1') {
                   queue.add((x +1)*n + y);
                   grid[x + 1][y] = '0';
            }
            if (x > 0 && grid[x - 1][y] == '1'){
                queue.add((x - 1)*n + y);
                grid[x - 1][y] = '0';
            }
            if (y < n -1 && grid[x][y + 1] == '1') {
              queue.add(x*n + y + 1);
              grid[x][y + 1] = '0';
            }
            if (y > 0 && grid[x][y - 1] == '1') {
              queue.add(x*n + y - 1);
              grid[x][y - 1] = '0';
            }
          }
        }
      }
    }
    return islandCount;

  }


  public static void main(String[] args) {
    char[][] grid0 = {{'1', '0', '0', '0'}, {'1', '1', '0', '1'}, {'1', '0', '1', '0'},
        {'1', '0', '0', '0'}};
    char[][] grid1 = {{'1', '1', '1', '1','0'}, {'1', '1', '0', '1','0'}, {'1', '1', '0', '0','0'},
        {'0', '0', '0', '0','0'}};
    char[][] grid2 = {{'1', '1', '0', '0','0'}, {'1', '1', '0', '0','0'}, {'0', '0', '1', '0','0'},
        {'1', '1', '0', '0','0'}};
    int count = numIslandsDFS(grid0);
    int count2 = numIslandsDFS(grid1);
    int count3 = numIslandsDFS(grid2);
    System.out.println("----------------DFS------------");
    System.out.println(count);
    System.out.println(count2);
    System.out.println(count3);
    char[][] grid4 = {{'1', '0', '0', '0','0'}, {'1', '1', '0', '1','0'}, {'1', '0', '1', '0','0'},
        {'1', '0', '0', '0','0'}};
    char[][] grid5 = {{'1', '1', '1', '1','0'}, {'1', '1', '0', '1','0'}, {'1', '1', '0', '0','0'},
        {'0', '0', '0', '0','0'}};
    char[][] grid6 = {{'1', '1', '0', '0','0'}, {'1', '1', '0', '0','0'}, {'0', '0', '1', '0','0'},
        {'1', '1', '0', '0','0'}};

    int bfsCount = numIslandsBFS(grid4);
    int bfsCount2 = numIslandsBFS(grid5);
    int bfsCount3 = numIslandsBFS(grid6);
    System.out.println("----------------BFS------------");
    System.out.println(bfsCount);
    System.out.println(bfsCount2);
    System.out.println(bfsCount3);
  }
}
