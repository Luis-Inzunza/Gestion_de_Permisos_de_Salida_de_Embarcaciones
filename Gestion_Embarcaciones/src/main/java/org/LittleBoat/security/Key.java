package org.LittleBoat.security;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Key {
    private Security security;

    public Key() {
        this.security = new Security();
    }

    private String readRecord () {
        String keyPath = "src/main/resources/files/password.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(keyPath))) {
            String key = bufferedReader.readLine();
            bufferedReader.close();
            return key;
        } catch (IOException e) {
            System.out.println();
        }
        return "";
    }

    public String obtainKey () {
        return security.decrypt(readRecord());
    }
}
