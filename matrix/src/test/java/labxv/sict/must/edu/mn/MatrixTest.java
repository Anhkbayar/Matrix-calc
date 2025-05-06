package labxv.sict.must.edu.mn;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class MatrixTest {
    @Test
    public void testAdd() {
        Matrix m1 = new Matrix(new int[][]{{1, 2}, {3, 4}});
        Matrix m2 = new Matrix(new int[][]{{5, 6}, {7, 8}});
        Matrix result = m1.add(m2);
        assertArrayEquals(new int[][]{{6, 8}, {10, 12}}, result.getData());
    }

    @Test
    public void testMultiply() {
        Matrix m1 = new Matrix(new int[][]{{1, 2}, {3, 4}});
        Matrix m2 = new Matrix(new int[][]{{5, 6}, {7, 8}});
        Matrix result = m1.multiply(m2);
        assertArrayEquals(new int[][]{{19, 22}, {43, 50}}, result.getData());
    }

    @Test
    public void testTranspose() {
        Matrix m1 = new Matrix(new int[][]{{1, 2}, {3, 4}});
        Matrix result = m1.transpose();
        assertArrayEquals(new int[][]{{1, 3}, {2, 4}}, result.getData());
    }
}
