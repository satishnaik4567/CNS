import java.util.Scanner;

public class Hillcipher {
    private static final int MATRIX_SIZE = 2;
    private static final int MODULO = 26;

    public static String encrypt(String plaintext, int[][] keyMatrix) {
        plaintext = plaintext.toUpperCase();
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            int x = plaintext.charAt(i) - 'A';
            int y = plaintext.charAt(i + 1) - 'A';
            int c1 = (keyMatrix[0][0] * x + keyMatrix[0][1] * y) % MODULO;
            int c2 = (keyMatrix[1][0] * x + keyMatrix[1][1] * y) % MODULO;
            ciphertext.append((char) (c1 + 'A')).append((char) (c2 + 'A'));
        }
        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 2x2 key matrix (4 integers):");
        int[][] keyMatrix = {{scanner.nextInt(), scanner.nextInt()}, {scanner.nextInt(), scanner.nextInt()}};

        System.out.print("Enter plaintext: ");
        String plaintext = scanner.next().toUpperCase();

        if (plaintext.length() % 2 != 0) plaintext += "X"; // Pad if odd length
        String encryptedText = encrypt(plaintext, keyMatrix);
        System.out.println("Encrypted Text: " + encryptedText);
    }
}
