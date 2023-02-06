package calci;

import design.*;
import java.util.*;

public class Matrix {

	final Scanner scan = new Scanner(System.in);

	/*Augmented Matrix, Solution Matrix*/
	double A[][];
	int rows, cols, rank;

	/*1. Unique, 2. Many, 3. No Solution*/
	double U[], V[][];	String W[];



	public void getMatirx() {

		List<String> stdin = 
				Design.printBox(
						"ENTER NUMBER OF UNKNOWNS: $",
						"ENTER NUMBER OF LINEAR EQUATIONS: $"
					);

		cols = Integer.parseInt(stdin.get(0).trim()) + 1;
		rows = Integer.parseInt(stdin.get(1).trim());

		String[] lines = new String[rows+2];
		lines[0] = "ENTER VALUES OF "+cols+" COEFFs OF "+rows+" LINEAR EQUATIONS";
		lines[1] = "";
		for (int i = 1; i <= rows; i++)
			lines[i+1] = "Line "+i+": $";

		stdin = Design.printBox(lines);

		A = new double[rows][cols];

		for (int i = 0; i < rows; i++) {
			String[] lineI = stdin.get(i).split(" ");
			for (int j = 0; j < cols; j++)
				A[i][j] = Double.parseDouble(lineI[j]);
		}

	}


	public void printMatirx(Object M[]) {
		for (int i = 0; i < M.length; i++)
			System.out.print(M[i] + " ");
		System.out.println();

	}public void printMatirx(double M[][]) {
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++)
				System.out.format("%8.2f", M[i][j]);
			System.out.println();
		}System.out.println();
	}


	public void solveSLE() {
		this.getMatirx();
		this.findEchelon();
		this.findConsistency();
		this.findSolution();
		this.displaySolution();
	}


	private void displaySolution() {

		String[] ans = new String[cols-1];

		if (0 < rank && rank < cols-1) {

			for (int i = 0; i < cols-1; i++) {
				String row = "";
				for (int k = 0; k < cols-rank-1; k++) {
					if (V[i][k] == 0.0)		continue;
					row += String.format("(%.2f)%s + ", V[i][k], "k"+(k+1));

				}if (V[i][cols-rank-1] != 0.0)
					row += String.format("%.2f", V[i][cols-rank-1]);

				ans[i] = String.format("%s  =  %s", "x"+(i+1), row);
			}

		}else if (rank == cols-1) {
			for (int i = 1; i < cols; i++)
				ans[i-1] = String.format("x%d = %8.2f", i, U[i-1]);

		}else {
			for (int i = 1; i < cols; i++)
				ans[i-1] = String.format("x%d = %s", i, W[i-1]);
		}

		Design.printBox(ans);

	}


	/* Ri ⟷ Rj */
	private void rearrangeRows(int idx) {

		LinkedList<Integer> zeroIdx = new LinkedList<Integer>();

		for (int i = idx; i < rows; i++)
			if (A[i][idx] == 0.0)
				zeroIdx.add(i);

		int k = rows-1;
		for (int row : zeroIdx) {
			double tmp[] = A[row];
			A[row] = A[k];
			A[k] = tmp;
			k--;
		}
	}

	/* Gauss Elimination: Echelon Form */
	private void findEchelon() {
		for (int i = 0; i < rows-1; i++) {

			rearrangeRows(i);

			for (int k = i+1; k < rows; k++) {
				double factor;
				try {
					if (A[k][i] == 0.0 || A[i][i] == 0.0)
						throw new Exception();
					factor = A[k][i]/A[i][i];

				}catch (Exception e) {
					continue;
				}
	
				/* Row Transformation	R₂ → R₂ - F * R₁ */
				for (int j = i; j < cols; j++)
					A[k][j] -= A[i][j] * factor;
			}
		}
	}	


	/* Checks if the given Row is a ZeroRow or not */
	private boolean checkZeroRow(int row, int k) {
		for (int j = 0; j < cols-k; j++)
			if (A[row][j] != 0.0)
				return false;
		return true;
	}

	/* Consistency of System of Linear Equations */
	private void findConsistency() {
		/* Rank of Coefficient Matirx*/
		int rankC = rows;
		for (int i = rows-1; i >= 0; i--) {
			if (checkZeroRow(i, 1))
				rankC--;
		}

		/* Rank of Augumented Matirx*/
		int rankA = rows;
		for (int i = rows-1; i >= 0; i--) {
			if (checkZeroRow(i, 0))
				rankA--;
		}

		rank = (rankC == rankA) ? rankA : -1;

	}


	/* Compute the Solution based on Rank*/
	private void findSolution() {

		if (rank > 0) {

			/*Unique Solution*/
			if (rank == cols -1) {

				U = new double[cols-1];
				for (int i = rank-1; i >= 0; i--) {
					double b = 0.0;
					/* aX + b = c;  to find b*/
					for (int j = cols-2; j > i; j--) {
						b += A[i][j] * U[j];
					}
					U[i] = (A[i][cols-1] - b) / (A[i][i]);
				}

			/*Infinite Solutions*/
			}else {

				V = new double[cols-1][cols-rank];

				for (int i = rank, k = 0; i < cols-1; i++, k++)
					V[i][k] = 1;

				for (int i = rank-1; i >= 0; i--) {

					double b[] = new double[cols-rank];
					/* aX + b[] = c;  to find b[]*/
					for (int j = cols-2; j > i; j--)
						for (int k = 0; k < cols-rank; k++)
							b[k] -= A[i][j] * V[j][k];

					b[cols-rank-1] += A[i][cols-1];

					for (int k = 0; k < cols-rank; k++)
						V[i][k] = b[k] / A[i][i];

				}

			}

		}else {

			/*No Solution*/
			W = new String[cols-1];
			for (int i = cols-2; i >= 0; i--)
				W[i] = "ϕ";
		}

	}


}




