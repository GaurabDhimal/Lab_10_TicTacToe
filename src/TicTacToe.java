import java.util.Scanner;

public class TicTacToe
{
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String currentPlayer = "X";
    private static int moveCount = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        SafeInput.prettyHeader("Tic-Tac-Toe");

        do
        {
            clearBoard();
            moveCount = 0;
            System.out.println("Game Start!");

            boolean running = true;
            while (running)
            {
                display();
                System.out.println("Player " + currentPlayer + "'s turn.");

                int row = SafeInput.getRangedInt(scanner, "Enter row (1-3)", 1, 3) - 1;
                int col = SafeInput.getRangedInt(scanner, "Enter column (1-3)", 1, 3) - 1;

                if(!isValidMove(row, col))
                {
                    System.out.println("Invalid move! Space already occupied. Try again.");
                    continue;
                }

                board[row][col] = currentPlayer;
                moveCount++;

                if(isWin(currentPlayer))
                {
                    display();
                    System.out.println("Player " + currentPlayer + " wins!");
                    running = false;
                }
                else if(isTie())
                {
                    display();
                    System.out.println("It's a tie!");
                    running = false;
                }
                else
                    togglePlayer();
            }

            playAgain = SafeInput.getYNConfirm(scanner, "Do you want to play again? (Y/N)");
        }while(playAgain);

        SafeInput.prettyHeader("Thanks for playing!");
        scanner.close();
    }

    private static void clearBoard()
    {
        for(int a = 0 ; a < ROWS ; a++)
        {
            for(int b = 0 ; b < COLS ; b++)
                board[a][b] = " ";
        }
        currentPlayer = "X";
    }

    private static void display()
    {
        System.out.println("  1 2 3");
        for(int a = 0 ; a < ROWS ; a++)
        {
            System.out.print((a + 1) + " ");
            for(int b = 0 ; b < COLS ; b++)
            {
                System.out.print(board[a][b]);
                if(b < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if(a < ROWS - 1) System.out.println("  -----");
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col].equals(" ");
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player)
    {
        for(int a = 0 ; a < ROWS ; a++)
        {
            if(board[a][0].equals(player) && board[a][1].equals(player) && board[a][2].equals(player))
                return true;
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for(int a = 0 ; a < COLS ; a++)
        {
            if(board[0][a].equals(player) && board[1][a].equals(player) && board[2][a].equals(player))
                return true;
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie()
    {
        // All spaces filled?
        if(moveCount == ROWS * COLS)
            return true;

        // Win conditions blocked?
        for(int a = 0 ; a < ROWS ; a++)
        {
            if(board[a][0].equals(" ") || board[a][1].equals(" ") || board[a][2].equals(" "))
                return false;
        }
        for(int a = 0 ; a < COLS ; a++)
        {
            if(board[0][a].equals(" ") || board[1][a].equals(" ") || board[2][a].equals(" "))
                return false;
        }
        if(board[0][0].equals(" ") || board[2][2].equals(" ") || board[0][2].equals(" ") || board[2][0].equals(" "))
            return false;

        return true;
    }

    private static void togglePlayer()
    {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }
}
