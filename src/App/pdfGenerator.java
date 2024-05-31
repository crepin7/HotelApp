/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
/**
 *
 * @author Coutso
 */

public class pdfGenerator {
    
    public static void main(String[] args){
        try {
            String fichierPdf = "C:\\Users\\Coutso\\Documents\\Test\\exemple.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fichierPdf));
            
            document.open();
            
            // ajouter paragraphe
            
            Paragraph p = new Paragraph("Premier pdf généré par code");
            
            document.add(p);
            
            // ajouter table
            
            PdfPTable table = new PdfPTable(3);
            
            PdfPCell c1 = new PdfPCell(new Phrase("Entête 1"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Entête 2"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Entête 3"));
            table.addCell(c1);
            
            table.setHeaderRows(1);
            
            table.addCell("1.0");
            table.addCell("1.1");
            table.addCell("1.2");
            table.addCell("2.1");
            table.addCell("2.2");
            table.addCell("2.3");
            
            document.add(table);
            
            // ajouter image
            
            document.add(Image.getInstance("C:\\Users\\Coutso\\Documents\\Icones\\la-personne.png"));
            
            document.close();
            
            System.out.println("Creation du fichier...");
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(pdfGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pdfGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
