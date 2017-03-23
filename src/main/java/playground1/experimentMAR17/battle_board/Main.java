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
                    System.out.print("\t[ ]\t");
                } else {
                    System.out.print(String.format("\t[%s]\t", board.getFigureFromBoard(p)));
                    cellCounter++;
                }
            }
        }
        //System.out.println("\nTotal cells : " + cellCounter);
    }

    public static void fillBoardVertical(Board board) {
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

    public static void fillBoardHorizontally(Board board) {
        /** just a filler , ignore logic with reminders
         *  fills board with valid "winning" combination
         */

        MyPoint p = new MyPoint();
        for (int i = 0; i < board.getBoardSize(); i++) {
            p.y = i % 3;
            p.x = (i - i % 3) / 3;
            board.putFigureOnBoard(p, "O");
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
        // FIXME: 3/20/2017 this method is incorrect , I am just counting If I have three figures , without any logic 
        // FIXME: 3/20/2017 rewrite the whole method as intended ! 

        // TODO need multiple checks here .
        // TODO What does a win mean ?
        // TODO What does a draw mean ?
        // TODO is this really important ? In this code ?

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
                        }
                        break;
                    }
                    case 1: {
                        if (figure.equals(board.getFigureFromBoard(p))) {
                            countFigures += 1;
                        }
                        break;
                    }
                    case 2: {
                        if (figure.equals(board.getFigureFromBoard(p))) {
                            countFigures += 1;
                        }
                        break;
                    }

                }

//                if (figure.equals(board.getFigureFromBoard(p))) {
//                    System.out.println("\nMatch found ");
//                    countFigures += 1;
//                }
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

        fillBoardVertical(board);
        printBoard(board);
        checkIfWon(board, "X");

        resetBoard(board);
        fillBoardHorizontally(board);
        printBoard(board);
        checkIfWon(board, "O");
//
//        resetBoard(board);
//        fillBoardDiagonal2(board, "O");
//        printBoard(board);
//        checkIfWon(board, "O");


    }


}
