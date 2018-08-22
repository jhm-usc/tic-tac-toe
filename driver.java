import java.util.Random;
import java.util.Scanner;
Class Driver
{
  public static void main(String[] args)
  {
    int boardWidth = 3;
    int boardHeigt = 3;
    char[][] board = new char[boardWidth][boardHeight];
    char defaultSpace = '-';
    for(int x=0;x<boardWidth.length;x++)
    {
      for(int y=0;y<boardHeight.length;y++)
      {
        board[boardWidth][boardHeight]=defaultSpace;
        System.out.print(board[boardWidth][boardHeight]);
      }
      System.out.println;
  }
}
