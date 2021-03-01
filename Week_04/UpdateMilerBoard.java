import java.util.Arrays;

/**
 * 529. 扫雷游戏
 */
public class UpdateMilerBoard {

  public static void main(String[] args) {
    //
    char[][] board = new char[][]{
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'M', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'}
    };
    UpdateMilerBoard updateMilerBoard = new UpdateMilerBoard();
    System.out.println(Arrays.deepToString(updateMilerBoard.updateBoard(board, new int[]{3, 2})));
  }

  public char[][] updateBoard(char[][] board, int[] click) {
    int x = click[0], y = click[1];
    int rows, cols;
    if (board == null || (rows = board.length) == 0 || !isValidIdxOfBoard(x, y, rows,
        cols = board[0].length)) {
      System.out.println("invalid board");
      return board;
    }

    // 规则1： 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'
    if (board[x][y] == 'M') {
      board[x][y] = 'X';
    } else {
      //八个方向的X,Y偏移
      final int[] dirX = {-1, 1, 0, 0, -1, 1, -1, 1};
      final int[] dirY = {0, 0, -1, 1, -1, 1, 1, -1};
      dfsUpdateBoard(board, x, y, rows, cols, dirX, dirY);
    }
    return board;
  }

  private boolean isValidIdxOfBoard(int x, int y, int rows, int cols) {
    return x >= 0 && x < rows && y >= 0 && y < cols;
  }

  private void dfsUpdateBoard(char[][] board, int x, int y, int rows, int cols, int[] dirX,
      int[] dirY) {
    // 越界或者如果已经处理过，则不再处理
    if (!isValidIdxOfBoard(x, y, rows, cols) || board[x][y] != 'E') {
      return;
    }

    // 统计相邻地雷数(八个方向)
    int count = 0;
    for (int i = 0; i < 8; i++) {
      int tx = x + dirX[i];
      int ty = y + dirY[i];
      if (isValidIdxOfBoard(tx, ty, rows, cols) && board[tx][ty] == 'M') {
        count++;
      }
    }

    // 规则2：如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
    if (count == 0) {
      board[x][y] = 'B';
      for (int i = 0; i < 8; i++) {
        dfsUpdateBoard(board, x + dirX[i], y + dirY[i], rows, cols, dirX, dirY);
      }
    } else {
      // 规则3： 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
      board[x][y] = (char) (count + '0');
    }
  }
}
