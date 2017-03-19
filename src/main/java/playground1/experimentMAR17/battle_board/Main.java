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

    public static void main(String[] args) {
        Board board = new Board();
        MyPoint p = new MyPoint();
        p.x = 1;
        p.y = 1;

        board.putFigureOnBoard(p, "Gob");


        printBoard(board);

    }


}
