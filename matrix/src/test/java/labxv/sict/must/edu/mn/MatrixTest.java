package labxv.sict.must.edu.mn;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MatrixTest {
    @Test
    public void testConstructorAndGetData() {
        int[][] input = {
            {1, 2},
            {3, 4}
        };
        Matrix matrix = new Matrix(input);
        assertArrayEquals(input, matrix.getData());
    }

    @Test
    public void testSubtract() {
        Matrix m1 = new Matrix(new int[][]{{5,4},{8,6}});
        Matrix m2 = new Matrix(new int[][]{{1,2},{1,2}});
        Matrix result = m1.subtract(m2);
        assertArrayEquals(new int[][]{{4, 2}, {7, 4}}, result.getData());
    }

    @Test
    public void testSubtractionDimensionMismatch() {
        Matrix m1 = new Matrix(new int[][]{{1, 2}});
        Matrix m2 = new Matrix(new int[][]{{1}, {2}});
        Exception exception = assertThrows(IllegalArgumentException.class, () -> m1.subtract(m2));
        assertEquals("Matrixuudiin hemjee adil baih", exception.getMessage());
    }

    @Test
    public void testAdd() {
        Matrix m1 = new Matrix(new int[][]{{1, 2}, {3, 4}});
        Matrix m2 = new Matrix(new int[][]{{5, 6}, {7, 8}});
        Matrix result = m1.add(m2);
        assertArrayEquals(new int[][]{{6, 8}, {10, 12}}, result.getData());
    }

    @Test
    public void testAdditionDimensionMismatch() {
        Matrix m1 = new Matrix(new int[][]{{1, 2}});
        Matrix m2 = new Matrix(new int[][]{{1, 2}, {3, 4}});
        Exception exception = assertThrows(IllegalArgumentException.class, () -> m1.add(m2));
        assertEquals("Matrixiin hemjee adil baih", exception.getMessage());
    }

    @Test
    public void testMultiply() {
        Matrix m1 = new Matrix(new int[][]{{1, 2}, {3, 4}});
        Matrix m2 = new Matrix(new int[][]{{5, 6}, {7, 8}});
        Matrix result = m1.multiply(m2);
        assertArrayEquals(new int[][]{{19, 22}, {43, 50}}, result.getData());
    }

    @Test
    public void testMultiplicationDimensionMismatch() {
        Matrix m1 = new Matrix(new int[][]{{1, 2}});
        Matrix m2 = new Matrix(new int[][]{{1, 2}});
        Exception exception = assertThrows(IllegalArgumentException.class, () -> m1.multiply(m2));
        assertEquals("Ehnii matrixiin bagana != 2 dahi matrixiin mur", exception.getMessage());
    }

    @Test
    public void testTranspose() {
        Matrix m1 = new Matrix(new int[][]{{1, 2}, {3, 4}});
        Matrix result = m1.transpose();
        assertArrayEquals(new int[][]{{1, 3}, {2, 4}}, result.getData());
    }
    
    @Test
    public void testToString() {
        Matrix m = new Matrix(new int[][]{
            {1, 2},
            {3, 4}
        });
        String expected = "1 2 \n3 4 \n";
        assertEquals(expected, m.toString());
    }

}
