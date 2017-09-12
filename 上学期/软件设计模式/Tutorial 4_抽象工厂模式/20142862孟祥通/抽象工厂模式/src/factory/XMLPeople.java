package factory;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class XMLPeople {

	@SuppressWarnings("rawtypes")
	public static Object getBean()
	{
		try
		{
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("bin/factory/config.xml"));
			
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(0).getFirstChild();
			String className = classNode.getNodeValue();
			
			System.out.println(className);
			Class c = Class.forName("factory."+className);
			Object obj = c.newInstance();
			return obj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
}
