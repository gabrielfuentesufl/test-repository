import java.util.Scanner;
public class ConnectFour {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("What would you like the height of the board to be? ");
        int height = scnr.nextInt();

        System.out.print("What would you like the length of the board to be? ");
        int length = scnr.nextInt();

        char[][] board = new char[height][length]; //create board

        initializeBoard(board);

        //board[2][2] = '1'; //board location test
        printBoard(board);

        System.out.println("\nPlayer 1: x\nPlayer 2: o");

//begin loop
        while (true) {
            System.out.println("\nPlayer 1: Which column would you like to choose? ");
            int column = scnr.nextInt();
            int row = insertChip(board, column, 'x');
            board[row][column] = 'x';
            printBoard(board);
            if (checkIfWinner(board, column, row, 'x') == true) {
                System.out.println("Player 1 won the game!");
                break;
            }

            boolean spacesLeft = false;
            for (int r = 0; r < board.length; r++) {

                for (int c = 0; c < board[r].length; c++) {
                    if (board[r][c] == '-') {
                        spacesLeft = true;
                    }

                }
            }
            if (spacesLeft == false){
                System.out.println("Draw. Nobody wins.");
                break;
            }


            System.out.println("\nPlayer 2: Which column would you like to choose? ");
            column = scnr.nextInt();
            row = insertChip(board, column, 'o');
            board[row][column] = 'o';
            printBoard(board);
            if (checkIfWinner(board, column, row, 'o') == true) {
                System.out.println("Player 2 won the game!");
                break;
            }

            spacesLeft = false;
            for (int r = 0; r < board.length; r++) {

                for (int c = 0; c < board[r].length; c++) {
                    if (board[r][c] == '-') {
                        spacesLeft = true;
                    }

                }
            }
            if (spacesLeft == false){
                System.out.println("Draw. Nobody wins.");
                break;
            }



        }

    }

//end loop/game


    //initialize board method
    public static void initializeBoard(char[][] array) { //the parameter will always be "char[][] board"
        for (int r = 0; r < array.length; r++) { //board set all spaces to '-'.

            for (int c = 0; c < array[r].length; c++) {
                array[r][c] = '-';
            }
        }
    }
    //print board method
    public static void printBoard(char[][] array) {
        for (int r = array.length - 1; r >= 0; r--) { //board print, may not be accurate.
            for (int c = 0; c < array[r].length; c++) {
                System.out.print(array[r][c]);
            }
            System.out.print("\n");
        }

    }
    //insert Chip method
    public static int insertChip(char[][] array, int col, char chipType) { //char array will be board, column is col, chiptype determined by which player im asking
        //we don't really need chip type
        int r = 0;
        for (r = r; r <= array.length - 1; r++) {
            if (array[r][col] == '-') {  //checking where the next piece will go, if the column is filled, there will be an error
                break;
            }
        }
        return r; //r will be used to determine where board['r'][col] equals x or o
    }
    //checkIfWinner Method
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) { //array parameter is always equal to char[][]board
        //check this after player 1 and player insert their chip in. if this method equal true, makes player win, else checks if board is full; in each (if) case break, else loop will continue
        boolean fourInALine = false;
        int amountInARow = 1;
        int amountInACol = 1;
        for (int space = 0; space < array[row].length; space++) { //checkin all the columns in the given row
            if (space != array[row].length - 1) {
                if (array[row][space] == array[row][space + 1] && array[row][space] == chipType) { //checks Chiptype and conequence at the same time
                    amountInARow = amountInARow + 1;
                    if (amountInARow == 4)
                        fourInALine = true;
                }
                else {
                    amountInARow = 1; //reset count
                }

            }
        }
        for (int space = 0; space < array.length; space++) {//checking all the rows in a given column
            if (space != array.length - 1) {
                if (array[space][col] == array[space + 1][col] && array[space][col] == chipType) {//check Chiptype and consequence at the same time
                    amountInACol = amountInACol + 1;
                    if(amountInACol == 4)
                        fourInALine = true; //if there are four in a row of the specified chipType, it equals true
                }
                else {
                    amountInACol = 1; //reset count
                }

            }
        }


        return fourInALine;
    }


//end code
}


