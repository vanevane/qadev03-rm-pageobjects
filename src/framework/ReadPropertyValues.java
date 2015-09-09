package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import rest.ResourcesRequests;

public class ReadPropertyValues {
//	InputStream inputStream;
	
	public static Properties getPropertyFile(String path)
	{
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(path);
			prop.load(input);
						
			return prop;

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {					
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
 
//	public static void main(String[] args) throws IOException {
//		ReadPropertyValues read = new ReadPropertyValues();
//		read.getPropValues();
//	}
}
