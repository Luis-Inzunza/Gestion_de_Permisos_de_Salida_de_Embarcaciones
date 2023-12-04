import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Key {
    private Security security;

    public Key () {
        security = new Security();
    }
    
    private String readRecord (String pathFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/files/password.txt"))) {
            String key = bufferedReader.readLine();
            System.out.println(key);
            bufferedReader.close();
            return key;
        } catch (IOException e) {
            System.out.println();
        }
        return "";
    }

    public String obtainKey () {
        return security.desencriptar(readRecord("password.txt"));
    }
}
