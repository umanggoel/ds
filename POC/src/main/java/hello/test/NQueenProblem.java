package test;

public class NQueenProblem {

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		for (int i = 0; i < 4; i++) {
			mat[i][0] = 1;
			boolean temp = foo(mat, 3, i, 0, 4);
			if (!temp) {
				mat[i][0] = 0;
			}
		}
		System.out.println("done");
	}

	public static boolean foo(int[][] mat, int n, int i, int j, int m) {
		if (n <= 0) {
			return true;
		}
		if ((i < m && i > 0) && (j < m && j >= 0)) {
			for (int x = 2; x < m; x++) {
				boolean temp = foo(mat, n - 1, i + 1, j + x, m);
				if (temp) {
					mat[i + 1][j + x] = 1;
					return true;
				}
				temp = foo(mat, n - 1, i - 1, j + x, m);
				if (temp) {
					mat[i - 1][j + x] = 1;
					return true;
				}
			}
		}
		return false;
	}
}
