package labxv.sict.must.edu.mn;

/**
 * matrix logics here.
 */
public class Matrix {

    /**
     * 2d matrix.
     */
    private final int[][] data;
    /**
     * Muruudiin too.
     */
    private final int rows;
    /**
     * Baganuudiin too.
     */
    private final int cols;

    /**
     * Constructor function.
     *
     * @param matrixData 2d massive
     */
    public Matrix(final int[][] matrixData) {
        this.data = matrixData;
        this.rows = matrixData.length;
        this.cols = matrixData[0].length;
    }

    /** data get method. */
    public int[][] getData() {
        return data;
    }

    /**
     * 2 matrixiig nemne.
     *
     * @param other
     * @return matrixuudiin niilber
     */
    public Matrix add(final Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException(
                "Matrixiin hemjee adil baih"
            );
        }
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * 2 matxiig hasna.
     *
     * @param other
     * @return matrixuudiin yalgavar
     */
    public Matrix subtract(final Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException(
                "Matrixuudiin hemjee adil baih"
            );
        }
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * 2 matrixiig hoorond ni urjine.
     *
     * @param other
     * @return urjuulsen matrix
     */
    public Matrix multiply(final Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException(
                "Ehnii matrixiin bagana != 2 dahi matrixiin mur"
            );
        }
        int[][] result = new int[this.rows][other.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    /**
     * matrixiig diagnoloor hurvuulne.
     *
     * @return hurvuulsen matrix
     */
    public Matrix transpose() {
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = data[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * Matrixiig string bolgono.
     *
     * @return string bolgson matrixiig butsaana
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
