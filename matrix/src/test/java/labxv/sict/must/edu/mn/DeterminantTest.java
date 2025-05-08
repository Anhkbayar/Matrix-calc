package labxv.sict.must.edu.mn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DeterminantTest {
    @Test
    public void test1x1Matrix() {
        Matrix m = new Matrix(new int[][]{{5}});
        assertEquals(5, Determinant.calculate(m));
    }

    @Test
    public void test2x2Matrix() {
        Matrix m = new Matrix(new int[][]{{4, 6}, {3, 8}});
        assertEquals(14, Determinant.calculate(m)); // 4*8 - 6*3 = 32-18=14
    }

    @Test
    public void test3x3Matrix() {
        Matrix m = new Matrix(new int[][]{{6, 1, 1}, {4, -2, 5}, {2, 8, 7}});
        assertEquals(-306, Determinant.calculate(m));
    }

    @Test
    public void test4x4Matrix() {
        Matrix m = new Matrix(new int[][]{{2, 3, 1, 5}, {1, 1, 1, 4}, {5, 3, -2, 7}, {1, 4, 2, 3}});
        assertEquals(-4, Determinant.calculate(m));
    }

    @Test
    public void testNonSquareMatrix() {
        Matrix m = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}});
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Determinant.calculate(m));
        assertTrue(exception.getMessage().contains("Matrixiin helber kvadrat baih ystoi"));
    }

    @Test
    public void testOddSignAlternation() {
        // Tests the sign alternation logic (col % 2 == 0 ? 1 : -1)
        Matrix m = new Matrix(new int[][]{{0, 1, 0}, {1, 0, 1}, {0, 1, 0}});
        assertEquals(0, Determinant.calculate(m));
    }

    @Test
    public void testAllZerosMatrix() {
        Matrix m = new Matrix(new int[][]{{0, 0}, {0, 0}});
        assertEquals(0, Determinant.calculate(m));
    }

    @Test
    public void testIdentityMatrix() {
        Matrix m = new Matrix(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
        assertEquals(1, Determinant.calculate(m));
    }
}
