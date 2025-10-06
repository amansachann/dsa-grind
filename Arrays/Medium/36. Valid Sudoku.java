class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows 
        for(int r=0; r<9; r++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0; i<9; i++) {
                if(board[r][i]!='.') {
                    if(seen.contains(board[r][i])) return false;
                    seen.add(board[r][i]);
                }
            }
        }

        // check cols 
        for(int c=0; c<9; c++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0; i<9; i++) {
                if(board[i][c] != '.') {
                    if(seen.contains(board[i][c])) return false;
                    seen.add(board[i][c]);
                }
            }
        }

        // check squares
        for(int sq=0; sq<9; sq++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    int r = (sq/3)*3 + i;
                    int c = (sq%3)*3 + j;
                    if(board[r][c] != '.') {
                        if(seen.contains(board[r][c])) return false;
                        seen.add(board[r][c]);
                    }
                }
            }
        }

        return true;
    }
}