package org.LittleBoat.report;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ileana
 */
public class FileReader {
    
    private final File aFile;

    public FileReader(String filePath) {
        this.aFile = new File(filePath);
    }
    
    public String[] readTxt(){

        Scanner fileDimensions = openFile();

        int rowsNumber=0;
        while (fileDimensions.hasNextLine()){
            fileDimensions.nextLine();
            rowsNumber++;                
        }
        fileDimensions.close();

        String[] fileContent = new String[rowsNumber];
        
        Scanner fileReader = openFile();
        for (int i=0; i<rowsNumber;i++){
            String data = fileReader.nextLine();
            fileContent[i] = data;
        }
        fileReader.close();

        return fileContent;
    }

    public String[][] readCSV(){

            Scanner fileDimensions = openFile();

            int rowsNumber = 0;
            int columnsNumber = 0;

            while(fileDimensions.hasNextLine()){
                String line = fileDimensions.nextLine();
                String[] datafile = line.split(";");
                columnsNumber = datafile.length;
                rowsNumber++;
            }
            fileDimensions.close();
            
            String[][] fileContent = new String[rowsNumber][columnsNumber];
            Scanner fileReader = openFile();

            for (int i=0;i<rowsNumber;i++){
                String line = fileReader.nextLine();
                String[] datafile = line.split(";");
                for (int j = 0; j < columnsNumber; j++){
                    fileContent[i][j] = datafile[j];
                }
            }
            fileReader.close();

        return fileContent;
    }

    private Scanner openFile(){
        Scanner fileReader = null;
        try{
            fileReader = new Scanner(this.aFile,"UTF-8");
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
        return fileReader;
    }
}
