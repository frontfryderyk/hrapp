package projekty.hrapp.security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;

public class Passwordutil {
    public static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        String salt = "";
        for (int i = 0; i < 20; i++) {
            salt += CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
        }
        return salt;
    }

    public static String hashPassword(String password, String salt) {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return new String(keyFactory.generateSecret(spec).getEncoded(), "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }
}

