/**
 * A game of connect 4
 *
 * Written by Nathan Ross
 * Last modified 4-18-18
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static int EMPTY = 0;
    private final static int PLAYER1 = 1;
    private final static int PLAYER2 = 2;

    private final static int ROW_COUNT = 6;
    private final static int COL_COUNT = 7;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        char[] symbols = new char[3];
        symbols[EMPTY] = ' ';

        System.out.print("Play as # or O?: ");
        String line = keyboard.nextLine().toLowerCase();
        if (line.length() > 0 && (line.charAt(0) == 'o' || line.charAt(0) == '0')) {
            symbols[PLAYER1] = 'O';
            symbols[PLAYER2] = '#';
        }
        if (line.length() > 0 && line.charAt(0) == '#') {
            symbols[PLAYER1] = '#';
            symbols[PLAYER2] = 'O';
        } else {
            System.out.println("Assuming #");
            symbols[PLAYER1] = '#';
            symbols[PLAYER2] = 'O';
        }


        char[][] board = new char[ROW_COUNT][COL_COUNT];
        clearBoard(board);

        Random random = new Random();

        while (true) {
            printBoard(board);

            //player's turn
            while (true) {
                System.out.print("Place piece in column: ");
                int col = inputColumn(keyboard) - 1;

                if (wouldResultInWin(board, col, symbols[PLAYER1])) {
                    placePiece(board, PLAYER1, col, symbols);
                    printBoard(board);

                    System.out.println("You win");
                    return;
                }

                if (placePiece(board, PLAYER1, col, symbols))
                    break;
                System.out.println("That row is full.");
            }

            //computer's turn
            computerTurn:
            while (true) {
                //the computer attempts to win in one turn
                for (int col = 0; col < COL_COUNT; ++col) {
                    if (wouldResultInWin(board, col, symbols[PLAYER2])) {
                        placePiece(board, PLAYER2, col, symbols);
                        printBoard(board);

                        System.out.println("Player 2 wins");
                        return;
                    }
                }

                //the computer attempts to prevent you from winning
                for (int col = 0; col < COL_COUNT; ++col) {
                    if (wouldResultInWin(board, col, symbols[PLAYER1])) {
                        placePiece(board, PLAYER2, col, symbols);
                        break computerTurn;
                    }
                }

                //otherwise the computer chooses a random play
                int col = random.nextInt(7);
                if (placePiece(board, PLAYER2, col, symbols))
                    break;
            }

            if (isBoardFull(board)) {
                printBoard(board);

                System.out.println("Tie game.");
                return;
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("-1234567-");

        for (int row = 0; row < ROW_COUNT; ++row) {
            System.out.print('|');

            for (int col = 0; col < COL_COUNT; ++col) {
                char cell = board[row][col];
                System.out.print(cell);
            }

            System.out.println('|');
        }

        System.out.println("-1234567-");
    }

    /**
     * input a single digit from the user.
     * @param keyboard Scanner instance to read from
     * @return a number between 1 and 7
     */
    private static int inputColumn(Scanner keyboard) {
        while (true) {
            String line = keyboard.nextLine();
            char first = (line.length() == 0) ? ' ' : line.charAt(0);
            if (first >= '1' && first <= '7') {
                return first - '0';
            }

            System.out.print("Enter a number between 1 and 7: ");
        }
    }

    private static boolean placePiece(char[][] board, int player, int col, char[] symbols) {
        for (int row = ROW_COUNT - 1; row >= 0; --row) {
            if (board[row][col] == ' ') {
                board[row][col] = symbols[player];
                return true;
            }
        }

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        int fullColCount = 0;

        for (int col = 0; col < COL_COUNT; ++col) {
            if (board[0][col] != ' ')
                ++fullColCount;
        }

        return fullColCount == COL_COUNT;
    }

    private static void clearBoard(char[][] board) {
        for (int row = 0; row < ROW_COUNT; ++row) {
            for (int col = 0; col < COL_COUNT; ++col) {
                board[row][col] = ' ';
            }
        }
    }

    /**
     * checks whether a potential move would result in a win
     * @param board board data
     * @param col column of most recent play
     * @return whether the move would result in a win
     */
    private static boolean wouldResultInWin(char[][] board, int col, char piece) {
        //determine if the move is legal
        if (board[0][col] != ' ')
            return false;

        //determine the row of the potential play
        int row = ROW_COUNT - 1;
        for (; row >= 0; --row) {
            if (board[row][col] == ' ') {
                break;
            }
        }

        //Alisson, start copying from this point onward

        //test for vertical (downward) matches
        int matches = 1;
        for (int r = row + 1; r < ROW_COUNT; ++r) {
            if (board[r][col] != piece)
                break;
            ++matches;
        }
        if (matches >= 4)
            return true;

        //test for horizontal matches
        matches = 1;

        //scan left
        for (int c = col - 1; c >= 0; --c) {
            if (board[row][c] != piece)
                break;
            ++matches;
        }

        //scan right
        for (int c = col + 1; c < COL_COUNT; ++c) {
            if (board[row][c] != piece)
                break;
            ++matches;
        }

        if (matches >= 4)
            return true;

        //test for '/' diagonal matches
        matches = 1;

        //scan left
        for (int c = col - 1; c >= 0; --c) {
            int r = row + (col - c);

            if (r >= ROW_COUNT || board[r][c] != piece)
                break;
            ++matches;
        }

        //scan right
        for (int c = col + 1; c < COL_COUNT; ++c) {
            int r = row + (col - c);

            if (r < 0 || board[r][c] != piece)
                break;
            ++matches;
        }

        if (matches >= 4)
            return true;


        //test for '\' diagonal matches
        matches = 1;

        //scan left
        for (int c = col - 1; c >= 0; --c) {
            int r = row - (col - c);

            if (r < 0 || board[r][c] != piece)
                break;
            ++matches;
        }

        //scan right
        for (int c = col + 1; c < COL_COUNT; ++c) {
            int r = row - (col - c);

            if (r >= ROW_COUNT || board[r][c] != piece)
                break;
            ++matches;
        }

        return (matches >= 4);
    }
}
