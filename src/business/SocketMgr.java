/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import java.io.*;
import domain.Login;



/**
 * The socket manager is responsible to compare the username/password with 
 * the "correct" username/password and pass back the authentication result 
 * to the connection manager.
 * @author root
 */
public class SocketMgr implements Serializable {
    private static final String USER_NAME = "Adam King";
    private static final String PASSWORD = "Jammin";
    
    public boolean valid(ObjectInputStream in) throws Exception
    {
        try {
            Login theLogin = (Login) in.readObject();
            if (theLogin.getUserName().equals(USER_NAME) && theLogin.getPassword().equals(PASSWORD))
                return true;
            //System.out.println(theLogin.getUserName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } 
        
       return true;
    }
            
}
