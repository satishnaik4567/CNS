import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;
import java.util.Base64;

public class RijndaelAlgorithm {

    public static String encrypt(String data, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text to encrypt: ");
            String data = scanner.nextLine();
            
            System.out.print("Enter 16-byte encryption key: ");
            String key = scanner.nextLine();
            
            if (key.length() != 16) {
                System.out.println("Key must be 16 characters long.");
                return;
            }

            // Encrypt the text
            String encryptedData = encrypt(data, key);
            System.out.println("Encrypted Text: " + encryptedData);

            // Decrypt the text
            String decryptedData = decrypt(encryptedData, key);
            System.out.println("Decrypted Text: " + decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
