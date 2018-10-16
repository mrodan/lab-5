import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("What would you like the height of the board to be? ");
        int boardHeightRow = scan.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int boardLengthColumn = scan.nextInt();
        char[][] sizeBoard = new char[boardHeightRow][boardLengthColumn];
        initializeBoard(sizeBoard);
        printBoard(sizeBoard);
        System.out.println("\nPlayer 1: x");
        System.out.println("Player 2: o");

        boolean openClose = true;
        int column;
        char chipTypeX = 'x';
        char chipTypeO = 'o';
        int tie = boardHeightRow*boardLengthColumn;

        while (openClose)
        {
            System.out.print("\nPlayer 1: Which column would you like to choose? ");
            column = scan.nextInt();
            insertChip(sizeBoard, column, chipTypeX);
            printBoard(sizeBoard);
            tie--;
            if (checkIfWinner(sizeBoard, boardLengthColumn, boardHeightRow, chipTypeX)) {
                System.out.println("\nPlayer 1 won the game!");
                openClose = false;
                break;
            }

            System.out.print("\nPlayer 2: Which column would you like to choose? ");
            column = scan.nextInt();
            insertChip(sizeBoard, column, chipTypeO);
            printBoard(sizeBoard);
            tie--;
            if (checkIfWinner(sizeBoard, boardLengthColumn, boardHeightRow, chipTypeO)) {
                System.out.println("\nPlayer 2 won the game!");
                openClose = false;
                break;
            }

            if (tie == 0) {
                System.out.println("Draw. Nobody wins.");
                openClose = false;
            }

//            for (int i = 0; i < boardHeightRow; i++) {
//                for (int k = 0; k < boardLengthColumn; k++) {
//                    int checker = 0;
//                    if (sizeBoard[i][k] != '-') {
//                        checker++;
//                    }
//                    if (checker == 0) {
//                        System.out.println("Draw. Nobody wins.");
//                        openClose = false;
//                        break;
//                    }
//                }
//            }

        }


    }

    public static void printBoard(char[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void initializeBoard(char[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                array[i][j] = '-';
            }
        }
    }

    public static int insertChip(char[][] array, int col, char chipType)
    {
        int output = -1;
        for (int i = array.length - 1; i >= 0; i--)
        {
            if (array[i][col] == '-')
            {
                array[i][col] = chipType;
                output = i;
                break;
            }
        }
        return output;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType)
    {
        for (int i = 0; i < row; i++) {
            int counter = 1;
            for(int j = 1; j < col; j++) {
                if (array[i][j] == array[i][j-1] && array[i][j] == chipType) {
                    counter++;
                }
                else {
                    counter = 1;
                }
                if (counter >= 4) {
                    return true;
                }
            }
        }

        for (int i = 0; i < col; i++) {
            int counter = 1;
            for(int j = 1; j < row; j++) {
                if (array[j][i] == array[j-1][i] && array[j][i] == chipType) {
                        counter++;
                }
                else {
                    counter = 1;
                }
                if (counter >= 4) {
                    return true;
                }
            }
        }
        return false;
    }













}
