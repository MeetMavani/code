class IS5 {

    public static void main(String args[]) {

        int p = 61;
        int q = 53;
        int e = 17;
        int plainText = 123;

        //compute n
        int n = p * q;

        //Euler Totient Function
        int phi = (p - 1) * (q - 1);

        //claculate private key component
        int d = modInverse(e, phi);

        int encrypted = modPow(plainText, e, n);
        int decrypted = modPow(encrypted, d, n);

        System.out.print("Encrypted : "+ encrypted);
        System.out.println("\nDecrypted : "+ decrypted);
    }

    public static int modPow(int base, int exponent, int modulus) {

        int result = 1;
        for(int i = 1; i <= exponent; i++) {
            result = (result * base) % modulus; 
        }

        return result;
    }

    public static int modInverse(int a, int m) {
        int m0 = m;
        int x = 0;
        int y = 1;

        while(a > 1) {
            int q = a / m;
            int t = m;
            m = a % m;
            a = t;
            t = x;
            x = y - q * x;
            y = t;
        }

        if(y < 0) {
            y += m0;
        }

        return y;
    }
}





















import java.math.BigInteger;

public class RSA {

    public static void main(String[] args) {
        // Key generation
        BigInteger p = new BigInteger("61");
        BigInteger q = new BigInteger("53");
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = new BigInteger("17"); // Public exponent
        BigInteger d = e.modInverse(phi); // Private exponent
        
        // Encryption
        BigInteger plaintext = new BigInteger("123");
        BigInteger ciphertext = plaintext.modPow(e, n);
        
        // Decryption
        BigInteger decrypted = ciphertext.modPow(d, n);
        
        System.out.println("Encrypted: " + ciphertext);
        System.out.println("Decrypted: " + decrypted);
    }
}
