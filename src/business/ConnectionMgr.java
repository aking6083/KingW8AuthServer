/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import java.net.*;
import java.io.*;

/**
 *
 * @author root
 */
public class ConnectionMgr {
    /*
    the connection manager is responsible for communication with the client. 
    It passes the client entered username/password to the socket manager and 
    sends back the authentication result to the client - via sockets.
    */
        ServerSocket server = null;
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        
    public ObjectInputStream getInStream()
    {return this.in;}
    
    public ObjectOutputStream getOutStrean()
    {return this.out;}
    
          
    public boolean startSvr()
    {
        //Start the server.
     
        try 
        {
            System.out.println("Awaiting Connection");
            server = new ServerSocket(8000, 100);
            this.socket = server.accept();
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    
    
    return true;
    }
}