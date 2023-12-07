package org.LittleBoat.report;

public class CSVProcessor {

    public String[][] getCSVData(){
        FileReader csvFile = new FileReader("src/main/resources/reportFiles/data.txt");

        String[][] csvData = csvFile.readCSV();

        return csvData;
    }

    public String[] obtenerIdentificadoresCSV(String[][] csvData){
        return csvData[0];
    }
    
}
