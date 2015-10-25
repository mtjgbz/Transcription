/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Erica
 */
public class SearchTest {
    //1. Parse XML into a Doc using DocumentBuilder
    //2. Get all <string> elements using getElementsByTagName
    //3. Check if their values equal your test using getNodeValue
    private Document doc;
    private NodeList nList;
    
    //This is a template for a later search - we can use these methods to search
    //for words easily but there's more that can be done to make it easier
    
    public SearchTest(){
        try{
            File inputFile = new File("test.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("Sync");
            printNames();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private void printNames(){
        boolean found = false;
        
        for (int i = 0; i < nList.getLength(); i++){
            Node nNode = nList.item(i);
            NamedNodeMap attributes = nNode.getAttributes();
            //System.out.print(nNode.getNodeName());
            //System.out.print(": " + attributes.getNamedItem("time"));
            //System.out.println(" " + nNode.getNextSibling().getNodeValue().contains("ni1bi4"));
            
            if(nNode.getNextSibling().getNodeValue().contains("ni1bi4")){
                System.out.print("Start time: ");
                System.out.println(attributes.getNamedItem("time"));
                found = true;
            }else if(found == true){
                System.out.print("Stop time: ");
                System.out.println(attributes.getNamedItem("time"));
                found = false;
            }
        }
    }
}
