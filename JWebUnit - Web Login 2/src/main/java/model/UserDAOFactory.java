package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDAOFactory {

	private static Properties props = new Properties();
	
	public static UserDAO getUserDAO(){

		try {
			   Class daoClass = Class.forName( getClass("UserDAOImplementation") ); 
			   return (UserDAO) daoClass.newInstance();   
			  }
			  catch (ClassNotFoundException e) { 
			   e.printStackTrace();
			   return null;
			  }
			  catch (Exception e) {
			   e.printStackTrace();
			   return null;   
			  }
	}
	
	private static String getClass( String propertyName ) {
		  String className = null;
		  try {
			 ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		    InputStream input = classLoader.getResourceAsStream("config.properties");
		    props.load( input );    
		   	className = props.getProperty( propertyName, "");
		   if ( className.length() == 0)
		    return null;
		  }
		  catch ( FileNotFoundException e) { 
		   e.printStackTrace();
		  }
		  catch ( IOException e) {   
		   e.printStackTrace();
		  }
		  catch (Exception e) {
		   e.printStackTrace();
		  }
		  return className;
		 }
}
