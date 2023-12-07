package org.LittleBoat.security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Security{

    private final String secretKeyUs;

    public Security () {
        this.secretKeyUs = obtainKey();
    }

    private String obtainKey () {
        String clave = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/files/clave.txt"))) {
            clave = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Llave no encontrada");
        }
        return clave;
    }

    public String encrypt(String datos) {
        String claveSecreta = this.secretKeyUs;
        try {
            SecretKeySpec secretKey = this.createKey(claveSecreta);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptar = datos.getBytes("UTF-8");
            byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
            String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);

            return encriptado;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 UnsupportedEncodingException |
                 IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private SecretKeySpec createKey(String clave) {
        try {
            byte[] claveEncriptacion = clave.getBytes("UTF-8");

            MessageDigest sha = MessageDigest.getInstance("SHA-1");

            claveEncriptacion = sha.digest(claveEncriptacion);
            claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);

            SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");

            return secretKey;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            System.out.println(e);
        }

        return null;
    }

    public String decrypt(String datosEncriptados) {
        String secretKeyString = this.secretKeyUs;
        try {
            SecretKeySpec secretKey = this.createKey(secretKeyString);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] encryptedBytes = Base64.getDecoder().decode(datosEncriptados);
            byte[] decryptedData = cipher.doFinal(encryptedBytes);
            String data = new String(decryptedData);

            return data;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}