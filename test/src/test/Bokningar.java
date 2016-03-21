package test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import java.io.File;
import java.util.ArrayList;



public class Bokningar {
	
	

	public static void main(String[] args)
    {
        String url = "http://schema.mah.se/setup/jsp/SchemaXML.jsp?startDatum=idag&intervallTyp=d&intervallAntal=1&forklaringar=true&sokMedAND=false&sprak=SV&resurser=l.NI%3AA0301%2Cl.NI%3AA0304%2Cl.NI%3AA0305%2Cl.NI%3AA0306%2Cl.NI%3AA0307%2Cl.NI%3AA0311%2Cl.NI%3AA0314%2Cl.NI%3AA0318%2Cl.NI%3AA0322%2Cl.NI%3AA0401%2Cl.NI%3AA0404%2Cl.NI%3AA0405%2Cl.NI%3AA0406%2Cl.NI%3AA0407%2Cl.NI%3AA0411%2Cl.NI%3AA0414%2Cl.NI%3AA0418%2Cl.NI%3AA0422%2Cl.NI%3AA0502%2Cl.NI%3AA0506%2Cl.NI%3AA0507%2Cl.NI%3AA0510%2Cl.NI%3AA0513%2Cl.NI%3AA0515%2Cl.NI%3AA0602%2Cl.NI%3AA0606%2Cl.NI%3AA0607%2Cl.NI%3AA0611%2Cl.NI%3AA0614%2Cl.NI%3AB0203%2Cl.NI%3AB0303%2Cl.NI%3AB0305%2Cl.NI%3AB0308%2Cl.NI%3AB0314%2Cl.NI%3AB0321%2Cl.NI%3AB0E07%2Cl.NI%3AB0E15%2Cl.NI%3AC0205%2Cl.NI%3AC0301%2Cl.NI%3AC0305%2Cl.NI%3AC0306%2Cl.NI%3AC0309%2Cl.NI%3AC0312%2Cl.NI%3AC0315%2Cl.NI%3AC0319%2Cl.NI%3AC0325%2Cl.NI%3AC0401%2Cl.NI%3AC0E11%2C";   
        ArrayList<TimeTeachCode> listy = new ArrayList<TimeTeachCode>();
        String lokal = null;
    	String kurs = null;
    	
        
        try
        {
            DocumentBuilderFactory f = 
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            Document doc = b.parse(url);
 
            doc.getDocumentElement().normalize();
            System.out.println ("Root element: " + 
                        doc.getDocumentElement().getNodeName());
       
            NodeList items = doc.getElementsByTagName("resursNod");
            
            for (int i = 0; i < items.getLength(); i++)
            {
                Node n = items.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {

        			Element eElement = (Element) n;

        			
        			
        			if(eElement.getAttribute("resursTypId").equals("RESURSER_LOKALER")){
        		    lokal = eElement.getElementsByTagName("resursId").item(0).getTextContent();
        			/**System.out.println("First Name : " + eElement.getElementsByTagName("resursId").item(0).getTextContent());*/
        			
        			}
        			if(eElement.getAttribute("resursTypId").equals("UTB_KURSINSTANS_GRUPPER")){
            		    kurs = eElement.getElementsByTagName("resursId").item(0).getTextContent();
            			/**System.out.println("First Name : " + eElement.getElementsByTagName("resursId").item(0).getTextContent());*/
            			
            			}
        			listy.add(new TimeTeachCode(lokal, kurs));

        		}
 
                /**
                // get the "title elem" in this item (only one)
                NodeList titleList = e.getElementsByTagName("resursNod"); 
                int test1 = titleList.getLength();
                String test = e.getAttribute("rubrik");
                for(int p = 0; p < titleList.getLength(); p++){
                	Node l = titleList.item(p);
                	/**System.out.println("Kolumn : " + l.getNodeName());*/
                	/**
                	NamedNodeMap a = l.getAttributes();
                	
                	Node node1 = a.getNamedItem("resursTypId");
                	if(node1.getNodeValue().equals("UTB_PROGRAMINSTANS_KLASSER")){
                			
                		firstName = l.getTextContent();
                	}
                	if(node1.getNodeValue().equals("RESURSER_LOKALER")){
                			
                		lastName = l.getTextContent();
                	}
                  
                  listy.add(new TimeTeachCode(firstName, lastName));
              
              
              */
             /** NodeList items = doc.getElementsByTagName("resursNod");
              for (int i = 0; i < items.getLength(); i++)
              {
                  Node n = items.item(i);
                  if (n.getNodeType() != Node.ELEMENT_NODE)
                      continue;
                  Element e = (Element) n;
   
                  // get the "title elem" in this item (only one)
                NodeList titleList = e.getElementsByTagName("resursId");
                NamedNodeMap a = items.item(i).getAttributes();
                for(int ii = 0; ii <titleList.getLength(); ii++){
              	  Node noded = a.getNamedItem("resursTypId");
                    if(noded.getNodeValue().equals("RESURSER_SIGNATURER")){
                		System.out.println(titleList.item(0).getTextContent());	
                	}
                }*/
              
              
              
             
              
              
              
              
              
            
                /**
                String test = e.getAttribute("resursId");
                for(int p = 0; p < titleList.getLength(); p++){
                	Node l = titleList.item(p);
                	System.out.println("Kolumn : " + l.getNodeName());
                	
                	NamedNodeMap a = l.getAttributes();
                	
                	Node node1 = a.getNamedItem("resursTypId");
                	if(node1.getNodeValue().equals("RESURSER_LOKALER")){
                		System.out.println(l.getTextContent());	
                	}
                	/**for(int j = 0; j < a.getLength(); j++){
                		Node k = a.item(j);
                		System.out.println(k.getNodeValue());
                		
                		NamedNodeMap map = l.getAttributes();

                		Node node = null;
                		if(map != null){
                		node = map.getNamedItem("Id");
                		System.out.println("1 " + map.getLength());
                		}
                		if(node != null){
                		System.out.println(node.getNodeValue());
                		}
                		System.out.println(k.getAttributes());
                	}
                	/**if(a != null){
                	System.out.println(a.getNodeValue());
                	}*/
                	
                
            
        }
                // get the "text node" in the title (only one)
                
                /**System.out.println("number of nodes: " + test1);*/
               
        }
    
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        for(int g = 0; g < listy.size(); g++){
      	  System.out.println(listy.get(g).toString());
        }
}
	
}