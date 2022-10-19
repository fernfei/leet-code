package depth;

/**
 * create by hufei on 2022-10-18 00:19
 */
public class AroundXO {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'},
        };
        solve(board);
    }

    /**
     * 找出被围的'O'
     *
     * @param board 矩阵
     */
    public static void solve(char[][] board) {
        int x = board.length;
        int y = board[0].length;
        // 1.先将矩阵四周的'O'变为'#'以及与其连接的
        for (int i = 0; i < y; i++) {
            dfs(board, 0, i);//上
            dfs(board, x - 1, i);//下
        }

        for (int i = 1; i < x; i++) {
            dfs(board, i, 0);//左
            dfs(board, i, y - 1);//右
        }
        // 2.将所有'O'元素变为'X' '#'变为'O'；其中'#'表示未被包围的'O'
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 将'O'转换成'#' 并找出以（x,y）为中心四周的'O'变成'#'
     *
     * @param board 矩阵
     * @param x     x
     * @param y     y
     */
    private static void dfs(char[][] board, int x, int y) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] != 'O') {
            return;
        }
        board[x][y] = '#';
        dfs(board, x - 1, y);//上
        dfs(board, x, y + 1);//右
        dfs(board, x + 1, y);//下
        dfs(board, x, y - 1);//左
    }

}
