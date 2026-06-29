class Solution {
    public boolean exist(char[][] board, String word) {
        return existWord(board, word);
        
    }

     private boolean func(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(k) != board[i][j]) {
            return false;
        }

        // Temporarily mark the cell as visited
        char temp = board[i][j];
        board[i][j] = ' ';

        // Check all four possible directions (down, up, right, left)
        boolean ans = func(board, i + 1, j, word, k + 1) ||
                      func(board, i - 1, j, word, k + 1) ||
                      func(board, i, j + 1, word, k + 1) ||
                      func(board, i, j - 1, word, k + 1);
        board[i][j] = temp;

        return ans;
    }

    // Main function to check if the word exists in the board
    public boolean existWord(char[][] board, String word) {
        // Iterate through each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the first character matches, start the search
                if (board[i][j] == word.charAt(0)) {
                    // If the word is found, return true
                    if (func(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        // If the word is not found, return false
        return false;
    }
}