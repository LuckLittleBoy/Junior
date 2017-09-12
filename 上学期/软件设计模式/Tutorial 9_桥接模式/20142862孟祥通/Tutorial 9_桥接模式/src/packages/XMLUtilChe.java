package packages;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class XMLUtilChe {

	@SuppressWarnings("rawtypes")
	public static Object getBean(String args)
	{
		try
		{
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("bin/packages/config.xml"));
			NodeList nl = null;
			Node classNode = null;
			String cName = null;
			
			nl = doc.getElementsByTagName("className");
			
			if(args.equals("road"))
			{
				classNode = nl.item(0).getFirstChild();
			}
			else if(args.equals("che"))
			{
				classNode = nl.item(1).getFirstChild();
			}
			else
			{
				return null;
			}
			cName = classNode.getNodeValue();
			
			Class c = Class.forName("packages."+cName);
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
