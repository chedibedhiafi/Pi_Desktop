/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantech;


import interfaces.IhistoriqueStock;
import interfaces.IpointDeVente;
import interfaces.Iproduits;
import interfaces.Istock;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.time.LocalDate;
import javafx.scene.control.Cell;
import javafx.stage.FileChooser;
import models.HistoriqueStock;
import models.PointDeVente;
import models.Produit;
import models.Stock;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import services.ServiceHistoriqueStock;
import services.ServicePointDeVente;
import services.ServiceProduit;
import services.ServiceStock;


/**
 *
 * @author 21624
 */
public class Quantech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Iproduits serviceProduit = new ServiceProduit();
        IpointDeVente serviceDeVente = new ServicePointDeVente();
        Istock serviceStock = new ServiceStock();
        IhistoriqueStock serviceHistoriqueStock = new ServiceHistoriqueStock();
        
//        Document doc = new Document();
//        
//        try {
//            PdfWriter.getInstance(doc, new FileOutputStream("test.pdf"));
//            doc.open();
//            doc.add(new Paragraph("QUE TOUTE MA VIE KANDOR BELLIL"));
//            doc.close();
//            
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (DocumentException ex) {
//            ex.printStackTrace();
//        }
//      
  
            
//            XSSFWorkbook wb = new  XSSFWorkbook(new FileInputStream("template.xlsx"));
//            XSSFSheet sheet = wb.getSheet("Feuil1");
//            XSSFCell resultCell=(XSSFCell) sheet.getRow(12).getCell(1);
//            System.out.println(resultCell);
//            resultCell.setCellValue("YAAAS");
//
//            FileOutputStream fileOut = new FileOutputStream("new.xlsx"); 
//            wb.write(fileOut);
//            fileOut.close();
            

        


        
    }
    
    
}
