package playground1.experimentMAR17.battle_board;

/**
 * Main game runner
 */


public class Main {

    public static void printBoard(Board board) {
        MyPoint p = new MyPoint();
        int cellCounter = 0;

        for (int i = 0; i < board.getBoardSize(); i++) {
            System.out.println("");

            for (int j = 0; j < board.getBoardSize(); j++) {
                p.x = i;
                p.y = j;
                System.out.print(String.format("[%d,%d]:%s", i, j, board.getFigureFromBoard(p)));
            }
        }
    }

    public static void fillBoard(Board board) {
        MyPoint p = new MyPoint();
        for (int i = 0; i < board.getBoardSize(); i++) {
            p.x = i % 3;
            p.y = (i - i % 3) / 3;
            board.putFigureOnBoard(p, "X");
        }
    }

    public static void main(String[] args) {

        Board board = new Board();

        fillBoard(board);
        printBoard(board);


    }


}
