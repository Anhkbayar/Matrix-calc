package labxv.sict.must.edu.mn;

import java.util.Scanner;

/**
 * Main application class.
 *
 */
public final class App {
    /**
     * private constructor.
     */
    private App() {

    }

    /** Scanner uusgeh. */
    private static final Scanner SCANNER = new Scanner(System.in);

    /** Nemeh songolt. */
    private static final int MENU_ADD = 1;
    /** Hasah songolt. */
    private static final int MENU_SUBTRACT = 2;
    /** Urjuuleh songolt. */
    private static final int MENU_MULTIPLY = 3;
    /** Huvirgah songolt. */
    private static final int MENU_TRANSPOSE = 4;
    /** Garah songolt. */
    private static final int MENU_EXIT = 5;

    /**
     * Main method.
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("=== Matrix Operations ===");

        // Ehnii matrix
        System.out.println("\nEnter Matrix 1:");
        Matrix m1 = readMatrix();

        // 2 dahi matrix
        System.out.println("\nEnter Matrix 2:");
        Matrix m2 = readMatrix();

        // Menu
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Transpose Matrix 1");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");

            int choice = SCANNER.nextInt();
            switch (choice) {
                case MENU_ADD -> {
                    System.out.println("\nAddition Result:");
                    System.out.println(m1.add(m2));
                }
                case MENU_SUBTRACT -> {
                    System.out.println("\nSubtraction Result:");
                    System.out.println(m1.subtract(m2));
                }
                case MENU_MULTIPLY -> {
                    System.out.println("\nMultiplication Result:");
                    System.out.println(m1.multiply(m2));
                }
                case MENU_TRANSPOSE -> {
                    System.out.println("\nTranspose of Matrix 1:");
                    System.out.println(m1.transpose());
                }
                case MENU_EXIT -> {
                    try (SCANNER) {
                        System.out.println("Exiting...");
                    }
                    return;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Helper method to read a matrix from user input
    private static Matrix readMatrix() {
        System.out.print("Enter number of rows: ");
        int rows = SCANNER.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = SCANNER.nextInt();

        int[][] data = new int[rows][cols];
        System.out.println("Enter matrix values (row-wise):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Enter value for [%d][%d]: ", i, j);
                data[i][j] = SCANNER.nextInt();
            }
        }
        return new Matrix(data);
    }
}
