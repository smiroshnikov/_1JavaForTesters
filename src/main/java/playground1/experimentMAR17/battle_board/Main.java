package playground1.experimentMAR17.battle_board;

/**
 * Main game runner
 */

// TODO read the code after 2 weeks , and see if you can understand what you have coded ?

public class Main {

    /**
     * Fills board with null values
     */
    public static void resetBoard(Board board) {

        MyPoint p = new MyPoint();
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                p.x = i;
                p.y = j;
                board.putFigureOnBoard(p, null);
            }
        }

    }

    /**
     * prints board via console
     *
     * @param board NxN gaming field
     */

    public static void printBoard(Board board) {
        MyPoint p = new MyPoint();
        int cellCounter = 0;

        for (int i = 0; i < board.getBoardSize(); i++) {
            System.out.println("");

            for (int j = 0; j < board.getBoardSize(); j++) {
                p.x = i;
                p.y = j;
                if (board.getFigureFromBoard(p) == null) {
                    System.out.print(String.format("\t(%d,%d)[ ]\t", i, j));
                } else {
                    System.out.print(String.format("\t(%d,%d)[%s]\t", i, j, board.getFigureFromBoard(p)));
                    cellCounter++;
                }
            }
        }
        //System.out.println("\nTotal cells : " + cellCounter);
        System.out.println("");
    }

    public static void fillBoardVertical(Board board, int row, String figure) {


        MyPoint p = new MyPoint();
        for (int i = 0; i < board.getBoardSize(); i++) {
            p.x = i % 3;
            p.y = row;
            board.putFigureOnBoard(p, figure);
        }
    }

    public static void fillOne(Board board) {
        MyPoint point = new MyPoint();
        point.x = 2;
        point.y = 2;

        board.putFigureOnBoard(point, "S");
    }

    public static void fillBoardHorizontally(Board board, int row, String figure) {
        MyPoint p = new MyPoint();
        for (int i = 0; i < board.getBoardSize(); i++) {
            p.x = row;
            p.y = i;
            board.putFigureOnBoard(p, figure);
        }
    }

    public static void fillBoardDiagonal1(Board board, String figure) {
        MyPoint p = new MyPoint();
        for (int i = 0; i < board.getBoardSize(); i++) {
            p.x = i;
            p.y = i;
            board.putFigureOnBoard(p, figure);
        }

    }

    public static void fillBoardDiagonal2(Board board, String figure) {
        MyPoint p = new MyPoint();
        for (int i = 0; i < board.getBoardSize(); i++) {
            p.x = i;
            p.y = board.getBoardSize() - i - 1;
            board.putFigureOnBoard(p, figure);
        }

    }

    public static boolean checkHorizontal(Board board, String figure) {

        // TODO this method was written my way , before understanding a proper solution , while it uses switch and works
        // TODO I am still unable to see any advantages over hard coded winning solution for tic tac toe

        MyPoint p = new MyPoint();
        int countFigures = 0;
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {

                p.x = i;
                p.y = j;

                switch (p.x) {
                    case 0: {
                        if (figure.equals(board.getFigureFromBoard(p))) {
                            countFigures += 1;
                            //System.out.printf("\ncase 0: Counting '%s' in row %d currently have %d", figure, p.x, countFigures);
                        }
                        if (countFigures < 3 && p.y == board.getBoardSize() - 1) {
                            countFigures = 0;
                        }

                        break;
                    }
                    case 1: {

                        if (figure.equals(board.getFigureFromBoard(p))) {
                            countFigures += 1;
                            //System.out.printf("\n case 1: Counting '%s' in row %d currently have %d", figure, p.x, countFigures);
                        }
                        if (countFigures < 3 && p.y == board.getBoardSize() - 1) {
                            countFigures = 0;
                        }
                        break;
                    }
                    case 2: {

                        if (figure.equals(board.getFigureFromBoard(p))) {
                            countFigures += 1;
                            //System.out.printf("\n case 2 :Counting '%s' in row %d currently have %d", figure, p.x, countFigures);
                        }
                        if (countFigures < 3 && p.y == board.getBoardSize() - 1) {
                            countFigures = 0;
                        }
                        break;
                    }
                }
            }
        }

        if ((countFigures == 3)) {
            System.out.println("\nHorizontal check result : ");
            System.out.printf("figure \"%s\" has winning combo!%n", figure);
            return true;

        } else {
            System.out.println("\nHorizontal check result : ");
            System.out.printf("figure \"%s\" has no winning combination!%n", figure);

        }
        return false;
    }

    public static boolean checkVertical(Board board, String figure) {
        MyPoint upperPoint = new MyPoint();
        MyPoint middlePoint = new MyPoint();
        MyPoint lowerPoint = new MyPoint();

        for (int j = 0; j < board.getBoardSize(); j++) {
            upperPoint.x = 0;
            middlePoint.x = 1;
            lowerPoint.x = 2;

            upperPoint.y = j;
            middlePoint.y = j;
            lowerPoint.y = j;

            if (board.getFigureFromBoard(upperPoint) != null &&
                    board.getFigureFromBoard(middlePoint) != null &&
                    board.getFigureFromBoard(lowerPoint) != null &&
                    board.getFigureFromBoard(upperPoint).equals(board.getFigureFromBoard(middlePoint)) &&
                    board.getFigureFromBoard(middlePoint).equals(board.getFigureFromBoard(lowerPoint))) {

                System.out.println("\nVertical check result : ");
                System.out.printf("figure \"%s\" has winning combo!%n", figure);
                return true;
            }
        }
        return false;
    }

    public static void checkIfWon(Board board, String figure) {
        if (!checkHorizontal(board, figure)) {
            System.out.println("Horizontal winner not detected !");

        }
        if (!checkVertical(board, figure)) {
            System.out.println("\n Vertical win not detected moving to diagonals ");
        }
    }


    public static void main(String[] args) {

        Board board = new Board();

        fillBoardVertical(board, 0, "O");
        printBoard(board);
        checkIfWon(board, "O");

        resetBoard(board);
        fillBoardVertical(board, 1, "X");
        printBoard(board);
        checkIfWon(board, "X");


        resetBoard(board);
        fillBoardDiagonal2(board, "O");
        printBoard(board);
        checkIfWon(board, "O");


        resetBoard(board);
        fillBoardDiagonal2(board, "O");
        printBoard(board);
        checkIfWon(board, "O");

        resetBoard(board);
        fillBoardHorizontally(board, 1, "O");
        printBoard(board);
        checkIfWon(board, "O");

        resetBoard(board);
        fillBoardHorizontally(board, 0, "X");
        printBoard(board);
        checkIfWon(board, "X");

        resetBoard(board);
        fillBoardHorizontally(board, 2, "O");
        printBoard(board);
        checkIfWon(board, "X");
        checkIfWon(board, "O");


    }

}
