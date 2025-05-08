package labxv.sict.must.edu.mn;

public final class Determinant {

    /**Baiguulagch function. */
    private Determinant() {
        // Prevent instantiation
    }

    /**
     * Matrixiin todorhoilogch bodno.
     * @param matrix matrix
     * @return todorhoilogchiin utga
     * @throws IllegalArgumentException Matrix kvadrat bish bol aldaa ugnu
     */
    public static int calculate(final Matrix matrix) {
        int[][] data = matrix.getData();
        if (data.length != data[0].length) {
            throw new IllegalArgumentException(
                "Matrixiin helber kvadrat baih ystoi"
                );
        }
        return computeDeterminant(data);
    }

    /**
     * Todorhoilogchiig bodno.
     * @param matrix matrix
     * @return todorhoilogch
     */
    private static int computeDeterminant(final int[][] matrix) {
        // Undsen tohioldol
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        // Davtalttai tohioldol
        int determinant = 0;
        for (int col = 0; col < matrix.length; col++) {
            determinant += (col % 2 == 0 ? 1 : -1)
                 * matrix[0][col]
                 * computeDeterminant(getMinor(matrix, 0, col));
        }
        return determinant;
    }

    /**
     * Jijig todorhoilogchuudiig bodno.
     * @param matrix matrix
     * @param excludedRow oroogui murnuud
     * @param excludedCol oroogui baganuud
     * @return jijig matrixiin utga
     */
    private static int[][] getMinor(final int[][] matrix,
    final int excludedRow, final int excludedCol) {
        int[][] minor = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 0, mi = 0; i < matrix.length; i++) {
            if (i == excludedRow) {
                continue;
            }
            for (int j = 0, mj = 0; j < matrix.length; j++) {
                if (j == excludedCol) {
                    continue;
                }
                minor[mi][mj++] = matrix[i][j];
            }
            mi++;
        }
        return minor;
    }
}
