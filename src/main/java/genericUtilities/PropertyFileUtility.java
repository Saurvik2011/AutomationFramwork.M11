package genericUtilities;
import java.io.*;
import java.util.Properties;
/**
 * This class consists of generic methods to use property file
 * @author Ramesh Kumar Malkari
 * 
 */

public class PropertyFileUtility {
	
	/**
	 * This method will read data from property file and return value to the caller
	 * @param key
	 * 
	 * @return 
	 * @throws IOException
	 * 
	 */
	public String readDataFromPropertyFile(String key ) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
