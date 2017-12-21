
import java.nio.charset.StandardCharsets;
import java.util.Base64;


import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * This class contain the methods to en- and decode
 *
 * @author Stefan Kuppelwieser <edelblistar@online.de>
 */
public class Base64Crypt {

    /**
     * It encode a given value
     *
     * @param value It expect the value, which should encode
     * @return the encoded value as String
     */
    public String encode(String value){

        byte[] encodedBytes = Base64.getEncoder().encode(value.trim().getBytes());

        return new String(encodedBytes, StandardCharsets.UTF_8);
    }

    /**
     * It decode a given value
     *
     * @param value It expect the value, which should decode
     * @return the decoded value as String
     */
    public String decode(String value){

        byte[] decodedBytes = Base64.getDecoder().decode(value);
        return new String(decodedBytes);
    }

    /**
     * It generates random a 128 bit aes key
     *
     * @return a random 128 bit aes key
     */
    public SecretKey generateBase64Key() {

        KeyGenerator keyGen;

        try {
            keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // for example
            SecretKey secretKey = keyGen.generateKey();
            return secretKey;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * convert a key to string
     *
     * @param secretKey It expect a key
     * @return a key as string
     */
    public String keyToString(SecretKey secretKey) {
        /* Get key in encoding format */
        byte encoded[] = secretKey.getEncoded();

        /*
         * Encodes the specified byte array into a String using Base64 encoding
         * scheme
         */
        String encodedKey = Base64.getEncoder().encodeToString(encoded);

        return encodedKey;
    }
}
