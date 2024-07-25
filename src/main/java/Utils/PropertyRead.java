package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyRead
{
	static String FilePath =System.getProperty("user.dir")+"\\Environment\\Property.properties";
	public static Properties ReadProperty() throws IOException
	{
		File f = new File(FilePath);
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);
		return p;
	}
}
