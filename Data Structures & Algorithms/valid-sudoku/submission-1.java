class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0) {
            return false;
        }
        for(int row=0;row<9;row++) {
            Set<Character> seen = new HashSet<>();
            for(int col = 0;col < 9;col++) {
                if(board[row][col] == '.') {
                    continue;
                }
                if(seen.contains(board[row][col])) {
                    return false;
                }
                seen.add(board[row][col]);
            }
        }

        for(int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for(int row = 0;row < 9;row++) {
                if(board[row][col] == '.') {
                    continue;
                }
                if(seen.contains(board[row][col])) {
                    return false;
                }
                seen.add(board[row][col]);
            }
        }

        for(int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for(int row = 0; row < 3; row++) {
                for(int col = 0; col < 3; col++) {
                    int r = (square / 3) * 3 + row;
                    int c = (square % 3) * 3 + col;
                    if(board[r][c] == '.') {
                        continue;
                    }
                    if(seen.contains(board[r][c])) {
                        return false;
                    }
                    seen.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
