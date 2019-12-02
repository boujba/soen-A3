package core.bis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileWriter;
import java.io.IOException;

import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;


import java.io.FileNotFoundException;
import java.io.FileReader;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;


public class Session {
    
  
    private String currentUser = null;
    
    public Session()
    {
        createJson();
    }
    
    public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
    
    public String getCurrentUser()
    {
        return currentUser;
    }


    public Boolean isUserLoggedIn()
    {  
        if(currentUser != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private static String[] parseUserObject(JSONObject user) 
    {
        String[] currentUser = {"",""};
       
        //Get employee object within list
        JSONObject userObject = (JSONObject) user.get("user");
         
        //Get Username
        String username = (String) userObject.get("username");    
        currentUser[0] = username;

        //Get Password
        String password = (String) userObject.get("password");  
        currentUser[1] = password;
        
        return currentUser;
    }
    
    public String login(String userName, String password)
    {
        ArrayList<String[]> allUsers = new ArrayList<>();
        
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("users.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray userList = (JSONArray) obj;
            System.out.println(userList);
            
            for (int i = 0; i < userList.size(); i++) {
              
               allUsers.add(parseUserObject((JSONObject)userList.get(i)));
            }
            
            for(String[] userObject: allUsers)
            {
                if(userObject[0].equals(userName))
                {
                    String generatedPass = getMd5(password);
                    
                    if(generatedPass.equals(userObject[1]))
                    {
                        //Authticated User
                        this.currentUser = userObject[0];
                        return "SUCCESS";
                    }
                }
            }       
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
           return "Invalid user credentials";
    }

  public Boolean logout()
    {
        this.currentUser = null;
        return true;
    }
    
    void createJson()
    { 
         
        JSONObject userDetails = new JSONObject();
        userDetails.put("username", "youssef");
        userDetails.put("password", getMd5("youssb"));
         
        JSONObject userObject = new JSONObject(); 
        userObject.put("user", userDetails);
         
  
        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(userObject);
      
        System.out.print(employeeList.toJSONString());
        
        //Write JSON file
        try (FileWriter file = new FileWriter("users.json")) {
 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    
}
    

