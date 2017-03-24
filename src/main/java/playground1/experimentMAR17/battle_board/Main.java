package playground1.experimentMAR17.battle_board;

/**
 * Main game runner
 */

public class Main {
    // TODO read my code tomorrow , see if it is readable and understandable without comments

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

    public static void checkIfWon(Board board, String figure) {

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
                            System.out.printf("%n Counting '%s' in row %d currently have %d", figure, p.x, countFigures);
                        }
                        if (countFigures < 3 && p.y == board.getBoardSize() - 1) {
                            countFigures = 0;
                        }

                        break;
                    }
                    case 1: {

                        if (figure.equals(board.getFigureFromBoard(p))) {
                            countFigures += 1;
                            System.out.printf("%n Counting '%s' in row %d currently have %d", figure, p.x, countFigures);
                        }
                        if (countFigures < 3 && p.y == board.getBoardSize() - 1) {
                            countFigures = 0;
                        }
                        break;
                    }
                    case 2: {

                        if (figure.equals(board.getFigureFromBoard(p))) {
                            countFigures += 1;
                            System.out.printf("%n Counting '%s' in row %d currently have %d", figure, p.x, countFigures);
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
            System.out.printf("\nfigure \"%s\" has winning combo!%n", figure);


        } else {
            System.out.printf("\nfigure \"%s\" has no winning combination!%n", figure);

        }
    }


    public static void main(String[] args) {

        Board board = new Board();

//        fillOne(board);
//        printBoard(board);
//        fillBoardVertical(board, 2, "O");
//        printBoard(board);
//        checkIfWon(board, "O");

//        resetBoard(board);
//        fillBoardDiagonal2(board, "O");
//        printBoard(board);
//        checkIfWon(board, "O");

        resetBoard(board);
        fillBoardHorizontally(board, 1, "O");
        printBoard(board);
        checkIfWon(board, "O");

//        resetBoard(board);
//        fillBoardHorizontally(board, 0, "X");
//        printBoard(board);
//        checkIfWon(board, "X");
//
//        resetBoard(board);
//        fillBoardHorizontally(board, 2, "O");
//        printBoard(board);
//        checkIfWon(board, "X");
//        checkIfWon(board, "O");


    }

}
