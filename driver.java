//Copyright 2018
//Jackon Matthews
import java.util.Random;
import java.util.Scanner;
public class driver 
{
	public static void main(String[] args) 
	{
		Scanner kb=new Scanner(System.in);
		Random rn=new Random();
		boolean quitGame=false;
		while(!quitGame)
		{
			System.out.println("Let's Play Tic-Tac-Toe!");
			int boardLength=3;
			int boardHeight=3;
			char[][] board=new char[boardLength][boardHeight];
			char defaultSpace='-';
			//brint blank board
			for(int x=0;x<boardLength;x++)
			{
				for(int y=0;y<boardHeight;y++)
				{
					board[x][y]=defaultSpace;
					System.out.print(board[x][y]);
				}
				System.out.println();
			}
			String playAgainMsg="Do you want to play again?(y/n)";
			char playAgainRespone=' ';
			boolean gameOver=false;
			while(!gameOver)
			{
				//user move
				//user must make valid move before spot is given
				boolean userMoveValid=false;
				char userSpace='X';
				int userRow=0;
				int userColumn=0;
				while(!userMoveValid)
				{
					System.out.println("Make your Move!");
					System.out.println("Enter row:");
					//subtract one because the spot in array will be one less than actual row
					userRow=kb.nextInt()-1;
					System.out.println("Enter column:");
					//subtract one because the spot in array will be one less than actual column
					userColumn=kb.nextInt()-1;
					if(board[userRow][userColumn]=='-')
						userMoveValid=true;
					if(userMoveValid==false)
					{
						System.out.println("Move is invaid!");
						for(int x=0;x<boardLength;x++)
						{
							for(int y=0;y<boardHeight;y++)
							{
								System.out.print(board[x][y]);
							}
							System.out.println();
						}
					}
				}
				board[userRow][userColumn]=userSpace;
				
				//user win conditions
				//if user wins, cpu does not need to make move
				if( (board[0][0]==userSpace && board[0][1]==userSpace && board[0][2]==userSpace) ||
					(board[1][0]==userSpace && board[1][1]==userSpace && board[1][2]==userSpace) ||
					(board[2][0]==userSpace && board[2][1]==userSpace && board[2][2]==userSpace) ||
					(board[0][0]==userSpace && board[1][0]==userSpace && board[2][0]==userSpace) ||
					(board[0][1]==userSpace && board[1][1]==userSpace && board[2][1]==userSpace) ||
					(board[0][2]==userSpace && board[1][2]==userSpace && board[2][2]==userSpace) ||
					(board[0][0]==userSpace && board[1][1]==userSpace && board[2][2]==userSpace) ||
					(board[2][0]==userSpace && board[1][1]==userSpace && board[0][2]==userSpace) )
				{
					String winMsg="You WON!";
					System.out.println(winMsg);
					for(int x=0;x<boardLength;x++)
					{
						for(int y=0;y<boardHeight;y++)
						{
							System.out.print(board[x][y]);
						}
						System.out.println();
					}
					System.out.println(playAgainMsg);
					playAgainRespone=kb.next().charAt(0);
					if(playAgainRespone=='n')
						quitGame=true;
					gameOver=true;
				}

				//check for valid move
				boolean validMoveLeft=false;
				for(int x=0;x<boardLength;x++)
				{
					for(int y=0;y<boardHeight;y++)
					{
						if(board[x][y]=='-')
							validMoveLeft=true;
					}
				}
				
				//cpu move
				//cpu must make valid move
				boolean cpuMoveValid=false;
				char cpuSpace='O';
				int cpuRow=0;
				int cpuColumn=0;
				while(!cpuMoveValid && !gameOver && validMoveLeft)
				{
					cpuRow=rn.nextInt(3);
					cpuColumn=rn.nextInt(3);
					if(board[cpuRow][cpuColumn]=='-')
						cpuMoveValid=true;
				}
				board[cpuRow][cpuColumn]=cpuSpace;
				
				//cpu win conditions
				if( (board[0][0]==cpuSpace && board[0][1]==cpuSpace && board[0][2]==cpuSpace) ||
					(board[1][0]==cpuSpace && board[1][1]==cpuSpace && board[1][2]==cpuSpace) ||
					(board[2][0]==cpuSpace && board[2][1]==cpuSpace && board[2][2]==cpuSpace) ||
					(board[0][0]==cpuSpace && board[1][0]==cpuSpace && board[2][0]==cpuSpace) ||
					(board[0][1]==cpuSpace && board[1][1]==cpuSpace && board[2][1]==cpuSpace) ||
					(board[0][2]==cpuSpace && board[1][2]==cpuSpace && board[2][2]==cpuSpace) ||
					(board[0][0]==cpuSpace && board[1][1]==cpuSpace && board[2][2]==cpuSpace) ||
					(board[2][0]==cpuSpace && board[1][1]==cpuSpace && board[0][2]==cpuSpace) )
				{
					String loseMsg="You lost.";
					System.out.println(loseMsg);
					for(int x=0;x<boardLength;x++)
					{
						for(int y=0;y<boardHeight;y++)
						{
							System.out.print(board[x][y]);
						}
						System.out.println();
					}
					System.out.println(playAgainMsg);
					playAgainRespone=kb.next().charAt(0);
					if(playAgainRespone=='n')
						quitGame=true;
					gameOver=true;
				}
				
				//tie conditions
				//if no moves are left and the there is no winner
				if(!validMoveLeft && !gameOver)
				{
					String tieMsg="Cat's game";
					System.out.println(tieMsg);
					for(int x=0;x<boardLength;x++)
					{
						for(int y=0;y<boardHeight;y++)
						{
							System.out.print(board[x][y]);
						}
						System.out.println();
					}
					System.out.println(playAgainMsg);
					playAgainRespone=kb.next().charAt(0);
					if(playAgainRespone=='n')
						quitGame=true;
					gameOver=true;
				}
				//print board after both user and cpu have made moves
				for(int x=0;x<boardLength;x++)
				{
					for(int y=0;y<boardHeight;y++)
					{
						System.out.print(board[x][y]);
					}
					System.out.println();
				}
		
			}
		}
		kb.close();
	}

}
