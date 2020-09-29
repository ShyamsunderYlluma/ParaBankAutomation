package com.parabank.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class GetProperty {

	Properties p = new Properties();
	public GetProperty(String filename) throws Exception{
		try{	
			FileInputStream file = new FileInputStream(filename);
			p.load(file);			
		}
		catch(Exception e){
			System.out.println("Failed to load the file");
			e.printStackTrace();
		}
	}
	public String getValue(String element) throws Exception
	{			
		return p.getProperty(element);
		
	}
}
