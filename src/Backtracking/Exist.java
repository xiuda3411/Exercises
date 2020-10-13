package Backtracking;

/**
 * @program: Exercises
 * @description: 单词搜索
 * @author: 宋丽
 * @create: 2020-10-13 13:31
 **/
public class Exist {
    /**
     * 回溯
     * 本来想像岛屿问题一样用dfs直接解决，但是此问题必须回溯
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int clu = board[0].length;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < clu ; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean flag = search(board, word, i, j, 0);
                    if (flag){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int i, int j,int len) {
        int row = board.length;
        int clu = board[0].length;

        if (board[i][j] != word.charAt(len)){
            return false;
        }else if (len == word.length()-1){
            return true;
        }
        char a = board[i][j];
        board[i][j] = '#';
        int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean result = false;
        for (int[] dir : direction) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 && newi < row && newj >= 0 && newj < clu){
                if (board[newi][newj]!='#'){
                    boolean flag = search(board, word, newi, newj, len+1);
                    if (flag){
                        result =  true;
                        break;
                    }
                }
            }
        }
        board[i][j] = a;
        return result;
    }
}
