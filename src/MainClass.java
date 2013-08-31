
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



//http://developer.sportsdatallc.com/files/nfl_v1_season_schedule_example.xml
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		/*
		try{
			Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBNAME", "usrname", "pswd") ;
		Statement stmt = conn.createStatement() ;
		String query = "select columnname from tablename ;" ;
		ResultSet rs = stmt.executeQuery(query) ;
		}
		catch(Exception e){
			
		}*/
		
		
		
		
		
		
		
		
		
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document dom = null;
		int year = 2012;
		try {

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			dom = db.parse("2012.xml");
			

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		
		//get the root element
				Element docEle = dom.getDocumentElement();

				//get a nodelist of  elements
				
				NodeList nl = docEle.getChildNodes();
				if(nl != null && nl.getLength() > 0) {
					for(int i = 0 ; i < nl.getLength();i++) {
						//System.out.println(nl.item(i).getNodeName());
						if(nl.item(i).getNodeName().equals("week"))
						{
							int week = new Integer(nl.item(i).getAttributes().getNamedItem("week").getNodeValue()).intValue();
							NodeList nl2 = nl.item(i).getChildNodes();
							if(nl2 != null && nl2.getLength() > 0) {
								for(int j = 0 ; j < nl2.getLength();j++) {
									
									if(nl2.item(j).getNodeName().equals("game"))
									{
										
										//System.out.print(nl2.item(j).getAttributes().getNamedItem("home"));
										//System.out.print(" vs. ");
										//System.out.println(nl2.item(j).getAttributes().getNamedItem("away"));
										String home = nl2.item(j).getAttributes().getNamedItem("home").getNodeValue();
										String away = nl2.item(j).getAttributes().getNamedItem("away").getNodeValue();
										
										
										String s1 = "http://api.sportsdatallc.org/nfl-t1/" +
												year +
												"/REG/" +
												week +
												"/" +
												away +
												"/" +
												home +
												"/statistics.xml?api_key=" +
												"[your_api_key]";
												System.out.println(s1);
									}
								}
							}
							
						}
						//get the employee element
						//Element el = (Element)nl.item(i);
						/*
						
						//System.out.println(el.getAttribute("week"));
						NodeList nl2 = el.getChildNodes();
						System.out.println(el.hasChildNodes());
						for(int j = 0 ; el.hasChildNodes()&& j < nl2.getLength(); j++) {
							NamedNodeMap o = nl2.item(j).getAttributes();
							System.out.println(o.getNamedItem("home") + " vs. " +o.getNamedItem("away"));
						}*/
						//get the Employee object
						//Employee e = getEmployee(el);

						//add it to list
						//myEmpls.add(e);
					}
				}

		
		
		
		
		
		
		
		
		
}
}
