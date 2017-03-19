package playground1.experimentMAR17.battle_board;

/**
 * Main game runner
 */

public class Main {
    // TODO read my code tomorrow , see if it is readable and understandable without comments

    public static void printBoard(Board board) {
        MyPoint p = new MyPoint();
        int cellCounter = 0;

        for (int i = 0; i < board.getBoardSize(); i++) {
            System.out.println("");

            for (int j = 0; j < board.getBoardSize(); j++) {
                p.x = i;
                p.y = j;
                System.out.print(String.format("[%d,%d]:%s", i, j, board.getFigureFromBoard(p)));
                cellCounter++;
            }
        }
        System.out.println("\nTotal cells : " + cellCounter);
    }

    public static void fillBoard(Board board) {
        /** just a filler , ignore logic with reminders
         *  fills board with valid "winning" combination
         */

        MyPoint p = new MyPoint();
        for (int i = 0; i < board.getBoardSize(); i++) {
            p.x = i % 3;
            p.y = (i - i % 3) / 3;
            board.putFigureOnBoard(p, "X");
        }
    }

    public static void checkIfTriple(Board board, String figure) {
        // TODO check if [0,0] == [1,0] == [2,0] if yes return ?
        MyPoint p = new MyPoint();
        int countFigures = 0;

        for (int i = 0; i < board.getBoardSize(); i++) {
            p.x = i;
            p.y = 0;

            if (board.getFigureFromBoard(p).equals(figure)) {
                countFigures += 1;
            }
        }

        if ((countFigures == 3)) {
            System.out.printf("figure \"%s\" has winning combo!%n", figure);

        } else {
            System.out.printf("figure \"%s\" has no winning combination!%n", figure);
        }

    }

    public static void main(String[] args) {

        Board board = new Board();

        fillBoard(board);
        printBoard(board);
        checkIfTriple(board, "X");
        checkIfTriple(board, "O");


    }


}
