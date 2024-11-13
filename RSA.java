import java.math.BigInteger;
import java.security.SecureRandom;
public class RSA
{
private final static BigInteger one = new BigInteger("1");
private final static SecureRandom random = new SecureRandom();
private BigInteger privateKey;
private BigInteger publicKey;
private BigInteger modulus;
public RSA(int bitLength) {
BigInteger p = BigInteger.probablePrime(bitLength / 2, random);
BigInteger q = BigInteger.probablePrime(bitLength / 2, random);
BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
modulus = p.multiply(q);
publicKey = new BigInteger("65537");
privateKey = publicKey.modInverse(phi);
}
public BigInteger encrypt(BigInteger message)
{
return message.modPow(publicKey, modulus);
}
public BigInteger decrypt(BigInteger encryptedMessage)
{
return encryptedMessage.modPow(privateKey, modulus);
}
public static void main(String[] args) {
RSA rsa = new RSA(1024);
BigInteger message = new BigInteger("111");
BigInteger encrypted = rsa.encrypt(message);
System.out.println("Encrypted message: " + encrypted);
BigInteger decrypted = rsa.decrypt(encrypted);
System.out.println("Decrypted message: " + decrypted);
}
}