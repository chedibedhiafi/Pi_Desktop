/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantech;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import interfaces.IhistoriqueStock;
import interfaces.IpointDeVente;
import interfaces.Iproduits;
import interfaces.Istock;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.HistoriqueStock;
import models.PointDeVente;
import models.Produit;
import models.Stock;
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
    public static void main(String[] args) {
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
        Produit prod = serviceProduit.retriveproduit(106);
        PointDeVente pt = serviceDeVente.retrievePointDeVente(4);
        HistoriqueStock hs = new HistoriqueStock(new Stock(prod, pt), Date.valueOf(LocalDate.now()), 100, "Restock");
        //serviceHistoriqueStock.insertInHistoriqueStock(hs);
    }
    
    
}
