package cn.wzz.test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class DecryptMobile {
    public static String decrypt(String algorithm, String cipherText, SecretKey key,IvParameterSpec iv)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(plainText);
    }

    public static void main(String []args)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        String clientSecret = "0123456789abcdef0123456789abcdef";
        String encryptedMobile = "tyUWQwYuUmVFJtElAL+D7Q==";

        byte[] clientSecretBytes = clientSecret.getBytes();
        SecretKey secretKey = new SecretKeySpec(clientSecretBytes, 0, clientSecretBytes.length, "AES");

        byte[] iv = Arrays.copyOfRange(clientSecretBytes, 0, 16);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        String algorithm = "AES/CBC/PKCS5Padding";

        String mobile = decrypt(algorithm, encryptedMobile, secretKey, ivParameterSpec);
        System.out.println(mobile);
    }
}
