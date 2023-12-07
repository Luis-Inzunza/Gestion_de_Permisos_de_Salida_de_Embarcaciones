package org.LittleBoat.report;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateReader {

    public String[] getTemplateIdentifiers(String[] lista){
        Pattern pattern = Pattern.compile("<([^>]+)>");
        int count = 0;
        for (String str : lista) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                count++;
            }
        }
        String[] resultArray = new String[count];
        int index = 0;
        for (String str : lista) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                resultArray[index] = matcher.group(1);
                index++;
            }
        }
        return resultArray;
    }

    public String[] getTemplate(){
        FileReader archivoTxt = new FileReader("src/main/resources/reportFiles/template.txt");
        String[] lista = archivoTxt.readTxt();
        return lista;
    }
    
}
