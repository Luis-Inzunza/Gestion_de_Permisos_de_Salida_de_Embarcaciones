package org.LittleBoat.report;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.awt.Color;
import java.io.IOException;

public class PDFGenerator {
    private static final float MARGEN_SUPERIOR = 50;
    private static final float MARGEN_INFERIOR = 50;
    private static final float MARGEN_IZQUIERDO = 50;
    private static final float MARGEN_DERECHO = 100;

    public boolean validateInformation(String[] txtIdentifiers, String[] csvIdentifiers, String[][] csvData){
        if(txtIdentifiers.length==0){
            System.out.println("Error, template sin identificadores");
            return false;
            
        }
        if(csvIdentifiers.length!=txtIdentifiers.length){
            System.out.println("Error, los identificadores no coinciden");
            return false;
        }
        for( int i=0;i<csvIdentifiers.length;i++){
            if(!(csvIdentifiers[i].equals(txtIdentifiers[i]))){
                System.out.println("Error, los identificadores no coinciden");
                return false;
            }
        }
        if(csvData.length == 1){
            System.out.println("Archivo de datos vacío");
            return false;
        }
        return true;

    }

    public void generarPDF(){
        TemplateReader lectorTemplate = new TemplateReader();
        CSVProcessor processCSV = new CSVProcessor();
        String[] txtIdentifiers= lectorTemplate.getTemplateIdentifiers(lectorTemplate.getTemplate());
        String[] csvIdentifiers = processCSV.obtenerIdentificadoresCSV(processCSV.getCSVData());
        String[][] csvData = processCSV.getCSVData();
        if(validateInformation(txtIdentifiers, csvIdentifiers, csvData)){
            String dataPDF="";
            for (int i=1;i<csvData.length;i++){
                String[] template = lectorTemplate.getTemplate();
                for (String line : template) {
                    for (int y = 0; y < txtIdentifiers.length && y < csvData[i].length; y++) {
                        String identificiador = "<"+txtIdentifiers[y]+">";
                        line = line.replace(identificiador, csvData[i][y]);
                    }
                    dataPDF = dataPDF + line + "\n";
                }
                dataPDF=dataPDF+"\n";
            }

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.LETTER);
            document.addPage(page);
            PDPageContentStream contentStream = null;

            try {
                contentStream = new PDPageContentStream(document, page);
                float fontSize = 11;
                float leading = 1.5f * fontSize;

                PDType1Font font = PDType1Font.TIMES_ROMAN; 
                contentStream.setFont(font, fontSize);
                contentStream.setNonStrokingColor(Color.BLACK);

                // Iniciar en la posición superior izquierda, considerando los márgenes
                float startX = MARGEN_IZQUIERDO;
                float startY = page.getMediaBox().getHeight() - MARGEN_SUPERIOR;
                float width = page.getMediaBox().getWidth() - MARGEN_IZQUIERDO - MARGEN_DERECHO;

                String[] lines = dataPDF.split("\n");

                for (String line : lines) {
                    // Incluso si la línea está vacía, se debe mover el cursor hacia abajo
                    if (line.trim().isEmpty()) {
                        startY -= leading;
                        continue;
                    }
                
                    // Envolver el texto si es más largo que el ancho disponible
                    while (line.length() > 0) {
                        int lastSpace = -1;
                        float size = fontSize * font.getStringWidth(line) / 1000;
                        if (size > width) {
                            lastSpace = line.lastIndexOf(' ', (int) (width / (fontSize * font.getAverageFontWidth() / 1000)));
                            if (lastSpace < 0) {
                                lastSpace = line.length();
                            }
                        } else {
                            lastSpace = line.length();
                        }
                
                        String subLine = line.substring(0, lastSpace);
                        line = line.substring(lastSpace).trim();
                
                        contentStream.beginText();
                        contentStream.setFont(font, fontSize);
                        contentStream.newLineAtOffset(startX, startY);
                        contentStream.showText(subLine);
                        contentStream.endText();
                        startY -= leading;
                
                        // Comprobar si es necesario agregar una nueva página
                        if (startY < MARGEN_INFERIOR) {
                            contentStream.close();
                            page = new PDPage(PDRectangle.LETTER);
                            document.addPage(page);
                            contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.OVERWRITE, true, true);
                            startY = page.getMediaBox().getHeight() - MARGEN_SUPERIOR;
                        }
                    }
                }

                contentStream.close();
                document.save("src/main/resources/reportFiles/prueba.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
        else{
        }
    }
    
}