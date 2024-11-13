import javax.crypto.*;
import javax.crypto.spec.*;
public class RC4
{
public static byte[] encrypt(byte[] plaintext, byte[] key) throws Exception {
Cipher cipher = Cipher.getInstance("RC4");
SecretKeySpec secretKey = new SecretKeySpec(key, "RC4");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encrypted = cipher.doFinal(plaintext);
return encrypted;
}
public static byte[] decrypt(byte[] ciphertext, byte[] key) throws Exception {
Cipher cipher = Cipher.getInstance("RC4");
SecretKeySpec secretKey = new SecretKeySpec(key, "RC4");
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] decrypted = cipher.doFinal(ciphertext);
return decrypted;
}
public static void main(String[] args) throws Exception {
byte[] plaintext = "Hello, world!".getBytes();
byte[] key = "abcdefghijklmnop".getBytes(); // 16-byte key
byte[] ciphertext = encrypt(plaintext, key);
System.out.println("Ciphertext: " + new String(ciphertext));
byte[] decrypted = decrypt(ciphertext, key);
System.out.println("Decrypted text: " + new String(decrypted));
}
}