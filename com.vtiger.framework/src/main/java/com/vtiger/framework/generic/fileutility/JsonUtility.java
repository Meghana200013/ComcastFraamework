package com.vtiger.framework.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsonFile(String Key) throws IOException, ParseException
	{
	FileReader fd = new FileReader(".\\configAppData\\viterjson.jso");
	JSONParser ps = new JSONParser();
	Object obj = ps.parse(fd);
	JSONObject map =(JSONObject)obj;
	 String data = map.get(Key).toString();
	  return data;
	
	
	}
	

}
