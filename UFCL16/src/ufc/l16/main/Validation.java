package ufc.l16.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static void main(String[] args) {
        Validation app = new Validation();
        app.validate("src\\userpass.properties");
    }
    private void validate(String filename) {
        try (InputStream input = new FileInputStream(filename)) {
            Properties prop = new Properties();
            prop.load(input);

            Enumeration e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                if(key.substring(key.length() - 4, key.length()).equals("name")) {
                    
                	if(!checkUsername(value)) {
                		throw new InvalidUserOrPasswordException();
                	}
                
                }else if(key.substring(key.length() - 4, key.length()).equals("word")) {
                	
                	if(!checkPassword(value)) {
                		throw new InvalidUserOrPasswordException();
                	}
                	
                }else {
                	
                	System.err.println("Failshi dapiksirda araswori formatis key");
                
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InvalidUserOrPasswordException e) {
        	e.getMessage();
        }
        
    }
    
    public static boolean checkUsername(String user) {
    	
    	user = user.trim();
    	
    	Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]{5,20}$");
    	Matcher matcher = pattern.matcher(user);
    	
		return matcher.matches();
    	
    }
    
    public static boolean checkPassword(String user) {
    	
    	user = user.trim();
    	
    	Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{7,}$");
    	Matcher matcher = pattern.matcher(user);
    	
		return matcher.matches();
    	
    }
    
}
