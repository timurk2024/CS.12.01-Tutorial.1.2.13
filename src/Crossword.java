public class Crossword {

    private Square[][] puzzle;

    public Crossword(boolean[][] blackSquares) {
        int label = 1;
        this.puzzle = new Square[blackSquares.length][blackSquares[0].length];

        for (int row = 0; row < blackSquares.length; row++) {
            for (int col = 0; col < blackSquares[row].length; col++) {
                if (!blackSquares[row][col] && toBeLabeled(row, col, blackSquares)) {
                    puzzle[row][col] = new Square(false, label++);
                } else {
                    puzzle[row][col] = new Square(blackSquares[row][col], 0);
                }
            }
        }
    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
        // A square should be labeled if it's the first square in its row/column,
        // or the square to its left/above it is black
        return (r == 0 || blackSquares[r - 1][c]) || (c == 0 || blackSquares[r][c - 1]);
    }


    public Square[][] getPuzzle()
    {
        return puzzle;
    }

}
