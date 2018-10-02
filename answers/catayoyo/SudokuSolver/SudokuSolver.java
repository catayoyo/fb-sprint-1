public class Main {
    
    //Making the grid that needs to be solved. Grid is stored in a 2d array.
    public static int[][] GRID_TO_SOLVE = {
        {9,0,0,1,0,0,0,0,5},
        {0,0,5,0,9,0,2,0,1},
        {8,0,0,0,4,0,0,0,0},
        {0,0,0,0,8,0,0,0,0},
        {0,0,0,7,0,0,0,0,0},
        {0,0,0,0,2,6,0,0,9},
        {2,0,0,3,0,0,0,0,6},
        {0,0,0,2,0,0,9,0,0},
        {0,0,1,9,0,4,5,7,0}
    };
      
    public static void main(String[]args) {
        Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
        System.out.println("Sudoku grid to solve");
        sudoku.display();
        
        //Try resolution
        if (sudoku.solve()){
            System.out.println("Sudoku Grid solved with simple BT");
            sudoku.display();
        }
        else
        System.out.println("Unsolvable");
    }
}


public class Sudoku {
    // Defining the empty cells and size of the grid
    private int[][] board;
    private static final int EMPTY = 0;
    private static final int SIZE = 9;
    public Sudoku(int[] board) {this.board = new int [SIZE][SIZE];}
    private boolean isInRow(int row, int number) {
        for(int i = 0; i < SIZE; i++)
            if (board[row][i] == number)
                return true;
        
    return false;
}

//check if a possible number is already in a column
private boolean isInCol(int col, int number) {
    for (int i = 0; i < SIZE; i++)
        if(board[i][col] == number)
            return true;
            
            
    return false;
}

//combined method to check if a number possible to a row,col position is ok
private boolean isOk (int row, int col, int number) {
    return !isInRow(row,number) && !isInCol(col,number) && !isInBox(row,col,number);
}

public boolean solve() {
    for (int row = 0; row < SIZE; row++) {
        for (int col = 0; col < SIZE; col++) {
            //search an empty cell
            if (board[row][col] == EMPTY) {
                //try possible numbers
                for (int number = 1; number <= SIZE; number++) {
                    if (isOk(row,col,number)) {
                        //see if number is ok. it respects sudoku constraints
                        board[row][col] = number;
                        
                        if (solve()) { //start backtracking recursively
                            return true;
                        } else { //if not a solution we empty the cell and continue
                            board[row][col] = EMPTY;
                        }
                    }
                }
                return false;
            }
        }
    }
    return true; //Sudoku solved
}

public void display() {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            System.out.print(" " + board[i][j]);
        }
        System.out.println();
    }
    System.out.println();
  }
}








