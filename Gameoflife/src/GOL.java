import java.util.Scanner;

public class GOL {

	public static void main(String[] args) {
		int rows, cols ;
		int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		};
		System.out.println("Do you want to use default initial generation?");
		System.out.println("Type 1 for YES and 0 for No");
		Scanner sc=new Scanner(System.in);
		int result=sc.nextInt();
		if(result==0)
		{
			System.out.println("Enter value of number of rows:");
			rows = sc.nextInt();
			System.out.println("Enter value of number of cols:");
			cols = sc.nextInt();
			grid = null;
			grid = new int[rows][cols];
			for (int i = 0; i < rows; i++)
			{
				for (int j = 0; j < cols; j++)
				{
					grid[i][j]=sc.nextInt();
				}
			}
		}
		else
		{
			rows = 10;
			cols = 10;

		}
		System.out.println("Initial Generation");
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (grid[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		nextGeneration(grid, rows, cols);
	}

	// Function to print next generation
	static void nextGeneration(int grid[][], int rows, int cols)
	{
		int[][] nextGrid = new int[rows][cols];

		for (int l = 0; l < rows; l++)
		{
			for (int m = 0; m < cols; m++)
			{
				int liveCells = 0;
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <= 1; j++)
						if ((l+i>=0 && l+i<rows) && (m+j>=0 && m+j<cols))
							liveCells += grid[l + i][m + j];

				if (grid[l][m] == 1)
					liveCells = liveCells - 1;


				if ((grid[l][m] == 1) && (liveCells < 2))
					nextGrid[l][m] = 0;

				else if ((grid[l][m] == 1) && (liveCells > 3))
					nextGrid[l][m] = 0;

				else if ((grid[l][m] == 0) && (liveCells == 3))
					nextGrid[l][m] = 1;
				else
					nextGrid[l][m] = grid[l][m];
			}
		}

		System.out.println("Next Generation");
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (nextGrid[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Do you want to see next generation?");
		System.out.println("Type 1 for YES and 0 for No");
		Scanner sc=new Scanner(System.in);
		int result=sc.nextInt();
		if(result==1)
		{
			nextGeneration(nextGrid, rows, cols);
		}
	}

}

