package business;
import java.io.*;
import domain.Login;
import java.net.Socket;




/**
 * The socket manager is responsible to compare the username/password with 
 * the "correct" username/password and pass back the authentication result 
 * to the requesting client
 * @author root
 */
public class SocketMgr implements Serializable, Runnable {
    private static final String USER_NAME = "Adam";
    private static final String PASSWORD = "Jammin";
    private Socket socket;
    
    public void run()     {
        System.out.println("Thread started");
        this.valid();
    }
        
    public void setSocket(Socket socket)
    {
        this.socket = socket;
    }
        
    public void valid() 
    {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        
        String isValid = "true";
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            Login theLogin = (Login) in.readObject();
            if (theLogin.getUserName().equals(USER_NAME))
            {
                char [] strPw = PASSWORD.toCharArray();
                char [] passPass = theLogin.getPassword();
                
                //Size of string
                if (theLogin.getPassword().length != PASSWORD.length())
                    isValid = "false";
                //I dont know why but .equals kept failing when I tried to comp
                //the password char array and the PASSWORD const char array.
                //So I had to do this.
                else 
                {
                    for (int a = 0;a<=theLogin.getPassword().length-1;a++)
                    {
                        if (!(strPw[a] == passPass[a]))
                            isValid = "false";
                    }
                }
            }
            else
                isValid = "false";

            out.writeObject(isValid);
            in.close();
            out.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        } 
        
      
    }
            
}
