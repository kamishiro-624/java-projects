import java.util.*;

public class javaTicTacToe
{
    public static int winCheck(String[] board, int turPas) {
        int[][] winCndts = {
            {1,2,3}, // Top Horiz
            {4,5,6}, // Mid Horiz
            {7,8,9}, // Bottom Horiz
            {1,4,7}, // Left Vert
            {2,5,8}, // Mid Vert
            {3,6,9}, // Right Vert
            {1,5,9}, // Diag1
            {3,5,7}  // Diag2
        };
        
        
        for (int i = 0; i < 8; i++) {
            
            if (board[winCndts[i][0]-1].equals(board[winCndts[i][1]-1]) && board[winCndts[i][1]-1].equals(board[winCndts[i][2]-1]) && !board[winCndts[i][2]-1].equals(" ")) {
                return 1; // Win Detected
            }
        }
        
        if (turPas == 9) {
            return -1; // Draw
        }
        return 0; // Continue
    }
    
    
    public static void prtBoard(String[] board) {
        for (int i = 0; i < 9; i++) {
        System.out.print(" " + board[i] + " ");
        if ((i + 1) % 3 == 0) { 
            System.out.println();
            if (i < 6) System.out.println("-----------");
        } else {
            System.out.print("|");
        }
    }
    }
    
    
    public static void clrConsole() {
        System.out.print("\033[2J\033[H");
        System.out.flush();
    }
    
    public static int promptInt(Scanner input, String prompt, int min, int max) {
        
        System.out.println(prompt);
        System.out.print("> ");
        
        boolean gaveValid = false;
        int returnValue = 0;
        
        if (max <= min) {
            throw new IllegalArgumentException("Maximum parameter (" + max + ") can not be equal to or less than minimum (" + min + ").");
        }
        
        while (!gaveValid) {
            if (input.hasNextInt()) {
                returnValue = input.nextInt();
                input.nextLine();
                if (returnValue < min) {
                    System.out.println("[ERROR] The inputted value is less than the minimum. (" + returnValue + "<" + min + ")");
                    System.out.print("> ");
                } else if (returnValue > max) {
                    System.out.println("[ERROR] The inputted value is greater than the maximum. (" + returnValue + ">" + max + ")");
                    System.out.print("> ");
                } else {
                    gaveValid = true;
                }
            } else {
                System.out.println("[ERROR] The inputted value is not an integer.");
                input.nextLine();
                System.out.print("> ");
                gaveValid = false;
            }
        }
        return returnValue;
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] board = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        
        int turn = 2; // Supposed to be 1, but the way i coded it, it'll flip at the start.
        int turnsPassed = 0;
        
        boolean gameEnded = false;
    
        while (!gameEnded) {
            turnsPassed++;
            
            clrConsole();
            
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
            
            prtBoard(board);
            
            System.out.println("Player " + turn + "'s turn.");
            
            boolean validMove = false;
            while (!validMove) {
                int move = promptInt(input,"",1,9);
                if (!board[move-1].equals(" ")) {
                    validMove = false;
                    System.out.println("[ERROR} This spot is already taken.");
                } else {
                    validMove = true;
                    
                    if (turn == 1) {
                        board[move-1] = "X";
                    } else {
                        board[move-1] = "O";
                    }
                    
                }
            }
            
            if (winCheck(board, turnsPassed) == 1) {
                clrConsole();
                prtBoard(board);
                gameEnded = true;
                System.out.println("Player " + turn + " has won the game.");
            } else if (winCheck(board, turnsPassed) == -1) {
                clrConsole();
                prtBoard(board);
                gameEnded = true;
                System.out.println("The game has ended in a draw.");
            }
            
        }
        
    }
}
