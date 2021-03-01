public class NumIslands {

  public static void main(String[] args) {
    //
    char[][] grid = new char[][]{
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };
    NumIslands test = new NumIslands();
    System.out.println(test.numIslands(grid));
  }

  public int numIslands(char[][] grid) {
    int row, col, count = 0;
    if (grid == null || (row = grid.length) == 0) {
      return count;
    }
    col = grid[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1') {
          count++;
          dfsMarking(grid, i, j, row, col);
        }
      }
    }
    return count;
  }

  private void dfsMarking(char[][] grid, int i, int j, int row, int col) {
    // 越界检查，以及跳过已经标记过的或者本是水域的元素
    if (i < 0 || i == row || j < 0 || j == col || grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0';
    dfsMarking(grid, i - 1, j, row, col); //向上
    dfsMarking(grid, i + 1, j, row, col); //向下
    dfsMarking(grid, i, j - 1, row, col); //向左
    dfsMarking(grid, i, j + 1, row, col); //向右
  }
}
