package se.mah.k3;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

//import com.sun.org.apache.xerces.internal.parsers.DOMParser;


public class ParserNew {
	
	ArrayList<ParserTime> timeList = new ArrayList<ParserTime>();
	
	ArrayList<Parser> superDone = new ArrayList<Parser>();
	
	ArrayList<ParserMoment> momentList = new ArrayList<ParserMoment>();
	
	ArrayList<ParserCourseName> courseNameList = new ArrayList<ParserCourseName>();
	
	ArrayList<ParserRoom> roomList = new ArrayList<ParserRoom>();
	
	KronoxGUI gui;
	
	public ParserNew(KronoxGUI gui){
		this.gui = gui;
		
	}
	

    
	
		
		String room = "";
		String info = "";
		String teacher = "";
		String startTid = "";
    	String slutTid = "";

		
		public ArrayList<Parser> parse() {	
		
		String room = null;
		String info = null;
		String teacher = null;
		String startTid = null;
    	String slutTid = null;
    	CourseNames names = new CourseNames();

    	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("http://schema.mah.se/setup/jsp/SchemaXML.jsp?startDatum=idag&intervallTyp=d&intervallAntal=1&sokMedAND=false&sprak=SV&resurser=l.NI%3AA0301%2Cl.NI%3AA0304%2Cl.NI%3AA0305%2Cl.NI%3AA0306%2Cl.NI%3AA0307%2Cl.NI%3AA0311%2Cl.NI%3AA0314%2Cl.NI%3AA0318%2Cl.NI%3AA0322%2Cl.NI%3AA0401%2Cl.NI%3AA0404%2Cl.NI%3AA0405%2Cl.NI%3AA0406%2Cl.NI%3AA0407%2Cl.NI%3AA0411%2Cl.NI%3AA0414%2Cl.NI%3AA0418%2Cl.NI%3AA0422%2Cl.NI%3AA0502%2Cl.NI%3AA0506%2Cl.NI%3AA0507%2Cl.NI%3AA0510%2Cl.NI%3AA0513%2Cl.NI%3AA0515%2Cl.NI%3AA0602%2Cl.NI%3AA0606%2Cl.NI%3AA0607%2Cl.NI%3AA0611%2Cl.NI%3AA0614%2Cl.NI%3AB0203%2Cl.NI%3AB0303%2Cl.NI%3AB0305%2Cl.NI%3AB0308%2Cl.NI%3AB0314%2Cl.NI%3AB0321%2Cl.NI%3AB0E07%2Cl.NI%3AB0E15%2Cl.NI%3AC0205%2Cl.NI%3AC0301%2Cl.NI%3AC0305%2Cl.NI%3AC0306%2Cl.NI%3AC0309%2Cl.NI%3AC0312%2Cl.NI%3AC0315%2Cl.NI%3AC0319%2Cl.NI%3AC0325%2Cl.NI%3AC0401%2Cl.NI%3AC0E11%2C");
			NodeList bookings = doc.getElementsByTagName("schemaPost");
			for(int i = 0; i < bookings.getLength(); i++){
				Node p = bookings.item(i);
				room = "";
				info = "";
				 teacher = "";
				startTid = "";
		    	slutTid = "";
				if(p.getNodeType() == Node.ELEMENT_NODE){
					Element doc1 = (Element) p;
					
					NodeList items3 = doc1.getElementsByTagName("moment");	            
		            for (int t = 0; t < items3.getLength(); t++)
		            {
		                Node n1 = items3.item(t);
		                if (n1.getNodeType() == Node.ELEMENT_NODE) {

		        			Element eElement = (Element) n1;
		        			eElement.getTextContent();
		        			

		        			info = eElement.getTextContent().replace("&#246;", "ö").replace("&#214;", "Ö").replace("&#228;", "ä").replace("&#229;", "å").replace("<br>", " ").replace("&#822;1", " ").replace("&#233;","è").replace("<br />", " ").replace("&#196;", "Ä").replace("<strong>", " ").replace("</strong>", " ").replace("&#8217;", "´").replace("&#8216", "`").replace("&amp;", "&");
		    			
		                }
		            }
			
					
				NodeList items2 = doc1.getElementsByTagName("bokadeDatum");	            
	            for (int t = 0; t < items2.getLength(); t++)
	            {
	                Node n1 = items2.item(t);
	                if (n1.getNodeType() == Node.ELEMENT_NODE) {

	        			Element eElement = (Element) n1;
	        			Node node3 = eElement.getFirstChild();
	        			Node node4 = node3.getAttributes().getNamedItem("startTid");
	        			Node node5 = node3.getAttributes().getNamedItem("slutTid");
	        			
	        			startTid = node4.getNodeValue();
	        			slutTid = node5.getNodeValue();
	        			timeList.add(new ParserTime(startTid + " - " + slutTid));
	        			
	                }
	            }
				}
				
				if(p.getNodeType() == Node.ELEMENT_NODE){
				Element booking = (Element) p;
				NodeList resource = booking.getElementsByTagName("resursNod");
				for(int j = 0; j < resource.getLength(); j++){
					Node n = resource.item(j);
					if(n.getNodeType() == Node.ELEMENT_NODE){
						Element classType = (Element) n;
						String id = classType.getAttribute("resursTypId");
						NodeList classResource = classType.getElementsByTagName("resursId");
						for(int k = 0; k < classResource.getLength(); k++){
							Node specifiedClass = classResource.item(k);
							if(specifiedClass.getNodeType() == Node.ELEMENT_NODE){
								Element name = (Element) specifiedClass;
								
								
											
								if(id.contains("RESURSER_LOKALER")){
									room = name.getTextContent();
									
								}
								
								if(id.contains("UTB_KURSINSTANS_GRUPPER")){
									teacher = name.getTextContent();
									
								}
							}
						}
						
							}
							
						}
					}
				
				
				if (teacher.length()>0){
					
			superDone.add(new Parser(teacher, startTid, slutTid));
			
				}
				
			//momentList.add(new ParserMoment(info));
			
				
					
				//courseNameList.add(new ParserCourseName(teacher));
				
				
				//roomList.add(new ParserRoom(room));
				
			}
		}
		catch (Exception e)
        {
            e.printStackTrace();
        }
		superDone = names.courseNames(superDone);
		for(int h = 0; h < superDone.size(); h++){
		
			
			
			
		System.out.println(superDone.get(h).toString());
		
		gui.kurs1.append("\n"+ superDone.get(h).toString());
			
            
			
		}
		/**
		for(int r = 0; r < momentList.size(); r++){
		gui.momentTextArea.append(momentList.get(r) + "\n" + "\n" );
		
		}
		
		
		for(int t = 0; t < courseNameList.size(); t++){
		gui.courseTextArea.append(courseNameList.get(t) + "\n" + "\n");
		}
		
		for(int l = 0; l < roomList.size(); l ++ ){
			gui.roomTextArea.append(roomList.get(l)+ "\n" );
			
		}
		
		for (int s = 0; s < timeList.size(); s ++){
		gui.timeTextArea.append(timeList.get(s)+ "\n"  );
		}
		*/
		
		return superDone;
		
    }
		
}
