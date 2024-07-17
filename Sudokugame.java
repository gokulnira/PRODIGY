public class Sudokugame {
private static final int SIZE = 9; // Siz
public static void main(String[] args) {
int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
};
if (solveSudoku(board))
{
printBoard(board);
} else
{
System.out.println("No solution exists.");
}
}
private static boolean solveSudoku(int[][] board)
{
for (int row = 0; row < SIZE; row++) 
{
for (int col = 0; col < SIZE; col++) 
{
if (board[row][col] == 0) { 
for (int num = 1; num <= SIZE; num++) 
{
if (isSafe(board, row, col, num)) 
{
board[row][col] = num; 
if (solveSudoku(board)) 
{
return true;
}
board[row][col] = 0;
}
}
return false; 
}
}
}
return true; 
}
private static boolean isSafe(int[][] board, int row, int col, int num) 
{
for (int x = 0; x < SIZE; x++) 
{
if (board[row][x] == num) 
{
return false;
}
}
for (int x = 0; x < SIZE; x++)
{
if (board[x][col] == num) 
{
return false;
}
}
int startRow = row - row % 3, startCol = col - col % 3;
for (int i = 0; i < 3; i++) 
{
for (int j = 0; j < 3; j++) 
{
if (board[i + startRow][j + startCol] == num) 
{
return false;
}
}
}
return true; 
}
private static void printBoard(int[][] board) 
{
for (int r = 0; r < SIZE; r++) 
{
for (int d = 0; d < SIZE; d++) 
{
System.out.print(board[r][d]);
System.out.print(" ");
}
System.out.print("\n");
if ((r + 1) % 3 == 0 && r != SIZE - 1) 
{
System.out.print("");
}
}
}
}