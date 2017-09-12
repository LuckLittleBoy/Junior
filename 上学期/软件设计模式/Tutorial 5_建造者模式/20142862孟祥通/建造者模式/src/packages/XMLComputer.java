package packages;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class XMLComputer {

	@SuppressWarnings("rawtypes")
	public static Object getBean()
	{
		try
		{
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("bin/packages/config.xml"));
			
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(0).getFirstChild();
			String className = classNode.getNodeValue();
			
			System.out.println(className);
			Class c = Class.forName("packages."+className);
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
